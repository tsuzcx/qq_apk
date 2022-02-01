package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import ausc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class AppJsPlugin$6
  implements MiniAppCmdInterface
{
  AppJsPlugin$6(AppJsPlugin paramAppJsPlugin, JsRuntime paramJsRuntime, String paramString, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      paramJSONObject = paramJSONObject.optString("packageName");
      if (TextUtils.isEmpty(paramJSONObject))
      {
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "server error,packageName = null.", this.val$callbackId);
        QLog.w("AppJsPlugin", 1, "server error,packageName = null");
        return;
      }
      this.this$0.jsPluginEngine.activityContext.getPackageManager();
      try
      {
        paramJSONObject = ausc.getPackageInfo(this.this$0.jsPluginEngine.activityContext, paramJSONObject);
        try
        {
          localJSONObject = new JSONObject();
          if (paramJSONObject != null)
          {
            localJSONObject.put("installed", 1);
            paramJSONObject = ApiUtil.wrapCallbackOk(this.val$eventName, localJSONObject);
            this.val$webview.evaluateCallbackJs(this.val$callbackId, paramJSONObject.toString());
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "isMicroAppInstalled exception\"", this.val$callbackId);
          QLog.w("AppJsPlugin", 1, "isMicroAppInstalled exception");
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramJSONObject)
      {
        for (;;)
        {
          JSONObject localJSONObject;
          QLog.e("AppJsPlugin", 1, "is_microapp_installed get an NameNotFoundException: ", paramJSONObject);
          paramJSONObject = null;
          continue;
          localJSONObject.put("installed", 0);
        }
      }
    }
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, "getNativeAppInfoForJump failed.", this.val$callbackId);
    QLog.w("AppJsPlugin", 1, "getNativeAppInfoForJump failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */