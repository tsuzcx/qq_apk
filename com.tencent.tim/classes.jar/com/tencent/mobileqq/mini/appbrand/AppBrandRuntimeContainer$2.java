package com.tencent.mobileqq.mini.appbrand;

import android.widget.FrameLayout;
import com.tencent.mobileqq.mini.appbrand.ui.DebugLayout;

class AppBrandRuntimeContainer$2
  implements Runnable
{
  AppBrandRuntimeContainer$2(AppBrandRuntimeContainer paramAppBrandRuntimeContainer) {}
  
  public void run()
  {
    if ((AppBrandRuntimeContainer.access$000(this.this$0) != null) && (AppBrandRuntimeContainer.access$200(this.this$0) != null))
    {
      AppBrandRuntimeContainer.access$000(this.this$0).setVisibility(0);
      AppBrandRuntimeContainer.access$000(this.this$0).bringToFront();
      AppBrandRuntimeContainer.access$200(this.this$0).requestLayout();
      AppBrandRuntimeContainer.access$200(this.this$0).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer.2
 * JD-Core Version:    0.7.0.1
 */