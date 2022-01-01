package cz.example.crawler.service;

import cz.example.crawler.controller.CrawlerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Crawler {

    private static final Logger log = LoggerFactory.getLogger(Crawler.class);

    private static final int MAX_PAGES_TO_SEARCH = 10;
    private final Set<String> pagesVisited = new HashSet<>();
    private final List<String> pagesToVisit = new LinkedList<>();


    private String nextUrl() {
        String nextUrl;
        do {
            nextUrl = this.pagesToVisit.remove(0);
        } while (this.pagesVisited.contains(nextUrl));
        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }

    public void search(String url, String searchWord) {
        while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {
            String currentUrl;
            CrawlerImpl crawler = new CrawlerImpl();
            if (this.pagesToVisit.isEmpty()) {
                currentUrl = url;
                this.pagesVisited.add(url);
            } else {
                currentUrl = this.nextUrl();
            }
            crawler.crawl(currentUrl);

            boolean success = crawler.searchForWord(searchWord);
            if (success) {
                log.info("Word ({}) found at {}", searchWord, currentUrl);
                break;
            }
            this.pagesToVisit.addAll(crawler.getLinks());
        }
        log.info("Visited {} web page(s)", this.pagesVisited.size());
    }
}
