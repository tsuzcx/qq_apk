package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acfp;
import android.app.Activity;
import android.util.Log;
import aqha;
import aqju;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class InternalJSPlugin$7
  implements Runnable
{
  InternalJSPlugin$7(InternalJSPlugin paramInternalJSPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, JsRuntime paramJsRuntime, String paramString5, int paramInt) {}
  
  public void run()
  {
    aqju localaqju = aqha.a(this.val$activity, 230, acfp.m(2131707455), String.format(acfp.m(2131707453), new Object[] { this.val$appName }), acfp.m(2131707450), acfp.m(2131707448), new InternalJSPlugin.7.1(this), new InternalJSPlugin.7.2(this));
    try
    {
      localaqju.show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("InternalJSPlugin", 1, "confirmOpenAppDetailPage, Exception: " + Log.getStackTraceString(localException));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InternalJSPlugin.7
 * JD-Core Version:    0.7.0.1
 */