import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Scrapes the web, along with some miscellaneous wordCounter methods.
 */
public class WebScraper {
/**
 * The main method.
 *
 * @param args ,no arguments
 */
public static void main(final String[] args) {
    String url = "http://erdani.com/tdpl/hamlet.txt";
    System.out.println(urlToString(url));
    System.out.println(wordCount(urlToString(url)));
    System.out.println(uniqueWordCount(urlToString(url), "the", false));
}
/**
 * Retrieve contents from a URL and return them as a string.
 *
 * @param url url to retrieve contents from
 * @return the contents from the url as a string, or an empty string on error
 */
public static String urlToString(final String url) {
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
/**
 * Counts the total number of String tokens in a given String input.
 *
 * @param input String, whose words will be counted.
 * @return number of total words.
 */
public static int wordCount(final String input) {
    int count = 0;
    Scanner read = new Scanner(input);
    while (read.hasNext()) {
        read.next();
        count++;
    }
    read.close();
    return count;
}
/**
 * Counts the number of occurrences of a unique word in a String input.
 *
 * @param   input ,the String whose words will be scanned and counted.
 * @param   word ,the unique word whose occurrences will be counted.
 * @param   isCaseInsensitive ,a flag to turn on and off case sensitivity for the unique word.
 * @return  the number of occurrences of the unique word.
 */
public static int uniqueWordCount(final String input,
        final String word,
        final boolean isCaseInsensitive) {
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
