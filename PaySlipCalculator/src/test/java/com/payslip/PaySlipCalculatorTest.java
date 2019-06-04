package com.payslip;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaySlipCalculatorTest {

	private static final long ANNUAL_SALARY = 60050;

    @InjectMocks
    private PaySlipCalculator paySlipCalculator;

    @Mock
    private TaxCalculator taxCalculator;

    @Test
    public void testGenerateWillCalculateGrossIncomeForSuppliedSalary() {
        PaySlipDetails payslipDetails = paySlipCalculator.generate(new Employee(ANNUAL_SALARY, 9.0f));

        assertThat(payslipDetails.getGrossIncome(), is(5004L));
    }

    @Test
    public void testGenerateWillCalculateIncomeTaxForSuppliedSalary() {
        when(taxCalculator.calculateIncomeTax(ANNUAL_SALARY)).thenReturn(11063.25);

        PaySlipDetails payslipDetails = paySlipCalculator.generate(new Employee(ANNUAL_SALARY, 9.0f));

        assertThat(payslipDetails.getIncomeTax(), is(922L));
    }

    @Test
    public void testGenerateWillCalculateNetIncomeForSuppliedSalary() {
        when(taxCalculator.calculateIncomeTax(ANNUAL_SALARY)).thenReturn(11063.25);

        PaySlipDetails payslipDetails = paySlipCalculator.generate(new Employee(ANNUAL_SALARY, 9.0f));

        assertThat(payslipDetails.getNetIncome(), is(4082L));
    }

    @Test
    public void testGenerateWillCalculateSuperForSuppliedSalary() {
        PaySlipDetails payslipDetails = paySlipCalculator.generate(new Employee(ANNUAL_SALARY, 9.0f));

        assertThat(payslipDetails.getSuperAmount(), is(450L));
    }

    @Test
    public void testGenerateWillCalculateNoSuperWhenSuperRateIsZero() {
        PaySlipDetails payslipDetails = paySlipCalculator.generate(new Employee(ANNUAL_SALARY, 0f));

        assertThat(payslipDetails.getSuperAmount(), is(0L));
    }

}
