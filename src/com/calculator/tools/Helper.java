/*
 * Copyright Western Australian Land Information Authority 2017
 */
package com.calculator.tools;

import com.calculator.Calculator;
import com.calculator.OperationFactory;
import com.calculator.domain.Operation;
import com.calculator.domain.OperationType;

import java.util.Arrays;
import java.util.Optional;

public class Helper {

    public String validateInput(String[] args) {
        if(args.length != 3) {
            return "Please enter Operand Operation Operand separated by space";
        } else if (args[1].length() > 1) {
            return "Please enter one of the Operation (+, -, * , /)";
        } else {
            if ((!args[0].matches(Calculator.integerRegEx) && !args[0].matches(Calculator.doubleRegEx)) ||
                    (!args[2].matches(Calculator.integerRegEx) && !args[2].matches(Calculator.doubleRegEx))) {
                return "Input operands don't match acceptable Operands format";
            }
            OperationType operationType = this.getOperationType(args[1]);
            return operationType == null ? "Please enter one of the Operation (+, -, * , /)": null;
        }
    }

    public OperationType getOperationType(String operationStr) {
        Optional<OperationType> optional =  Arrays.stream(OperationType.values())
                .filter(operationType ->  operationType.getSymbol().equals(operationStr))
                .findFirst();
        return optional.orElse(null);
    }

    public String getResult(String input1, OperationType operationType, String input2) {
        Operation operation = OperationFactory.getOperation(operationType);
        return operation.performOperation(input1, input2);
    }
}
