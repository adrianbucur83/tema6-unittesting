package com.siit.adi;/*
Write a calculator that is capable of computing a metric distance value from an expression that contains different scales and systems.
        Output should be specified by the user.
        Only Addition and subtraction is allowed.
        Implement the calculator and write unit tests that prove that the computations are correct.
       Supported formats: mm, cm, dm, m, km

        Examples:
        Output is in lowest unit.
        Expression: 10 cm + 1 m - 10 mm
        Result: 1090 mm
*/


import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Calculator {

    private String expression;
    private UnitOfMeasurement desiredUnitOfMeasurement;

    private String[] elements;


    public Calculator(String expression, UnitOfMeasurement desiredUnitOfMeasurement) {
        this.expression = expression;
        this.desiredUnitOfMeasurement = desiredUnitOfMeasurement;
        elements = StringUtils.splitString(expression, " ");
    }

    private boolean isNumber(String str) {
        return str.matches("^(?:(?:\\-{1})?\\d+(?:\\.{1}\\d+)?)$");  //match a number with optional '-' and decimal.
    }

    private boolean isOperator(String str) {

        return str.matches("[+-]");
    }

    private boolean isUnitofMeasurement(String str) {

        for (UnitOfMeasurement u : UnitOfMeasurement.values()) {
            if (u.name().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public void evaluateExpression() {
        boolean isValid = true;

        for (int i = 0; i < elements.length; i += 3) {
            if (!isNumber(elements[i])) {
                isValid = false;
                throw new InputException("Invalid expresion - not a number at position " + (i + 1));
            }
        }

        for (int i = 1; i < elements.length; i += 3) {
            if (!isUnitofMeasurement(elements[i])) {
                isValid = false;
                throw new InputException("Invalid expresion - not a unit of measurement at position " + (i + 1));
            }
        }

        for (int i = 2; i < elements.length; i += 3) {
            if (!isOperator(elements[i])) {
                isValid = false;
                throw new InputException("Invalid expresion - invalid operator at position " + (i + 1));
            }
        }
        if (isValid)
            System.out.println("Expression is valid");

    }


    public String getDesiredUnitOfMeasurement() {
        return desiredUnitOfMeasurement.name();
    }

    public double compute() {

        double result = 0;
        List<Double> valuesInMillimeters = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            if (isNumber(elements[i])) {
                int multiplier = 1;
                int operator = 1;

                for (UnitOfMeasurement u : UnitOfMeasurement.values()) {
                    if (u.name().equalsIgnoreCase(elements[i + 1])) {
                        multiplier = u.getMultiplier();
                    }
                }

                if (i > 1) {
                    if (elements[i - 1].equalsIgnoreCase("-")) {
                        operator = -1;
                    }
                }

                valuesInMillimeters.add((Double.parseDouble(elements[i]) * multiplier * operator));

            }
        }


        for (Double value : valuesInMillimeters) {
            result += value;
        }

        result /= desiredUnitOfMeasurement.getMultiplier();

/*
        // For testing only:

        System.out.println("The values in millimeters are " + valuesInMillimeters);

        for (String element : elements) {
            System.out.println(element);
        }*/

        return result;
    }

}



