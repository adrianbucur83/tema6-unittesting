package com.siit.adi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

import static com.siit.adi.UnitOfMeasurement.*;


public class StatisticsRepo {

    public Map<String, Long> runTimes = new HashMap<>();
    private Calculator calc = new Calculator("10 cm + 1 km - 0.8 km + 1 dm", CM);

    public void measureRunTimeEvaluate() {

        StopWatch stopwatch = new StopWatch().createStarted();
        calc.evaluateExpression();
        stopwatch.stop();


        System.out.println("Time required for evaluate: " + stopwatch.getNanoTime() + " nanoseconds");
        runTimes.put("evaluate", stopwatch.getNanoTime());

    }

    public void measureRunTimeCompute() {

        StopWatch stopwatch2 = new StopWatch().createStarted();
        calc.evaluateExpression();
        stopwatch2.stop();
        System.out.println("Time required for compute: " + stopwatch2.getNanoTime() + " nanoseconds");
        runTimes.put("Compute", stopwatch2.getNanoTime());


    }


}
