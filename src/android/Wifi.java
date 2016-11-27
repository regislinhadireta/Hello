package com.risf.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class Wifi extends CordovaPlugin {
 
     private WifiManager wifiManager;
 
     @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        wifiManager = (WifiManager) cordova.getActivity().getSystemService(Context.WIFI_SERVICE);
    }
 
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getSSID")) {

            String name = data.getString(0);
            String message = "Trabalhando, " + name;
            callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}
