package bistro.exception;

import bistro.business.Bistro;

public class BistroException extends Exception {
    private String message;


    public BistroException(String message){
        this.message=message;
    }
}
