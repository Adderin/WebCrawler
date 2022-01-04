package cz.example.crawler.connector.entity;

import javax.persistence.*;

@Entity
public class TermDictionary {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "TERM_ID")
    private Integer termId;

    private String term;

    public Integer getTermId() {
        return termId;
    }

    public void setTermId(Integer termId) {
        this.termId = termId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
