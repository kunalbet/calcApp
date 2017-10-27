package com.calculator;

import com.calculator.domain.OperationType;
import com.calculator.tools.Helper;

public class Calculator {

    public static String integerRegEx = "^[0-9]+$";
    public static String doubleRegEx = "^[0-9]+[.][0-9]*$";

    public static void main(String[] args) {
        Helper helper = new Helper();
        String error = helper.validateInput(args);
        if ( error == null) {
            String operand1 = args[0];
            OperationType operationType = helper.getOperationType(args[1]);
            String operand2 = args[2];
            System.out.println("INPUT: = " + operand1 + " " + operationType + " " + operand2);
            System.out.println("RESULT: = " + helper.getResult(operand1, operationType, operand2));
        } else {
            System.out.println(error);
        }
    }
}
