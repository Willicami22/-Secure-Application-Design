package co.edu.escuelaing.dto;

public class LoginResponse {
    private String message;
    private boolean success;
    private String token;

    public LoginResponse(boolean success, String message, String token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }

    public String getMessage() { return message; }
    public boolean isSuccess() { return success; }
    public String getToken() { return token; }
}