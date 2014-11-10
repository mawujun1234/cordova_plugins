package com.mawujun.plugins.updateApp;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * ������µ�app���
 * @author mawujun
 *
 */
public class UpdateApp extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		//��鲢���³���app
		if ("checkOrUpdateApp".equals(action)) {
            this.checkOrUpdateApp(args);
            callbackContext.success();
            return true;
        }
        return false;
	}
	/**
	 * ��鲢���³����app
	 * @param args
	 */
	public void checkOrUpdateApp(JSONArray args){
		
	}

}
