package com.itt.IssueTrackingTool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Actionpoint")
public class ActionPoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;
    private String title;
    private String description;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issueid")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Issue issue;

    public ActionPoint(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public ActionPoint() {

    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }
}
