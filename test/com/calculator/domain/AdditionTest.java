package com.calculator.domain;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdditionTest {
    Addition addition = new Addition();

    @Test
    public void performOperation_both_Integers() throws Exception {
        Assert.assertEquals("77", addition.performOperation("23", "54"));
    }

    @Test
    public void performOperation_No_Thousand_Separator() throws Exception {
        Assert.assertEquals("29247688", addition.performOperation("23564234", "5683454"));
    }

    @Test
    public void performOperation_both_Double() throws Exception {
        Assert.assertEquals("77.26", addition.performOperation("23.13", "54.13"));
    }

    @Test
    public void performOperation_Integer_Double() throws Exception {
        Assert.assertEquals("77.25", addition.performOperation("23", "54.25"));
    }

    @Test
    public void performOperation_Double_Integer() throws Exception {
        Assert.assertEquals("77.56", addition.performOperation("23.56", "54"));
    }

    @Test
    public void performOperation_InvalidOperand() throws Exception {
        Assert.assertEquals("Exception: java.lang.NumberFormatException: For input string: \"we\"", addition.performOperation("we", "54"));
    }
}