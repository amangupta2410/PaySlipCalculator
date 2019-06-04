package com.payslip;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaxableIncomeTest {

	@Test
	public void testIsWithinRangeWillReturnTrueWhenSalaryIsBetweenFromAndToMarks() {
		TaxableIncome taxableIncome = new TaxableIncome(37001, 87000);

		assertTrue(taxableIncome.isWithinRange(60050));
	}

	@Test
	public void testIsWithinRangeWillReturnFalseWhenSalaryIsLowerThenStartMark() {
		TaxableIncome taxableIncome = new TaxableIncome(37001, 87000);

		assertFalse(taxableIncome.isWithinRange(37000));
	}

}
