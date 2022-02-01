package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class OtherJsPlugin$4
  implements MiniAppController.ActivityResultListener
{
  OtherJsPlugin$4(OtherJsPlugin paramOtherJsPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d(OtherJsPlugin.access$000(), 2, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    if (paramInt1 == 5)
    {
      OtherJsPlugin.access$400(this.this$0, this.val$eventName, this.val$webview, this.val$callbackId);
      MiniAppController.getInstance().removeActivityResultListener(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.OtherJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */