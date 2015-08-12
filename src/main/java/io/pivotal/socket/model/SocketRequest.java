package io.pivotal.socket.model;

/**
 * @author Vinicius Carvalho
 */
public class SocketRequest {

    private Integer port;
    private String host;
    private Integer timeout;


    public SocketRequest(){}

    public SocketRequest(Integer port, String host, Integer timeout) {
        this.port = port;
        this.host = host;
        this.timeout = timeout;
    }



    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "SocketRequest{" +
                "port=" + port +
                ", host='" + host + '\'' +
                ", timeout=" + timeout +
                '}';
    }
}
