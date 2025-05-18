package com.jadavpur.durgamandir.dto;

public class StakeHolderDto {

	private String stakeHolderName;
	private double stakeHolderExpenseOnBinodon;
	private double stakeHolderExpensePuja;
	private double stakeHolderExpenseTotal;
	
	public double getStakeHolderExpenseTotal() {
		return stakeHolderExpenseTotal;
	}

	public void setStakeHolderExpenseTotal(double stakeHolderExpenseOnBinodon, double stakeHolderExpensePuja) {
		this.stakeHolderExpenseTotal = stakeHolderExpenseOnBinodon + stakeHolderExpensePuja;
	}
	
	public String getStakeHolderName() {
		return stakeHolderName;
	}

	public void setStakeHolderName(String stakeHolderName) {
		this.stakeHolderName = stakeHolderName;
	}

	public double getStakeHolderExpenseOnBinodon() {
		return stakeHolderExpenseOnBinodon;
	}

	public void setStakeHolderExpenseOnBinodon(double stakeHolderExpenseOnBinodon) {
		this.stakeHolderExpenseOnBinodon = stakeHolderExpenseOnBinodon;
	}

	public double getStakeHolderExpensePuja() {
		return stakeHolderExpensePuja;
	}

	public void setStakeHolderExpensePuja(double stakeHolderExpensePuja) {
		this.stakeHolderExpensePuja = stakeHolderExpensePuja;
	}
}
