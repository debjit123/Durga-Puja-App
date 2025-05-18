package com.jadavpur.durgamandir.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stake_holder")
public class StakeHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "stake_holder_id")
	private int stakeHolderId;

	@Column(name = "stake_holder_name")
	private String stakeHolderName;

	@Column(name = "stake_holder_percentage")
	private double stakeHolderPercentage;

	@Column(name = "stake_holder_contact_number")
	private String stakeHolderContactNumber;

	@Column(name = "stake_holder_email")
	private String stakeHolderEmail;

	@Column(name = "expense_on_puja")
	private double expenseOnPuja;

	@Column(name = "expense_on_binodon")
	private double expenseOnBinodon;

	public double getExpenseOnBinodon() {
		return expenseOnBinodon;
	}

	public void setExpenseOnBinodon(double expenseOnBinodon) {
		this.expenseOnBinodon = expenseOnBinodon;
	}

	public double getExpenseOnPuja() {
		return expenseOnPuja;
	}

	public void setExpenseOnPuja(double expenseOnPuja) {
		this.expenseOnPuja = expenseOnPuja;
	}

	public int getStakeHolderId() {
		return stakeHolderId;
	}

	public void setStakeHolderId(int stakeHolderId) {
		this.stakeHolderId = stakeHolderId;
	}

	public String getStakeHolderName() {
		return stakeHolderName;
	}

	public void setStakeHolderName(String stakeHolderName) {
		this.stakeHolderName = stakeHolderName;
	}

	public double getStakeHolderPercentage() {
		return stakeHolderPercentage;
	}

	public void setStakeHolderPercentage(double stakeHolderPercentage) {
		this.stakeHolderPercentage = stakeHolderPercentage;
	}

	public String getStakeHolderContactNumber() {
		return stakeHolderContactNumber;
	}

	public void setStakeHolderContactNumber(String stakeHolderContactNumber) {
		this.stakeHolderContactNumber = stakeHolderContactNumber;
	}

	public String getStakeHolderEmail() {
		return stakeHolderEmail;
	}

	public void setStakeHolderEmail(String stakeHolderEmail) {
		this.stakeHolderEmail = stakeHolderEmail;
	}

}