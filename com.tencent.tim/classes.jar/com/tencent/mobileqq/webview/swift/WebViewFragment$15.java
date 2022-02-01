package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.bigbrother.TeleScreenRunnable;
import com.tencent.qphone.base.util.QLog;

class WebViewFragment$15
  implements TeleScreenRunnable
{
  WebViewFragment$15(WebViewFragment paramWebViewFragment, Intent paramIntent, boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        WebViewFragment.a(this.this$0, this.val$intent);
        if ((!this.cXv) || (TextUtils.isEmpty(this.val$appName))) {
          break;
        }
        boolean bool = this.val$intent.getBooleanExtra("keyIsDownLoad", false);
        WebViewFragment.a(this.this$0).finish();
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewFragment", 2, "forcedClosedAfterJump appName=" + this.val$appName);
        }
        String str1;
        if ((this.cXw) && (!bool))
        {
          if (this.val$appid == -1L)
          {
            str1 = "";
            anot.a(null, "dc00898", "", "", "0X800A86A", "0X800A86A", 0, 0, str1, "", "", "");
            return;
          }
          str1 = String.valueOf(this.val$appid);
          continue;
        }
        if (!this.cXw) {
          break;
        }
        if (this.val$appid == -1L)
        {
          str1 = "";
          anot.a(null, "dc00898", "", "", "0X800A86B", "0X800A86B", 0, 0, str1, "", "", "");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("WebLog_WebViewFragment", 1, localThrowable, new Object[0]);
        return;
      }
      long l = this.val$appid;
      String str2 = String.valueOf(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewFragment.15
 * JD-Core Version:    0.7.0.1
 */