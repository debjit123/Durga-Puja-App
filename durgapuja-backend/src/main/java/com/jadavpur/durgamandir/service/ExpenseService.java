package com.jadavpur.durgamandir.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jadavpur.durgamandir.dto.ExpenseDto;

@Service
public interface ExpenseService {
	
	public ResponseEntity<ExpenseDto> addExpense(ExpenseDto expenseDto);

	public List<ExpenseDto> getExpense(int month);

	public List<ExpenseDto> getAllExpense();
	
	Map<String, List<Double>> getTotalExpenseAmountByType();

	
	

}
