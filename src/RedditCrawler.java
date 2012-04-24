import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class RedditCrawler {
    public RedditCrawler() {
        
    }
    
    public static void main(String args[]) {
        try {
            Document doc = Jsoup.connect("http://google.com").get();
            // prints out HTML for site
            System.out.println(doc);           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}