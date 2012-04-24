import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RedditCrawler {
    private String url;
    private Document doc;
    
    public RedditCrawler(String url) throws IOException {
        this.url = url;
        this.doc = connect();
    }
    
    public Document connect() throws IOException {
        return Jsoup.connect(url).get();
    }
    
    public String getTitle() {
        return this.doc.title();
    }
    
    public Elements getTag(String tag) {
        return this.doc.getElementsByTag(tag);
    }
    
    public Element getBody() {
        return this.doc.body();
    }
    
    public static void main(String args[]) {        
        String url = "http://google.com";
        RedditCrawler rc;
       
        try {
            rc = new RedditCrawler(url);
            System.out.println("Title is :: " + rc.getTag("title"));            
        } catch (IOException e) {
            e.printStackTrace();         
        }                
    }
    
    private static void usage() {
        System.err.println ("Usage: java RedditCrawler <url>");
        System.exit (1);
    }
}