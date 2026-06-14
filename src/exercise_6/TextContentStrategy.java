package exercise_6;

import java.io.IOException;

public class TextContentStrategy implements WebsiteComparisonStrategy {

    @Override
    public boolean compare(String url1, String url2) throws IOException {
        String text1 = extractText(WebsiteFetcher.fetchHtml(url1));
        String text2 = extractText(WebsiteFetcher.fetchHtml(url2));
        return text1.equals(text2);
    }

    @Override
    public String getName() {
        return "Identical Text Content";
    }

    private String extractText(String html) {
        String noScript = html.replaceAll("(?si)<script[^>]*>.*?</script>", "");
        String noStyle = noScript.replaceAll("(?si)<style[^>]*>.*?</style>", "");
        String noTags = noStyle.replaceAll("<[^>]+>", "");
        return noTags.replaceAll("\\s+", " ").trim();
    }
}
