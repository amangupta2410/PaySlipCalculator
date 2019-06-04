package com.payslip;

import org.junit.Test;

public class EmployeeTest {

	@Test(expected = IllegalArgumentException.class)
	public void testThrowsValidationErroWhenEmployeeSalaryAmountIsNegative() {
		new Employee("","",-1,0.0f,"");
	}

}
