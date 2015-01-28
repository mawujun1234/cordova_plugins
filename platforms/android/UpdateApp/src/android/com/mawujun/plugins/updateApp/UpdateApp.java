package com.mawujun.plugins.updateApp;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * 程序更新的app插件
 * version.js的内容如下{verCode:2,verName:"0.0.2",url:"http://172.16.3.10:8080/emsmobile-debug-unaligned.apk"}
 * 但是如果在客户端请求的参数中加了downloadFile的值，那就以参数的为优先级
 * @author mawujun
 * 
 */
public class UpdateApp extends CordovaPlugin {
	public CallbackContext callbackContext;
	int newVerCode = -1;// 新版本号，服务端的版本号
	String newVerName = "";//新版本名称，服务端的版本名称
	
	ProgressDialog pd = null;
	String UPDATE_SERVERAPK = "ApkUpdateAndroid.apk";
	String downloadFile = null;//http://192.168.0.100:88/phoneGap_jqm.apk";
	String serverVerUrl = null;//"http://172.16.3.10:8080/apkVersion.js";// 检查服务器版本的url
	Activity activity;
	

	@Override
	public boolean execute(String action, final JSONArray args,
			final CallbackContext callbackContext) throws JSONException {
		
		final UpdateManager updateManager=new UpdateManager(this.cordova.getActivity());
    	updateManager.initUrl(args);
    	
		if ("manuallyUpdateApp".equals(action)) {
			cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                	updateManager.exec(UpdateManager.manuallyUpdateApp);
                	callbackContext.success();
                }
			});
			return true;
		} else if("autoUpdateApp".equals(action)){
			cordova.getThreadPool().execute(new Runnable() {
                public void run() {
                	updateManager.exec(UpdateManager.autoUpdateApp);
                	callbackContext.success();
                }
			});
			return true;
		}
		return false;
	}

	
}
