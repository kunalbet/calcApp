package com.calculator.tools;

import com.calculator.domain.OperationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelperTest {

    private Helper helper = new Helper();
    private String[] args = null;

    @Before
    public void setUp() throws Exception {
        args = new String[3];
    }

    @Test
    public void moreThan3Arguments() throws Exception {
        args = new String[4];
        args[0] = "3";
        args[1] = "4";
        args[2] = "5";
        args[3] = "6";
        Assert.assertEquals("Please enter Operand Operation Operand separated by space", helper.validateInput(args));
    }

    @Test
    public void lessThan3Arguments() throws Exception {
        args = new String[2];
        args[0] = "3";
        args[1] = "+";
        Assert.assertEquals("Please enter Operand Operation Operand separated by space", helper.validateInput(args));
    }

    @Test
    public void acceptableOperation() throws Exception {
        args[0] = "3";
        args[1] = "+";
        args[2] = "4";
        Assert.assertNull(helper.validateInput(args));
    }

    @Test
    public void notAcceptableOperation() throws Exception {
        args[0] = "3";
        args[1] = "%";
        args[2] = "4";
        Assert.assertEquals("Please enter one of the Operation (+, -, * , /)", helper.validateInput(args));
    }

    @Test
    public void acceptableOperandsInteger() throws Exception {
        args[0] = "3";
        args[1] = "+";
        args[2] = "4";
        Assert.assertNull(helper.validateInput(args));
    }

    @Test
    public void acceptableOperandsDouble() throws Exception {
        args[0] = "3.54";
        args[1] = "+";
        args[2] = "4.23";
        Assert.assertNull(helper.validateInput(args));
    }

    @Test
    public void notAcceptableOperandsNegativeInteger() throws Exception {
        args[0] = "-3";
        args[1] = "+";
        args[2] = "4";
        Assert.assertEquals("Input operands don't match acceptable Operands format", helper.validateInput(args));
    }

    @Test
    public void notAcceptableOperandsNegativeDouble() throws Exception {
        args[0] = "3";
        args[1] = "+";
        args[2] = "-1.34";
        Assert.assertEquals("Input operands don't match acceptable Operands format", helper.validateInput(args));
    }

    @Test
    public void getOperationTypeValidOperationProvided() throws Exception {
        Assert.assertNotNull(helper.getOperationType("*"));
    }

    @Test
    public void getOperationTypeInValidOperationProvided() throws Exception {
        Assert.assertNull(helper.getOperationType("!"));
    }

    @Test
    public void getResultValidData() throws Exception {
        Assert.assertEquals("87", helper.getResult("435", OperationType.DIVISION, "5"));
    }

    @Test
    public void getResultInValidData() throws Exception {
        Assert.assertEquals("Exception: java.lang.NumberFormatException: For input string: \"4dfgdfg35\"",
                helper.getResult("4dfgdfg35", OperationType.SUBTRACTION, "5"));
    }

}