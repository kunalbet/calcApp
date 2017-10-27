package com.calculator.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest {

    Division division = new Division();

    @Test
    public void performOperation_both_Integers() throws Exception {
        Assert.assertEquals("9", division.performOperation("45", "5"));
    }

    @Test
    public void performOperation_divide_by_zero() throws Exception {
        Assert.assertEquals("Exception: java.lang.ArithmeticException: / by zero", division.performOperation("45", "0"));
    }

    @Test
    public void performOperation_both_Double() throws Exception {
        Assert.assertEquals("3.9470404984423677", division.performOperation("12.67", "3.21"));
    }

    @Test
    public void performOperation_Integer_Double() throws Exception {
        Assert.assertEquals("13.6", division.performOperation("34", "2.5"));
    }

    @Test
    public void performOperation_Double_Integer() throws Exception {
        Assert.assertEquals("14.195", division.performOperation("56.78", "4"));
    }

    @Test
    public void performOperation_InvalidOperand() throws Exception {
        Assert.assertEquals("Exception: java.lang.NumberFormatException: For input string: \"we\"", division.performOperation("we", "54"));
    }

}