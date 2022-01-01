package cz.example.crawler.service;

import org.junit.jupiter.api.Test;

class CrawlerTest {

    @Test
    public void shouldCrawlSuccessfully() {
        Crawler crawler = new Crawler();

        crawler.search("https://stackoverflow.com/", "connect");
    }

}