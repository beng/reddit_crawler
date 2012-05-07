import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
    private String subr;
    private String attr;
    private Document doc;
    private Elements urls;
    
    private Crawler(String subr, String attr) throws IOException {
        this.subr = subr;
        this.attr = attr;
        this.doc = this.connect();              
        this.set_urls();        
    }
    
    private void set_urls() {
        urls = this.doc.select(attr);
    }
    
    public Elements get_urls() {
        return urls;
    }
    
    private Document connect() throws IOException {
        return Jsoup.connect(subr).get();
    }
    
    public static void main(String args[]) throws IOException {
        String r1 = "http://www.reddit.com/r/Dota2";
        String ahref = "a[href]";
        String src = "src";
        Crawler c = new Crawler(r1, ahref);
        System.out.println(c.get_urls());
    }
}