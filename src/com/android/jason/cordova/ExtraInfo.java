package com.android.jason.cordova;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.HashMap;
import org.apache.cordova.CordovaInterface;

public class ExtraInfo extends CordovaPlugin{
    
      public static final String TAG = "com.android.jason.cordova.ExtraInfo";
    
       @Override
    protected void pluginInitialize() {
        super.pluginInitialize();
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
                throws JSONException {

            HashMap <String, String> telephInfo =  new HashMap<String, String>();


            if (action.equals("getExtra")) {

                TelephonyManager tm = (TelephonyManager) cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);

                if (tm != null) {
                    telephInfo.put("DeviceId" ,tm.getDeviceId());
                    telephInfo.put("DeviceSoftwareVersion" ,tm.getDeviceSoftwareVersion());
                    telephInfo.put("Line1Number " ,tm.getLine1Number());
                    telephInfo.put("NetworkCountryIso",tm.getNetworkCountryIso());
                    telephInfo.put("NetworkOperator",tm.getNetworkOperator());
                    telephInfo.put("NetworkOperatorName",tm.getNetworkOperatorName());
                    telephInfo.put("SimCountryIso",tm.getSimCountryIso());
                    telephInfo.put("SimOperator",tm.getSimOperator());
                    telephInfo.put("SimOperatorName",tm.getSimOperatorName());
                    telephInfo.put("SimSerialNumber",tm.getSimSerialNumber());
                    telephInfo.put("SubscriberId(IMSI)",tm.getSubscriberId());
                    telephInfo.put("VoiceMailNumber",tm.getVoiceMailNumber());

                    callbackContext.success("success:plugin");
                } else {
                    callbackContext.error("error:plugin ");
                }
                return true;
            }
            return false;
        }


}