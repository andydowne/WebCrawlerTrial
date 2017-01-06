package com.crawler;

public class SpiderTest {
    /**
     * This is our test. It creates a spider (which creates spider legs) and crawls the web.
     * http://www.netinstructions.com/how-to-make-a-simple-web-crawler-in-java/
     * Website and output file are set here
     */
    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.search("http://wiprodigital.com/");
        SitemapOutput.outputToFile("sitemap.txt", spider.getSiteMap());
    }
}
