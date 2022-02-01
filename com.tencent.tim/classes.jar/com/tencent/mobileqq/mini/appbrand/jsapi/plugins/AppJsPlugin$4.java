package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import cooperation.qzone.util.QZLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import org.json.JSONObject;

class AppJsPlugin$4
  implements AppJsPlugin.IWaldlCallback
{
  AppJsPlugin$4(AppJsPlugin paramAppJsPlugin, String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onResult(boolean paramBoolean, Object paramObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if ((paramBoolean) && ((paramObject instanceof WadlResult)))
      {
        localJSONObject.put("appid", this.val$url);
        paramObject = (WadlResult)paramObject;
        localJSONObject.put("status", paramObject.bBa);
        localJSONObject.put("downloadSize", paramObject.DZ);
        localJSONObject.put("totalSize", paramObject.fileSize);
        localJSONObject.put("progress", paramObject.DZ * 100L / paramObject.fileSize);
        if (paramObject.a != null) {
          localJSONObject.put("versionCode", paramObject.a.versionCode);
        }
        if (paramObject.bBa == 6)
        {
          paramObject = paramObject.aJb;
          if ((TextUtils.isEmpty(paramObject)) || (!new File(paramObject).exists()))
          {
            localJSONObject.put("status", 0);
            localJSONObject.put("progress", 0);
          }
        }
        paramObject = ApiUtil.wrapCallbackOk(this.val$eventName, localJSONObject);
        this.val$webview.evaluateCallbackJs(this.val$callbackId, paramObject.toString());
        return;
      }
      paramObject = ApiUtil.wrapCallbackFail(this.val$eventName, localJSONObject);
      this.val$webview.evaluateCallbackJs(this.val$callbackId, paramObject.toString());
      return;
    }
    catch (Throwable paramObject)
    {
      QZLog.e("AppJsPlugin", 1, paramObject, new Object[0]);
      paramObject = ApiUtil.wrapCallbackFail(this.val$eventName, null);
      this.val$webview.evaluateCallbackJs(this.val$callbackId, paramObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */