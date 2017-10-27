/*
 * Copyright Western Australian Land Information Authority 2017
 */
package com.calculator.domain;

public enum OperationType {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String symbol;

    private OperationType(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
