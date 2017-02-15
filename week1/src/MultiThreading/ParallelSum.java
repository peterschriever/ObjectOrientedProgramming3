package MultiThreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSum {
    public static void main(String[] args) {
        // Create a list
        final int N = 9000000;
        double[] list = new double[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        long startTime = System.currentTimeMillis();
        System.out.println("\nThe total sum is " + parallelSum(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Number of processors is " +
                Runtime.getRuntime().availableProcessors());
        System.out.println("Time with " + (endTime - startTime)
                + " milliseconds");
    }

    public static double parallelSum(double[] list) {
        RecursiveTask<Double> task = new SumTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class SumTask extends RecursiveTask<Double> {
        private final static int THRESHOLD = 1000;
        private double[] list;
        private int low;
        private int high;

        public SumTask(double[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        public Double compute() {
            if ((high - low) < THRESHOLD) {
                double sum = list[0];
                for (int i = low; i < high; i++)
                    sum += list[i];
                return sum;
            }
            else {
                int midIndex = (low + high) / 2;
                RecursiveTask<Double> left = new SumTask(list, low, midIndex);
                RecursiveTask<Double> right = new SumTask(list, midIndex, high);

                right.fork();
                left.fork();
                return (left.join() + right.join());
            }
        }
    }
}