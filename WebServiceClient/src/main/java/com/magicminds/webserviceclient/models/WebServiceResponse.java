package com.magicminds.webserviceclient.models;

/**
 * Created by saaddar on 3/18/18.
 */

public class WebServiceResponse {

    private boolean isSuccessful;
    private Object response;
    private String errMessage;

    public WebServiceResponse(boolean resultType, Object result, String errMessage){
        this.isSuccessful = resultType;
        this.response = result;
        this.errMessage = errMessage;
    }

    public boolean isResponseSuccessful(){
        return isSuccessful;
    }

    public Object getResult (){
        return response;
    }

    public String getErrorMessage (){
        return errMessage;
    }

}
