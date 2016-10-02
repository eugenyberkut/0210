package main;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

/**
 * Created by Eugeny on 02.10.2016.
 */
public class IntegralCalculator {
    double start, finish;
    int n;
    double h;

    public IntegralCalculator(double start, double finish, int n) {
        this.start = start;
        this.finish = finish;
        this.n = n;
        h = (finish-start)/n;
    }

    public double calculate(DoubleUnaryOperator f) {
        return IntStream.range(0, n).mapToDouble(i -> start + i * h).map(f).sum() * h;
    }
}
