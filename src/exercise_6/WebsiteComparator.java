package exercise_6;

import java.io.IOException;

/**
 * Context class in the Strategy pattern.
 * Holds a reference to a WebsiteComparisonStrategy and delegates comparison to it.
 * The strategy can be swapped at runtime without changing this class.
 */
public class WebsiteComparator {

    private WebsiteComparisonStrategy strategy;

    public WebsiteComparator(WebsiteComparisonStrategy strategy) {
        this.strategy = strategy;
    }

    /** Replaces the active comparison strategy at runtime. */
    public void setStrategy(WebsiteComparisonStrategy strategy) {
        this.strategy = strategy;
    }

    public WebsiteComparisonStrategy getStrategy() {
        return strategy;
    }

    /**
     * Compares two websites using the currently active strategy.
     *
     * @param url1 the first website URL
     * @param url2 the second website URL
     * @return true if the strategy considers the two sites identical
     * @throws IOException if a network error occurs
     */
    public boolean compare(String url1, String url2) throws IOException {
        return strategy.compare(url1, url2);
    }
}
