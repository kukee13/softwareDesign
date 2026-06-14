package exercise_6;

import java.io.IOException;

/**
 * Strategy interface for comparing two websites.
 * Each concrete strategy defines a different comparison criterion.
 */
public interface WebsiteComparisonStrategy {
    /**
     * Compares two websites identified by their URLs.
     *
     * @param url1 the first website URL
     * @param url2 the second website URL
     * @return true if the websites are considered identical under this strategy
     * @throws IOException if a network error occurs while fetching content
     */
    boolean compare(String url1, String url2) throws IOException;

    /**
     * Returns a human-readable name for this strategy.
     */
    String getName();
}
