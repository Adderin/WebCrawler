package cz.example.crawler.entity;

import javax.persistence.*;

@Entity
public class Posting {

    @ManyToOne
    @JoinColumn(name = "DOC_ID", referencedColumnName = "DOC_ID", nullable = false)
    private DocumentDictionary documentDictionary;

    @ManyToOne
    @JoinColumn(name = "TERM_ID", referencedColumnName = "TERM_ID", nullable = false)
    private TermDictionary termDictionary;

    private Float tfidf;

    private Integer docfreq;

    private Integer termfreq;

    public DocumentDictionary getDocumentDictionary() {
        return documentDictionary;
    }

    public void setDocumentDictionary(DocumentDictionary documentDictionary) {
        this.documentDictionary = documentDictionary;
    }

    public TermDictionary getTermDictionary() {
        return termDictionary;
    }

    public void setTermDictionary(TermDictionary termDictionary) {
        this.termDictionary = termDictionary;
    }

    public Float getTfidf() {
        return tfidf;
    }

    public void setTfidf(Float tfidf) {
        this.tfidf = tfidf;
    }

    public Integer getDocfreq() {
        return docfreq;
    }

    public void setDocfreq(Integer docfreq) {
        this.docfreq = docfreq;
    }

    public Integer getTermfreq() {
        return termfreq;
    }

    public void setTermfreq(Integer termfreq) {
        this.termfreq = termfreq;
    }
}
