import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 * grab all links and store into hashtable
 * send a list of different tags 
 * store each tag in the hashtable
 * each 
 * 
 */
public class RedditCrawler implements Runnable {
    private String url;
    private String tagType;
    private Document doc;
    Thread runner;
    static List imgur = new ArrayList();
    
    public RedditCrawler(String url, String tagType) throws IOException {
        this.url = url;
        this.tagType = tagType;
        runner = new Thread(this, tagType);
        this.doc = connect();
        runner.start();
    }
    
    public void saveTagType(Elements items) {
       for(Element i : items) {
           imgur.add(i.attr("abs:href"));                     
       }
    }

    public void run() {
       Elements item = this.docSelect(tagType);
       //this.saveTagType(item);
       System.out.println(item);
    }
    
    public Document connect() throws IOException {
        return Jsoup.connect(url).get();
    }
    
    /*
     * query webpage
     */
    public Elements docSelect(String tag) {
        return this.doc.select(tag);
    }

    
    public static void main(String args[]) throws IOException{    
        // take a tag and search webpage using thread
        String url = "http://www.reddit.com/r/Dota2";
        String url2 = "http://www.reddit.com/r/HeroesOfNewerth";
        String url3 = "http://www.reddit.com/r/science";
        Thread t1 = new Thread(new RedditCrawler(url, "a[href]"));
        Thread t2 = new Thread(new RedditCrawler(url2, "a[href]"));
        //Thread t3 = new Thread(new RedditCrawler(url3, "a[href]"));
        t1.start();
        t2.start();
        //t3.start();
        try {
            Thread.currentThread(); //.sleep(1000);
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()); 
        //for(int i = 0; i < imgur.size(); i++ ) {            
           // String tmp = imgur.get(i).toString();
            //System.out.println(tmp);
            //if(tmp.substring(7, 13))
//        }
        
        
    }
    
    private static void usage() {
        System.err.println ("Usage: java RedditCrawler <url>");
        System.exit (1);
    }
}