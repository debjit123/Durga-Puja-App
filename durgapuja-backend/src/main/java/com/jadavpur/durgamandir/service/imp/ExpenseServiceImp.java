package com.jadavpur.durgamandir.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.jadavpur.durgamandir.dao.ExpenseDao;
import com.jadavpur.durgamandir.dto.ExpenseDto;
import com.jadavpur.durgamandir.model.Expense;
import com.jadavpur.durgamandir.service.ExpenseService;

@Component
public class ExpenseServiceImp implements ExpenseService {

	private ExpenseDao expenseDao;

	@Autowired
	public ExpenseServiceImp(ExpenseDao expenseDao) {
		this.expenseDao = expenseDao;
	}

	@Override
	public ResponseEntity<ExpenseDto> addExpense(ExpenseDto expenseDto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername(); // Extract username from JWT
		Expense newExpense = new Expense();
		newExpense.setExpenseAmount(expenseDto.getExpenseAmount());
		newExpense.setExpenseType(expenseDto.getExpenseType());
		newExpense.setExpenseItem(expenseDto.getExpenseItem());
		newExpense.setPurchaseDate(new Date());
		newExpense.setCreateUser(username); // Set the username from JWT
		return expenseDao.addExpense(newExpense);

	}

	@Override
	public List<ExpenseDto> getExpense(int month) {
		List<Expense> expenses = expenseDao.findByMonth(month);
		return expenses.stream().map(expense -> {
			ExpenseDto expenseDto = new ExpenseDto();
			expenseDto.setExpenseAmount(expense.getExpenseAmount());
			expenseDto.setExpenseType(expense.getExpenseType());
			expenseDto.setExpenseItem(expense.getExpenseItem());
			expenseDto.setPurchaseDate(expense.getPurchaseDate());
			expenseDto.setCreateUser(expense.getCreateUser());
			return expenseDto;
		}).toList();
	}

	@Override
	public List<ExpenseDto> getAllExpense() {
		List<Expense> expenses = expenseDao.getAllExpense();
		return expenses.stream().map(expense -> {
			ExpenseDto expenseDto = new ExpenseDto();
			expenseDto.setExpenseAmount(expense.getExpenseAmount());
			expenseDto.setExpenseType(expense.getExpenseType());
			expenseDto.setExpenseItem(expense.getExpenseItem());
			expenseDto.setPurchaseDate(expense.getPurchaseDate());
			expenseDto.setCreateUser(expense.getCreateUser());
			return expenseDto;
		}).toList();
	}

	@Override
	public Map<String, List<Double>> getTotalExpenseAmountByType() {

		List<String> expenseTypes = new ArrayList<>();
		expenseTypes.add("Binodon");
		expenseTypes.add("Pooja Purpose");

		Map<String, List<Double>> result = new HashMap<>();

		for (String type : expenseTypes) {
			List<Double> amounts = expenseDao.getAllExpense().stream()
					.filter(expense -> expense.getExpenseType().equalsIgnoreCase(type)).map(Expense::getExpenseAmount)
					.toList();
			result.put(type, amounts);
		}

		return result;
	}

}
