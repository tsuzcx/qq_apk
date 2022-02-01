package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;

class UiApiPlugin$27
  implements Runnable
{
  UiApiPlugin$27(UiApiPlugin paramUiApiPlugin, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    boolean bool = UiApiPlugin.a(this.val$activity, UiApiPlugin.a(this.val$activity, null, this.akr, "qqbrowser_float_shortcut"), this.val$title, this.val$iconUrl);
    ThreadManagerV2.getUIHandlerV2().post(new UiApiPlugin.27.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.27
 * JD-Core Version:    0.7.0.1
 */