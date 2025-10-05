package cli;

import algorithms.KadanesAlgorithm;
import algorithms.KadanesAlgorithm.Result;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        Random random = new Random();

        String outputFile = "docs/performance-plots/data.csv";

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("n,time_ms,comparisons,array_accesses\n");

            for (int n : sizes) {
                int[] arr = random.ints(n, -1000, 1000).toArray();
                PerformanceTracker tracker = new PerformanceTracker();
                long start = System.nanoTime();
                Result res = KadanesAlgorithm.findMaxSubarray(arr, tracker);
                long end = System.nanoTime();

                double timeMs = (end - start) / 1e6;


                writer.write(String.format(Locale.US, "%d,%.5f,%d,%d\n",
                        n, timeMs, tracker.getComparisons(), tracker.getArrayAccesses()));

                System.out.printf("n=%d | maxSum=%d | time=%.3f ms%n", n, res.maxSum, timeMs);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
