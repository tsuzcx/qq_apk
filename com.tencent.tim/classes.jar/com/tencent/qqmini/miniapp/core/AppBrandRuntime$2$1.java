package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl;

class AppBrandRuntime$2$1
  implements Runnable
{
  AppBrandRuntime$2$1(AppBrandRuntime.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$callback != null) {
      this.this$1.val$callback.onGetScreenshot(SaveCaptureImageUitl.cutAndSaveShareScreenshot(this.this$1.this$0, this.val$rootBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.2.1
 * JD-Core Version:    0.7.0.1
 */