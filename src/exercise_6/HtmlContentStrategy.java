package exercise_6;

import java.io.IOException;

/**
 * Strategy 2: Compares websites by identical HTML content.
 * Two sites are considered identical if their full HTML response strings match exactly.
 */
public class HtmlContentStrategy implements WebsiteComparisonStrategy {

    @Override
    public boolean compare(String url1, String url2) throws IOException {
        String html1 = WebsiteFetcher.fetchHtml(url1);
        String html2 = WebsiteFetcher.fetchHtml(url2);
        return html1.equals(html2);
    }

    @Override
    public String getName() {
        return "Identical HTML Content";
    }
}
