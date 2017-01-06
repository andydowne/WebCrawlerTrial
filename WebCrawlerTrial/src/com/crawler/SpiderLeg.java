package com.crawler;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SpiderLeg
{
    // Fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";

    /**
     * This performs all the work. It makes an HTTP request, checks the response, and then gathers
     * up all the links on the page.
     * https://jsoup.org/cookbook/extracting-data/selector-syntax
     * @param url
     *            - The URL to visit
     * @return list of links
     */
    public Set<String> crawl(String url) {
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            Set<String> links = new LinkedHashSet<>();

            if(connection.response().statusCode() == 200) {
                //System.out.println("Crawling " + url);
            } else {
                return null;
            }

            if(!connection.response().contentType().contains("text/html")) {
                System.out.println("Retrieved something other than HTML");
                return null;
            }

            /* first search for a href links */
            Elements hrefLinks = htmlDocument.select("a[href]");
            //System.out.println("Found (" + linksOnPage.size() + ") href links");

            /* add unique urls to the set ignoring page anchors */
            for(Element link : hrefLinks) {
                if(link.absUrl("href").contains("http")
                        && !link.absUrl("href").equals(url)
                        && !link.absUrl("href").contains("#")) {
                    links.add(link.absUrl("href"));
                    //System.out.println("Added (" + link.absUrl("href"));
                }
            }

            /* next search for linkURL links using user ... value */
            Elements linkURLsOnPage = htmlDocument.select("input[value]");
            //System.out.println("Found (" + linkURLsOnPage.size() + ") links");

            for(Element link : linkURLsOnPage) {
                if(link.absUrl("value").contains("http")
                        && !link.absUrl("value").equals(url)
                        && !link.absUrl("value").contains("#")) {
                    links.add(link.absUrl("value"));
                    //System.out.println("Added (" + link.absUrl("value"));
                }
            }

            return links;
        } catch(IOException ioe) {
            return null;
        }
    }
}