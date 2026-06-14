package exercise_6;

import java.io.IOException;

public class ContentSizeStrategy implements WebsiteComparisonStrategy {

    @Override
    public boolean compare(String url1, String url2) throws IOException {
        String html1 = WebsiteFetcher.fetchHtml(url1);
        String html2 = WebsiteFetcher.fetchHtml(url2);
        return html1.length() == html2.length();
    }

    @Override
    public String getName() {
        return "Identical Content Size";
    }
}
