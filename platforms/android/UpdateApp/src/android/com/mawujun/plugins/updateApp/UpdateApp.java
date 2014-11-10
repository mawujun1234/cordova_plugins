package com.mawujun.plugins.updateApp;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * 程序更新的app插件
 * @author mawujun
 *
 */
public class UpdateApp extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		//检查并更新程序app
		if ("checkOrUpdateApp".equals(action)) {
            this.checkOrUpdateApp(args);
            callbackContext.success();
            return true;
        }
        return false;
	}
	/**
	 * 检查并更新程序的app
	 * @param args
	 */
	public void checkOrUpdateApp(JSONArray args){
		
	}

}
