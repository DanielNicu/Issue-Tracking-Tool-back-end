package tech.getarrays.issueTrackingTool.model;

public class ActionPoint {
    int id;
    String title;
    String description;
    String status;
    int issueiD;

    public ActionPoint(int id, String title, String description, String status, int issueiD) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.issueiD = issueiD;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIssueiD() {
        return issueiD;
    }

    public void setActionPointId(int issueiD) {
        this.issueiD = issueiD;
    }

    @Override
    public String toString() {
        return "actionPoint{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", issueiD=" + issueiD +
                '}';
    }
}
