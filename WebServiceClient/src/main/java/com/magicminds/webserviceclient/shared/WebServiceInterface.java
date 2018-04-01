package com.magicminds.webserviceclient.shared;

/**
 * Created by saaddar on 3/18/18.
 */

public interface WebServiceInterface {

    void webServiceCallBack(Constants.CallBackType type, Object response);
}
