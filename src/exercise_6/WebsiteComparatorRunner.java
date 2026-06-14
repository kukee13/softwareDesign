package exercise_6;

import java.io.IOException;
import java.util.List;

/**
 * Entry point for Exercise 6.
 * Demonstrates the Strategy pattern by running all three comparison strategies
 * against two URLs and printing results to stdout.
 */
public class WebsiteComparatorRunner {

    public static void main(String[] args) {
        String url1 = "http://example.com";
        String url2 = "http://example.org";

        List<WebsiteComparisonStrategy> strategies = List.of(
                new ContentSizeStrategy(),
                new HtmlContentStrategy(),
                new TextContentStrategy()
        );

        WebsiteComparator comparator = new WebsiteComparator(strategies.get(0));

        System.out.println("Comparing:");
        System.out.println("  URL 1: " + url1);
        System.out.println("  URL 2: " + url2);
        System.out.println();

        for (WebsiteComparisonStrategy strategy : strategies) {
            comparator.setStrategy(strategy);
            try {
                boolean result = comparator.compare(url1, url2);
                System.out.printf("%-30s -> %s%n",
                        "[" + strategy.getName() + "]",
                        result ? "IDENTICAL" : "DIFFERENT");
            } catch (IOException e) {
                System.out.printf("%-30s -> ERROR: %s%n",
                        "[" + strategy.getName() + "]",
                        e.getMessage());
            }
        }
    }
}
