package dev.factory.ws;

/**
 * Created by aralco on 11/12/14.
 */
public class CommonResponse {
    private String message;

    public CommonResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}