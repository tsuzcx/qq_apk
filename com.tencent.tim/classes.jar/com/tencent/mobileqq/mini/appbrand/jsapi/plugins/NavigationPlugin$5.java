package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.widget.immersive.ImmersiveUtils;

class NavigationPlugin$5
  implements Runnable
{
  NavigationPlugin$5(NavigationPlugin paramNavigationPlugin, String paramString1, NavigationBar paramNavigationBar, String paramString2, String paramString3, long paramLong, JsRuntime paramJsRuntime, String paramString4, int paramInt) {}
  
  public void run()
  {
    boolean bool2 = "#000000".equals(this.val$frontColor);
    NavigationBar localNavigationBar = this.val$navigationBar;
    String str;
    if (bool2)
    {
      str = "black";
      localNavigationBar.setTextStyle(str);
      boolean bool1 = false;
      if (this.this$0.jsPluginEngine.activityContext != null) {
        bool1 = ImmersiveUtils.setStatusTextColor(bool2, this.this$0.jsPluginEngine.activityContext.getWindow());
      }
      this.val$navigationBar.setUseCustomStatusBarStyle(bool1);
      if (TextUtils.isEmpty(this.val$interpolator)) {
        break label134;
      }
      this.val$navigationBar.setNavBackgroundColor(ColorUtils.parseColor(this.val$backgroundColor), this.val$delay, this.val$interpolator);
    }
    for (;;)
    {
      this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
      return;
      str = "white";
      break;
      label134:
      this.val$navigationBar.setNavBackgroundColor(ColorUtils.parseColor(this.val$backgroundColor));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.NavigationPlugin.5
 * JD-Core Version:    0.7.0.1
 */