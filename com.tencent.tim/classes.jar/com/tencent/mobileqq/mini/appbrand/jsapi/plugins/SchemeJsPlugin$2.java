package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class SchemeJsPlugin$2
  extends ResultReceiver
{
  SchemeJsPlugin$2(SchemeJsPlugin paramSchemeJsPlugin, Handler paramHandler, JsRuntime paramJsRuntime, String paramString1, int paramInt, String paramString2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    QLog.d("SchemeJsPlugin", 1, "onReceiveResult resultCode : " + paramInt);
    if (paramInt == 1)
    {
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$eventName, null, this.val$callbackId);
      return;
    }
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("errMsg");
    }
    QLog.d("SchemeJsPlugin", 1, this.val$scheme + " failed, errMsg : " + str);
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$eventName, null, str, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SchemeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */