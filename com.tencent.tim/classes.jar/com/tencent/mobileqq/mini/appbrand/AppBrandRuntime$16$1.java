package com.tencent.mobileqq.mini.appbrand;

import android.graphics.Bitmap;

class AppBrandRuntime$16$1
  implements Runnable
{
  AppBrandRuntime$16$1(AppBrandRuntime.16 param16, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$screenshotCallback != null) {
      this.this$1.val$screenshotCallback.onGetShareScreenshot(this.this$1.this$0.cutAndSaveShareScreenshot(this.val$rootBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.16.1
 * JD-Core Version:    0.7.0.1
 */