package id.arprast.http;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request<T> {

    private T requestData;
    @NotBlank(message = "Request id can't be blank")
    private String requestId = UUID.randomUUID().toString();

    public T getRequestData() {
        return requestData;
    }

    public void setRequestData(T requestData) {
        this.requestData = requestData;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
