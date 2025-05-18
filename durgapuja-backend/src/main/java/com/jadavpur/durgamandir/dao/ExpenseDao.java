package com.jadavpur.durgamandir.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jadavpur.durgamandir.dto.ExpenseDto;
import com.jadavpur.durgamandir.model.Expense;


public interface ExpenseDao  {

	ResponseEntity<ExpenseDto> addExpense(Expense expense);
	List<Expense> findByMonth(int month);
	List<Expense> getAllExpense();

}
