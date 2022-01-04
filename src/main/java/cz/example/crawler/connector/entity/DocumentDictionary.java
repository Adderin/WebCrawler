package cz.example.crawler.connector.entity;

import javax.persistence.*;

@Entity
public class DocumentDictionary {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "DOC_ID")
    private Integer docId;

    private String documentName;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer DocId) {
        this.docId = DocId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
}
