package lv.inteview.nokiachallenge.acounts.exception;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String status;
    private String details;

    public ErrorDetails(Date timestamp, String status, String details) {
        this.timestamp = timestamp;
        this.status = status;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
