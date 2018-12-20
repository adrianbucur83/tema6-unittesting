package com.siit.adi;

import static com.siit.adi.UnitOfMeasurement.*;

public class Main {

    public static void main(String[] args) {


        Calculator calc = new Calculator("10 cm + 1 m - 10 mm", MM);

        calc.evaluateExpression();
        System.out.println("Result is: " + calc.compute() + " " + calc.getDesiredUnitOfMeasurement());

        StatisticsRepo stats = new StatisticsRepo();

        stats.measureRunTimeEvaluate();
        stats.measureRunTimeCompute();


    }

}
