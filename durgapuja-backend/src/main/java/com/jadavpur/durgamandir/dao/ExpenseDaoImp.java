package com.jadavpur.durgamandir.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.jadavpur.durgamandir.dto.ExpenseDto;
import com.jadavpur.durgamandir.model.Expense;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
//These above annotations are used to indicate that this class is a DAO component and that it should be managed by Spring's container.
// The @Transactional annotation indicates that the methods in this class should be executed within a transaction context.
// We can not write these anotation in the ExpenseDao interface.
public class ExpenseDaoImp implements ExpenseDao {

	EntityManager entityManager;
	
	@Autowired
	public ExpenseDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public ResponseEntity<ExpenseDto> addExpense(Expense expense) {
		
		entityManager.persist(expense);
		ExpenseDto expenseDto = new ExpenseDto();
		expenseDto.setExpenseAmount(expense.getExpenseAmount());
		expenseDto.setExpenseType(expense.getExpenseType());
		expenseDto.setExpenseItem(expense.getExpenseItem());
		expenseDto.setPurchaseDate(expense.getPurchaseDate());

		return ResponseEntity.ok(expenseDto);
	} 
	
	@Override
	public List<Expense> findByMonth(int month) {
		return entityManager.createQuery("SELECT e FROM Expense e WHERE MONTH(e.purchaseDate) = :month", Expense.class)
				.setParameter("month", month).getResultList();
		
	}

	@Override
	public List<Expense> getAllExpense() {
		return entityManager.createQuery("SELECT e FROM Expense e", Expense.class).getResultList();
	}

	

}
