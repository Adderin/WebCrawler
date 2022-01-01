package cz.example.crawler.controller;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


import static org.springframework.http.HttpHeaders.USER_AGENT;

public class CrawlerImpl {

    private static final Logger log = LoggerFactory.getLogger(CrawlerImpl.class);

    private final List<String> links = new LinkedList<>();
    private Document htmlDocument;

    public void crawl(String url) {
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;

            log.info("Received web page at " + url);

            Elements linksOnPage = htmlDocument.select("a[href]");
            log.info("Found (" + linksOnPage.size() + ") links");
            for (Element link : linksOnPage) {
                this.links.add(link.absUrl("href"));
            }
        } catch (IOException ioe) {
            log.error("Error in out HTTP request " + ioe);
        }
    }

    public boolean searchForWord(String searchWord) {
        log.info("Searching for the word (" + searchWord + ")");
        String bodyText = this.htmlDocument.body().text();
        return bodyText.toLowerCase().contains(searchWord.toLowerCase());
    }

    public List<String> getLinks() {
        return this.links;
    }
}
