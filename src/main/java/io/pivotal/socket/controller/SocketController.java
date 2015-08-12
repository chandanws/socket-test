package io.pivotal.socket.controller;

import io.pivotal.socket.model.SocketRequest;
import io.pivotal.socket.model.SocketResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author Vinicius Carvalho
 */
@Controller
@RequestMapping("/connection-test")
public class SocketController {


    private Logger logger = LoggerFactory.getLogger(SocketController.class);

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = "application/json",consumes = "application/json")
    public ResponseEntity<SocketResponse> getStatus(@RequestBody SocketRequest request){
        ResponseEntity response = null;
        SocketResponse socketResponse = null;
        Socket socket = null;
        InetSocketAddress address = new InetSocketAddress(request.getHost(),request.getPort());
        socket = new Socket();

        try {
            logger.info("Opening connection to server: {}",request);
            socket.connect(address,request.getTimeout());
            socketResponse = new SocketResponse(true,"Connection success");
        } catch (SocketTimeoutException e) {
            socketResponse = new SocketResponse(false,"Connection Timeout");
        } catch (IOException e) {
            socketResponse = new SocketResponse(false,"Connection Error");
        }finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        response = new ResponseEntity(socketResponse,HttpStatus.OK);
        return response;

    }

}
