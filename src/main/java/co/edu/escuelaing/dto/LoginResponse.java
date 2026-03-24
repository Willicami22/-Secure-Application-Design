package co.edu.escuelaing.dto;

public class LoginResponse {
    private String message;
    private boolean success;

    public LoginResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getMessage() { return message; }
    public boolean isSuccess() { return success; }
}