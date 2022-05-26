package com.itt.IssueTrackingTool.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Issue")
public class Issue implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private long id;
    private String title;
    private String description;
    @Column(name = "creationdate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date creationDate;
    @Column(name = "closingdate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date closingDate;
    private String status;
    @Column(name = "prioritylevel")
    private String priorityLevel;


    public Issue(String title, String description, Date creationDate, String status, String priorityLevel) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.priorityLevel = priorityLevel;
    }

    public Issue() {

    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public String getStatus() {
        return status;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", closingDate=" + closingDate +
                ", status='" + status + '\'' +
                ", priorityLevel='" + priorityLevel + '\'' +
                '}';
    }
}
