package com.payslip;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PaySlipDetails {
	private String paymentPeriod;
	private String employeeFirstName;
	private String employeeLastName;
	private long incomeTax;
	private long grossIncome;
	private long netIncome;
	private long superAmount;

	public PaySlipDetails(String paymentPeriod, String employeeFirstName, String employeeLastName,
                          long grossIncome, long incomeTax, long netIncome, long superAmount) {
        this.paymentPeriod = paymentPeriod;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superAmount = superAmount;
    }

	public long getIncomeTax() {
		return incomeTax;
	}

	public long getGrossIncome() {
		return grossIncome;
	}

	public long getNetIncome() {
		return netIncome;
	}

	public long getSuperAmount() {
		return superAmount;
	}

	/**
	 * Converts into CSV format to be returned to user. NOTE: does not handle commas
	 * already in the fields.
	 */
	public String toCsv() {
		return Stream
				.of(employeeFirstName, employeeLastName, paymentPeriod, grossIncome, incomeTax, netIncome, superAmount)
				.map(Object::toString).collect(Collectors.joining(","));
	}
}
