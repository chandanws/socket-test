package io.pivotal.socket.model;

/**
 * @author Vinicius Carvalho
 */
public class SocketResponse {

    private boolean successful;
    private String cause;

    public SocketResponse(){};

    public SocketResponse(boolean successful, String cause) {
        this.successful = successful;
        this.cause = cause;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
