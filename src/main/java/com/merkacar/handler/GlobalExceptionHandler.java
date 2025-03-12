package com.merkacar.handler;

import com.merkacar.exception.BaseException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value ={BaseException.class} )
    public ResponseEntity<ApiError> handlerBaseException(BaseException ex , WebRequest request ) {
        return ResponseEntity.badRequest().body(createApiError(request, ex.getMessage()));
    }
    private String getHostname(){
        try {
          return   InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Hostname can not be resolved" + e.getMessage());
        }
        return null;
    }
    public  <E> ApiError<E> createApiError(WebRequest request , E message) {
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setHostName(getHostname());
        exception.setPath( request.getDescription(false).substring(4));
        exception.setMessage(message);

        apiError.setException(exception);
        return apiError;
    }
}
