package model;

import java.sql.Date;
import java.sql.Timestamp;

public class LeaveRequest {
    private int id;
    private String title;
    private Date fromDate;
    private Date toDate;
    private String reason;
    private String status;  // Inprogress, Approved, Rejected
    private Employee createdBy;
    private Employee processedBy;
    private Timestamp processedAt;
    private Timestamp createdAt;

    public LeaveRequest() {
    }

    public LeaveRequest(int id, String title, Date fromDate, Date toDate, String reason, String status,
                        Employee createdBy, Employee processedBy, Timestamp processedAt, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
        this.status = status;
        this.createdBy = createdBy;
        this.processedBy = processedBy;
        this.processedAt = processedAt;
        this.createdAt = createdAt;
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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Employee getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(Employee processedBy) {
        this.processedBy = processedBy;
    }

    public Timestamp getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Timestamp processedAt) {
        this.processedAt = processedAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "LeaveRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", status='" + status + '\'' +
                ", createdBy=" + (createdBy != null ? createdBy.getName() : "null") +
                '}';
    }
}
