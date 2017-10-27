/*
 * Copyright Western Australian Land Information Authority 2017
 */
package com.calculator;

import com.calculator.domain.Addition;
import com.calculator.domain.Division;
import com.calculator.domain.Multiplication;
import com.calculator.domain.Operation;
import com.calculator.domain.OperationType;
import com.calculator.domain.Subtraction;

public class OperationFactory {

    public static Operation getOperation(OperationType operationType) {
        switch(operationType) {
            case ADDITION:
                return new Addition();
            case SUBTRACTION:
                return new Subtraction();
            case MULTIPLICATION:
                return new Multiplication();
            case DIVISION:
                return new Division();
        }
        return null;
    }
}
