package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class ImageJsPlugin$4
  implements MiniAppController.ActivityResultListener
{
  ImageJsPlugin$4(ImageJsPlugin paramImageJsPlugin, File paramFile, JsRuntime paramJsRuntime, int paramInt) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("ImageJsPlugin", 2, "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent + ", photoPath=" + this.val$imageFile.getAbsolutePath());
    if (paramInt1 != 4) {
      return false;
    }
    if (paramInt2 != -1)
    {
      if (paramInt2 == 0) {
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, "chooseImage", null, "cancel", this.val$callbackId);
      }
      this.val$imageFile.deleteOnExit();
      return true;
    }
    paramIntent = new ArrayList();
    paramIntent.add(this.val$imageFile.getAbsolutePath());
    ImageJsPlugin.access$300(this.this$0, paramIntent, this.val$webview, this.val$callbackId);
    MiniAppController.getInstance().removeActivityResultListener(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ImageJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */