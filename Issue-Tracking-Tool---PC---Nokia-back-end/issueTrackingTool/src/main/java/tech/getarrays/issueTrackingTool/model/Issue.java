package tech.getarrays.issueTrackingTool.model;

import java.util.Date;

public class Issue {
    int id;
    String title;
    String description;
    Date creationDate;
    Date closingDate;
    String status;
    String priorityLevel;

    public Issue(int id, String title, String description, Date creationDate, Date closingDate, String status, String priorityLevel) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.closingDate = closingDate;
        this.status = status;
        this.priorityLevel = priorityLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        return "issue{" +
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
