package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl;

class AppBrandRuntime$5
  implements Runnable
{
  AppBrandRuntime$5(AppBrandRuntime paramAppBrandRuntime, GetScreenshot.Callback paramCallback, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$callback != null) {
      this.val$callback.onGetScreenshot(SaveCaptureImageUitl.cutAndSaveShareScreenshot(this.this$0, this.val$cachingBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.5
 * JD-Core Version:    0.7.0.1
 */