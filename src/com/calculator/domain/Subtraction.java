/*
 * Copyright Western Australian Land Information Authority 2017
 */
package com.calculator.domain;

import com.calculator.Calculator;

public class Subtraction implements Operation {

    @Override
    public String performOperation(String input1, String input2) {

        try {
            if (input1.matches(Calculator.integerRegEx) && input2.matches(Calculator.doubleRegEx)) {
                return Double.toString(Integer.parseInt(input1) - Double.parseDouble(input2));
            } else if (input1.matches(Calculator.doubleRegEx) && input2.matches(Calculator.integerRegEx)) {
                return Double.toString(Double.parseDouble(input1) - Integer.parseInt(input2));
            } else if (input1.matches(Calculator.doubleRegEx) && input2.matches(Calculator.doubleRegEx)) {
                return Double.toString(Double.parseDouble(input1) - Double.parseDouble(input2));
            } else {
                // both are integers
                return Integer.toString(Integer.parseInt(input1) - Integer.parseInt(input2));
            }
        } catch (Exception e) {
            return "Exception: " + e.toString();
        }
    }
}
