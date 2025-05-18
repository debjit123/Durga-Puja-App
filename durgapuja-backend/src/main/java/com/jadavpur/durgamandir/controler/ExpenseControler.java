package com.jadavpur.durgamandir.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jadavpur.durgamandir.dto.ExpenseDto;
import com.jadavpur.durgamandir.dto.StakeHolderDto;
import com.jadavpur.durgamandir.service.ExpenseService;
import com.jadavpur.durgamandir.service.StakeHolderService;

@RestController
@RequestMapping("/expense")
public class ExpenseControler {

	private ExpenseService expenseService;
	private StakeHolderService stakeHolderService;

	@Autowired
	public ExpenseControler(ExpenseService expenseService , StakeHolderService stakeHolderService) {
		this.expenseService = expenseService;
		this.stakeHolderService = stakeHolderService;
	}

	@PostMapping("/add-expense")
	public ResponseEntity<ExpenseDto> addExpense(@RequestBody ExpenseDto expenseDto) {

		// Validate the input data
		if (expenseDto.getExpenseAmount() <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return expenseService.addExpense(expenseDto);
	}

	@GetMapping("/get-expense/{month}")
	public ResponseEntity<List<ExpenseDto>> getExpense(@PathVariable int month) {

		List<ExpenseDto> expenseDto = expenseService.getExpense(month);

		if (expenseDto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(expenseDto, HttpStatus.OK);

	}
	@GetMapping("/get-all-expenses")
	public ResponseEntity<List<ExpenseDto>> getAllExpense() {

		List<ExpenseDto> expenseDto = expenseService.getAllExpense();

		if (expenseDto.isEmpty() || expenseDto == null || expenseDto.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(expenseDto, HttpStatus.OK);

	}
	@GetMapping("/generate-stakeholder-expense")
	public ResponseEntity<List<StakeHolderDto>> generateStakeholderExpense() {

		List<StakeHolderDto> stakeHolderDto = stakeHolderService.calculateExpenseForEachStakeHolder();

        if (stakeHolderDto.isEmpty() || stakeHolderDto == null || stakeHolderDto.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(stakeHolderDto, HttpStatus.OK);

    }
}
