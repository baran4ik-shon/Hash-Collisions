package task.domains;

import java.util.List;

public class Request {

    private List<String> inList;

    public Request() {
    }

    public List<String> getInList() {
        return inList;
    }

    public void setInList(List<String> inList) {
        this.inList = inList;
    }

    @Override
    public String toString() {
        return "Request{" +
                "inList=" + inList +
                '}';
    }
}
