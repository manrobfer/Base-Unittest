package br.com.unittests.unittest.exceptions;

public class ServiceException extends RuntimeException{
    public ServiceException(String msg){
        super(msg);
    }

    public ServiceException(Throwable msg){
        super(msg);
    }

    public ServiceException(String msg, Throwable cause){
        super(msg, cause);
    }

}
