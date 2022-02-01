package com.tencent.mobileqq.mini.appbrand;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview.WebviewShotCallback;
import com.tencent.qphone.base.util.QLog;

class AppBrandRuntime$17
  implements PageWebview.WebviewShotCallback
{
  AppBrandRuntime$17(AppBrandRuntime paramAppBrandRuntime, BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback, ViewGroup paramViewGroup) {}
  
  public void onShotReady(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      QLog.d("AppBrandRuntime", 2, "onShotReady success ");
      ThreadManagerV2.executeOnFileThread(new AppBrandRuntime.17.1(this, paramBitmap));
      this.this$0.isGettingScreenShot = false;
      return;
    }
    QLog.d("AppBrandRuntime", 2, "onShotReady failed ");
    AppBrandRuntime.access$400(this.this$0, this.val$screenshotCallback, this.val$contentLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.17
 * JD-Core Version:    0.7.0.1
 */