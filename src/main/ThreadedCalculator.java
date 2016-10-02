package main;

import java.util.function.DoubleUnaryOperator;

/**
 * Created by Eugeny on 02.10.2016.
 */
public class ThreadedCalculator implements Runnable {

    private IntegralCalculator calculator;
    private DoubleUnaryOperator f;
    private Main main;

    public ThreadedCalculator(IntegralCalculator calculator, DoubleUnaryOperator f, Main main) {
        this.calculator = calculator;
        this.f = f;
        this.main = main;
    }

    public void run(){
        double result = calculator.calculate(f);
        main.addResult(result);
    }
}
