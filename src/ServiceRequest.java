public class ServiceRequest {

    private String requestId;
    private Student student;
    private String serviceType;
    private String description;
    private String status;

    public ServiceRequest(String requestId, Student student,
                          String serviceType, String description,
                          String status) {
        this.requestId = requestId;
        this.student = student;
        this.serviceType = serviceType;
        this.description = description;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public Student getStudent() {
        return student;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return requestId + " - " + serviceType + " - " + status;
    }
}
