package com.tencent.mobileqq.mini.appbrand;

import android.graphics.Bitmap;

class AppBrandRuntime$18
  implements Runnable
{
  AppBrandRuntime$18(AppBrandRuntime paramAppBrandRuntime, BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.val$screenshotCallback != null) {
      this.val$screenshotCallback.onGetShareScreenshot(this.this$0.cutAndSaveShareScreenshot(this.val$cachingBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.18
 * JD-Core Version:    0.7.0.1
 */