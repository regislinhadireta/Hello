package com.risf.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiEnterpriseConfig;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.SupplicantState;

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

         
        if(!wifiManager.isWifiEnabled()){
            callbackContext.error("Wifi desligado");
            return false;
        }

        WifiInfo info = wifiManager.getConnectionInfo();

        if(info == null){
            callbackContext.error("Sem informações do Wifi");
            return false;
        }

        String ssid = info.getSSID();
        if(ssid.isEmpty()) {
            ssid = info.getBSSID();
        }
        if(ssid.isEmpty()){
            callbackContext.error("SSID em branco");
            return false;
        }

        callbackContext.success(ssid);
        //return true;
         
            //String name = data.getString(0);
            //String message = "Trabalhando, " + name;
            //callbackContext.success(message);

            return true;

        } else {
            
            return false;

        }
    }
}
