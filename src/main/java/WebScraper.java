import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {


/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */

public static void main(final String[] args) {
    String url = "http://erdani.com/tdpl/hamlet.txt";
    System.out.println(urlToString(url));
    System.out.println(wordCount(urlToString(url)));
    System.out.println(uniqueWordCount(urlToString(url), "the", false));
}
public static String urlToString(String url) {
    Scanner urlScanner;
    try {
        urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
    } catch (IOException e) {
        return "";
    }
    String contents = urlScanner.useDelimiter("\\A").next();
    urlScanner.close();
    return contents;
}
public static int wordCount(String input) {
    int count = 0;
    Scanner read = new Scanner(input);
    while (read.hasNext()) {
        read.next();
        count++;
    }
    read.close();
    return count;
}
public static int uniqueWordCount(String input, String word, boolean isCaseInsensitive) {
    int count = 0;
    Scanner read = new Scanner(input);
    while (read.hasNext()) {
        String temp;
        if (isCaseInsensitive) {
            temp = read.next().toLowerCase();
            if (temp.contains(word.toLowerCase())) {
                count++;
            }
        } else {
            temp = read.next();
            if (temp.contains(word)) {
                count++;
            }
        }

    }
    read.close();
    return count;
}
}
