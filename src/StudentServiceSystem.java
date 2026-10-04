import java.util.ArrayList;

public class StudentServiceSystem {

    private ArrayList<ServiceRequest> requests;

    public StudentServiceSystem() {
        requests = new ArrayList<>();
    }

    public void addRequest(ServiceRequest request) {
        requests.add(request);
    }

    public ArrayList<ServiceRequest> getAllRequests() {
        return requests;
    }

    public ServiceRequest searchByRequestId(String requestId) {
        for (ServiceRequest request : requests) {
            if (request.getRequestId().equalsIgnoreCase(requestId)) {
                return request;
            }
        }
        return null;
    }

    public ArrayList<ServiceRequest> searchByStudentId(String studentId) {
        ArrayList<ServiceRequest> results = new ArrayList<>();

        for (ServiceRequest request : requests) {
            if (request.getStudent().getStudentId().equalsIgnoreCase(studentId)) {
                results.add(request);
            }
        }

        return results;
    }

    public boolean updateRequestStatus(String requestId, String newStatus) {
        ServiceRequest request = searchByRequestId(requestId);

        if (request != null) {
            request.setStatus(newStatus);
            return true;
        }

        return false;
    }

    public String generateRequestId() {
        return "REQ" + String.format("%03d", requests.size() + 1);
    }
}