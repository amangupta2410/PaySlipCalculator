package com.payslip;

public class Tax {
	private final float baseTax;
    private final float percentage;
    private final long fromIncome;

    public Tax(float baseTax, float percentage, long fromIncome) {
        this.baseTax = baseTax;
        this.percentage = percentage;
        this.fromIncome = fromIncome;
    }

    public float getBaseTax() {
        return baseTax;
    }

    public float getPercentage() {
        return percentage;
    }

    public long getFromIncome() {
        return fromIncome;
    }
}
