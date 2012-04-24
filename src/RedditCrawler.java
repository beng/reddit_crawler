import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class RedditCrawler {
    public RedditCrawler() {
    }
    
    public String getTitle(Document doc) {
        return doc.title();
    }
    
    public Document connect(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
    
    public static void main(String args[]) {
        RedditCrawler rc = new RedditCrawler();
        String url = "http://google.com";
        Document doc;
        try {
            doc = rc.connect(url);
            rc.getTitle(doc);
        } catch (IOException e) {
            e.printStackTrace();         
        }
        
    }
}