package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long arrayAccesses = 0;

    public void incrementComparisons(long n) { comparisons += n; }
    public void incrementArrayAccesses(long n) { arrayAccesses += n; }

    public long getComparisons() { return comparisons; }
    public long getArrayAccesses() { return arrayAccesses; }

    public void reset() {
        comparisons = 0;
        arrayAccesses = 0;
    }
}
