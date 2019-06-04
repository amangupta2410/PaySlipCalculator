package com.payslip;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TaxCalculator {
	private final Map<TaxableIncome, Tax> taxBracketsReference = new HashMap<>();

    /**
     * Configure tax details based on the salary ranges. If tax is not applicable simple provide 0 value for baseTax and taxPerDollarRate.
     * If this was a Spring Boot CLI application, then we would use proper configuration.
     */
    public void addTax(long incomeFrom, long incomeTo, float baseTax, float taxPerDollarRate) {
        taxBracketsReference.put(new TaxableIncome(incomeFrom, incomeTo), new Tax(baseTax, taxPerDollarRate, incomeFrom - 1));
    }

    /**
     * Will calculate tax based on tax brackets and provided salary.
     * <p>
     * Will throw IllegalStateException if tax has not been configured for provided salary.
     */
    public double calculateIncomeTax(long annualSalary) {
        Optional<Tax> tax = getTaxFor(annualSalary);
        if (!tax.isPresent()) {
            throw new IllegalStateException(String.format("Could not file tax for '%s' income", annualSalary));
        }
        Tax taxDetails = tax.get();
        return taxDetails.getBaseTax() + ((annualSalary - taxDetails.getFromIncome()) * (taxDetails.getPercentage() / 100));
    }

    private Optional<Tax> getTaxFor(long income) {
        return taxBracketsReference.entrySet().stream()
                .filter(taxableIncomeTaxEntry -> taxableIncomeTaxEntry.getKey().isWithinRange(income))
                .map(Map.Entry::getValue)
                .findAny();
    }
}
