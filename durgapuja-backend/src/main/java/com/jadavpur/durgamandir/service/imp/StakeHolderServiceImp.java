package com.jadavpur.durgamandir.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.jadavpur.durgamandir.dao.StakeHolderDao;
import com.jadavpur.durgamandir.dto.StakeHolderDto;
import com.jadavpur.durgamandir.model.StakeHolder;
import com.jadavpur.durgamandir.service.ExpenseService;
import com.jadavpur.durgamandir.service.StakeHolderService;

@Component
public class StakeHolderServiceImp implements StakeHolderService {

	private final StakeHolderDao stakeHolderDao;
	private final ExpenseService expenseService;

	public StakeHolderServiceImp(StakeHolderDao stakeHolderDao, ExpenseService expenseService) {
		this.stakeHolderDao = stakeHolderDao;
		this.expenseService = expenseService;
	}

	@Override
	public List<StakeHolderDto> calculateExpenseForEachStakeHolder() {

		Map<String, List<Double>> totalExpenseAmount = expenseService.getTotalExpenseAmountByType();
		double totalBinodonAmount = 0;
		double totalPujaPurposeAmount = 0;

		for (Map.Entry<String, List<Double>> entry : totalExpenseAmount.entrySet()) {
			double totalAmount = entry.getValue().stream().mapToDouble(Double::doubleValue).sum();
			if (entry.getKey().equals("Binodon")) {
				totalBinodonAmount = totalAmount;
			} else if (entry.getKey().equals("Pooja Purpose")) {
				totalPujaPurposeAmount = totalAmount;
			}
		}

		List<StakeHolder> stakeHolders = stakeHolderDao.findAll();
		int stakeHolderCount = stakeHolders.size();

		double perStakeHolderBinodonAmount = totalBinodonAmount / stakeHolderCount;

		for (StakeHolder stakeHolder : stakeHolders) {
			double percentage = stakeHolder.getStakeHolderPercentage();
			double pujaPurposeExpense = (percentage / 100) * totalPujaPurposeAmount;

			stakeHolder.setExpenseOnPuja(pujaPurposeExpense);
			stakeHolder.setExpenseOnBinodon(perStakeHolderBinodonAmount);
			stakeHolderDao.save(stakeHolder);
		}
		return stakeHolders.stream().map(stakeHolder -> {
			StakeHolderDto stakeHolderDto = new StakeHolderDto();
			stakeHolderDto.setStakeHolderName(stakeHolder.getStakeHolderName());
			stakeHolderDto.setStakeHolderExpensePuja(stakeHolder.getExpenseOnPuja());
			stakeHolderDto.setStakeHolderExpenseOnBinodon(stakeHolder.getExpenseOnBinodon());
			stakeHolderDto.setStakeHolderExpenseTotal(stakeHolder.getExpenseOnPuja(), stakeHolder.getExpenseOnBinodon());
			return stakeHolderDto;
		}).toList();
	}
}
