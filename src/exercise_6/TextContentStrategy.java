package exercise_6;

import java.io.IOException;

/**
 * Strategy 3: Compares websites by identical visible text content.
 * HTML tags are stripped; only the remaining text is compared.
 * Whitespace is normalised so minor formatting differences are ignored.
 */
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

    /**
     * Removes all HTML tags and normalises whitespace to produce plain text.
     */
    private String extractText(String html) {
        // Remove <script> and <style> blocks including their content
        String noScript = html.replaceAll("(?si)<script[^>]*>.*?</script>", "");
        String noStyle = noScript.replaceAll("(?si)<style[^>]*>.*?</style>", "");
        // Strip remaining HTML tags
        String noTags = noStyle.replaceAll("<[^>]+>", "");
        // Collapse all whitespace to a single space and trim
        return noTags.replaceAll("\\s+", " ").trim();
    }
}
