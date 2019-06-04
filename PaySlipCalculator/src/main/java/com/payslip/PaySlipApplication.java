package com.payslip;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.function.Function;

public class PaySlipApplication {

	
	private PaySlipCalculator paySlipCalculator;

    public PaySlipApplication(PaySlipCalculator paySlipCalculator) {
        this.paySlipCalculator = paySlipCalculator;
    }

    public static void main(String[] args) {
        // If this was a Spring boot app the following would be done using Spring dependency injection mechanism.
        PaySlipCalculator paySlipCalculator = new PaySlipCalculator(setupSampleTaxCalculator());
        PaySlipApplication paySlipApplication = new PaySlipApplication(paySlipCalculator);
        paySlipApplication.generatePayslip(System.in, System.out);
    }

    public void generatePayslip(InputStream inputStream, PrintStream outputStream) {
  //      BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, defaultCharset()));
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        in.lines()
                .filter(line -> !line.isEmpty())
                .map(convertToEmployee())
                .map(paySlipCalculator::generate)
                .forEach(payslipDetails -> outputStream.println(payslipDetails.toCsv()));
    }

    private Function<String, Employee> convertToEmployee() {
        return csvLine -> {
            String[] fields = readCsvFields(csvLine);

            long annualSalary = Long.parseLong(fieldData(fields[2]));
            float superRate = Float.parseFloat(fieldData(fields[3]).replace("%", ""));
            return new Employee(fieldData(fields[0]), fieldData(fields[1]), annualSalary,
                    superRate, fieldData(fields[4]));
        };
    }

    private String[] readCsvFields(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 5) {
            throw new IllegalArgumentException("Wrong format of the CSV input");
        }
        return fields;
    }

    private String fieldData(String field) {
        return field.trim();
    }

    private static TaxCalculator setupSampleTaxCalculator() {
        TaxCalculator taxCalculator = new TaxCalculator();
        // If this was a Spring boot cli app the following would come form Configuration.
        taxCalculator.addTax(0, 18200, 0, 0);
        taxCalculator.addTax(18201, 37000, 0, 19);
        taxCalculator.addTax(37001, 80000, 3572, 32.5f);
        taxCalculator.addTax(80001, 180000, 17547, 37f);
        taxCalculator.addTax(180001, Long.MAX_VALUE, 54547, 45f);
        return taxCalculator;
    }
	
	
	
}
