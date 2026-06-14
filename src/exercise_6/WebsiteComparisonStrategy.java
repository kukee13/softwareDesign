package exercise_6;

import java.io.IOException;

public interface WebsiteComparisonStrategy {
    boolean compare(String url1, String url2) throws IOException;
    String getName();
}
