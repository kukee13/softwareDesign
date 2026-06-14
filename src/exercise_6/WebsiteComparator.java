package exercise_6;

import java.io.IOException;

public class WebsiteComparator {

    private WebsiteComparisonStrategy strategy;

    public WebsiteComparator(WebsiteComparisonStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(WebsiteComparisonStrategy strategy) {
        this.strategy = strategy;
    }

    public WebsiteComparisonStrategy getStrategy() {
        return strategy;
    }

    public boolean compare(String url1, String url2) throws IOException {
        return strategy.compare(url1, url2);
    }
}
