import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

// Exercise 36: HTTP Client API (Java 11+)
// Fetches data from GitHub public API
public class HttpClientDemo {
    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        // Build GET request to GitHub public API
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/octocat"))
            .header("Accept", "application/vnd.github.v3+json")
            .GET()
            .build();

        System.out.println("Sending GET request to GitHub API...");

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println("Status code : " + response.statusCode());
        System.out.println("Response body (first 500 chars):");
        System.out.println(response.body().substring(0, Math.min(500, response.body().length())));

        // Simple JSON parsing (without external library)
        String body = response.body();
        System.out.println("\n--- Parsed Fields ---");
        printField(body, "login");
        printField(body, "name");
        printField(body, "public_repos");
        printField(body, "followers");
    }

    // Minimal JSON field extractor (no external library needed)
    static void printField(String json, String key) {
        int idx = json.indexOf("\"" + key + "\":");
        if (idx < 0) return;
        int start = idx + key.length() + 3;
        // skip whitespace
        while (start < json.length() && json.charAt(start) == ' ') start++;
        char first = json.charAt(start);
        String value;
        if (first == '"') {
            int end = json.indexOf('"', start + 1);
            value = json.substring(start + 1, end);
        } else {
            int end = start;
            while (end < json.length() && ",}".indexOf(json.charAt(end)) < 0) end++;
            value = json.substring(start, end).trim();
        }
        System.out.println(key + " = " + value);
    }
}
