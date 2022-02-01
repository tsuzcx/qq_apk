package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class DataJsPlugin$2$1
  implements BaseJsPluginEngine.ReqGantApiPermissionCallback
{
  DataJsPlugin$2$1(DataJsPlugin.2 param2, JSONObject paramJSONObject) {}
  
  public void onGrantApiPermission(int paramInt, JSONObject paramJSONObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      StorageUtil.getPreference().edit().putString(str + "_PhoneNumber", paramJSONObject.optString("purePhoneNumber")).commit();
      paramJSONObject.remove("countryCode");
      paramJSONObject.remove("purePhoneNumber");
      QLog.d("[mini] DataJsPlugin", 1, "getPhoneNumber ret : " + paramJSONObject);
      this.this$1.this$0.jsPluginEngine.callbackJsEventOK(this.this$1.val$webview, this.this$1.val$event, paramJSONObject, this.this$1.val$callbackId);
      return;
    }
    this.this$1.this$0.jsPluginEngine.callbackJsEventFail(this.this$1.val$webview, this.this$1.val$event, this.val$ret, "auth deny, no permission.", this.this$1.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */