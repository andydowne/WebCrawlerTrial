package com.crawler;

import java.util.*;

public class Spider {

    private Set<String> pagesCrawled = new HashSet<String>();
    private List<String> currentStack = new LinkedList<String>();
    private List<String> siteMap = new LinkedList<String>();

    /**
     * Our main launching point for the Spider's functionality. Internally it creates spider legs
     * that make an HTTP request and parse the response (the web page).
     *
     * @param url   The starting point of this iteration
     */
    public void search(String url) {
        outputSitemap(url);
        currentStack.add(url);

        SpiderLeg leg = new SpiderLeg();
        Set<String> links = leg.crawl(url);

        if(links != null) {
            for (String link : leg.crawl(url)) {
                if (link.length() >= 24 && link.toLowerCase().startsWith("http://wiprodigital.com/")
                        && !currentStack.contains(link)
                        && !pagesCrawled.contains(link)) {
                    search(link);
                } else {
                    outputSitemap(link);
                }
            }
        }
        currentStack.remove(url);
        pagesCrawled.add(url);
    }

    private void outputSitemap(String url) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < (currentStack.size()) ; i++) {
            sb.append("  ");
        }
        siteMap.add(sb.toString() + url + (System.getProperty("line.separator")));
    }

    public List<String> getSiteMap() {
        return siteMap;
    }
}
