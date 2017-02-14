import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by peterzen on 2017-02-14.
 * Part of the OOP3 project.
 */
public class ThousandThreadsIncrement {

    public static int sum = 0;

    public ThousandThreadsIncrement(Integer threads, boolean isThreadSafe) {
        threads = threads == null ? 1000 : threads;
        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        // make the thread pool increment
        IntStream.range(0, threads).forEach(
                i -> executorService.submit(
                        isThreadSafe ? this::incrementSumSync : this::incrementSum
                )
        );

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        System.out.println("Finished increment task in 1000 threads pool");
        System.out.println(
            "Using the following IncrementTask implementation:\n" +
            (isThreadSafe ? "incrementSumSync" : "incrementSum")
        );
        System.out.println("Result sum: "+ThousandThreadsIncrement.sum);
    }

    synchronized void incrementSumSync() {
        sum = sum + 1;
    }

    void incrementSum() {
        sum = sum + 1;
    }

}