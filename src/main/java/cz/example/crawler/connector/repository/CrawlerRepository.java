package cz.example.crawler.connector.repository;

import cz.example.crawler.connector.entity.DocumentDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrawlerRepository extends JpaRepository<DocumentDictionary, Integer> {

    List<DocumentDictionary> findByDocumentName(String documentName);

    @Query("select max(d.docId) from DocumentDictionary d")
    Integer findMaxDocId();
}