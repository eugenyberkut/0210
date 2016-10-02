package main;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        double start = 0;
        double finish = Math.PI;
        int n = 1000_000_000;
        int threads = 1;
        double d = (finish-start)/threads;
        result = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            ThreadedCalculator threadedCalculator = new ThreadedCalculator(new IntegralCalculator(start + i * d, start + (i + 1) * d, n / threads), Main::f, this);
            new Thread(threadedCalculator).start();
        }

        try {
            synchronized (this) {
                while (count < threads) {
                    wait();
                }
            }
        } catch (InterruptedException ex) {
        }

        long finishTime = System.currentTimeMillis();
        System.out.println("result = " + result);
        System.out.println("Time = " + (finishTime - startTime));
    }

    public static double f(double x) {
        return Math.sin(x);
    }

    public synchronized void addResult(double add) {
        result += add;
        count++;
        notify();
    }

    private double result;
    private int count = 0;
}
