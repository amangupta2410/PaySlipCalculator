package com.payslip;

public class PaySlipCalculator {

	private static final int MONTHS_IN_YEAR = 12;

    private final TaxCalculator taxCalculator;

    public PaySlipCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public PaySlipDetails generate(Employee employee) {
        long grossIncome = calculateGrossIncome(employee.getAnnualSalary());
        long incomeTax = calculateIncomeTax(employee.getAnnualSalary());
        long netIncome = grossIncome - incomeTax;
        long superAmount = calculateSuperAmount(employee.getSuperRate(), grossIncome);
        return new PaySlipDetails(employee.getPaymentPeriod(), employee.getFirstName(), employee.getLastName(),
                grossIncome, incomeTax, netIncome, superAmount);
    }

    private long calculateIncomeTax(long annualSalary) {
        return Math.round(taxCalculator.calculateIncomeTax(annualSalary) / MONTHS_IN_YEAR);
    }

    private long calculateSuperAmount(float superRate, long grossIncome) {
        return Math.round(grossIncome * (superRate / 100));
    }

    private long calculateGrossIncome(long annualSalary) {
        return Math.round((double) annualSalary / MONTHS_IN_YEAR);
    }}
