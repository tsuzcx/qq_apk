package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.b;
import com.tencent.smtt.utils.TbsLog;

class WebView$8
  implements Runnable
{
  WebView$8(WebView paramWebView) {}
  
  public void run()
  {
    boolean bool1 = false;
    if ((!WebView.b(this.a)) && (this.a.a != 0))
    {
      Object localObject2;
      String str2;
      String str1;
      boolean bool2;
      label254:
      try
      {
        if ((WebView.b(this.a)) || (this.a.a == 0)) {
          return;
        }
        WebView.b(this.a, true);
        Object localObject3 = "";
        String str3 = "";
        String str4 = "";
        localObject2 = localObject3;
        str2 = str3;
        str1 = str4;
        if (WebView.c(this.a))
        {
          Bundle localBundle = WebView.d(this.a).getX5WebViewExtension().getSdkQBStatisticsInfo();
          localObject2 = localObject3;
          str2 = str3;
          str1 = str4;
          if (localBundle != null)
          {
            localObject2 = localBundle.getString("guid");
            str2 = localBundle.getString("qua2");
            str1 = localBundle.getString("lc");
          }
        }
        if ("com.qzone".equals(WebView.a(this.a).getApplicationInfo().packageName))
        {
          int j = WebView.a(this.a, WebView.a(this.a));
          localObject3 = this.a;
          int i = j;
          if (j == -1) {
            i = this.a.a;
          }
          ((WebView)localObject3).a = i;
          WebView.b(this.a, WebView.a(this.a));
        }
      }
      finally {}
      try
      {
        bool2 = WebView.d(this.a).getX5WebViewExtension().isX5CoreSandboxMode();
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        TbsLog.w("onVisibilityChanged", "exception: " + localThrowable);
        break label254;
      }
      b.a(WebView.a(this.a), (String)localObject2, str2, str1, this.a.a, WebView.c(this.a), WebView.e(this.a), bool1);
      this.a.a = 0;
      WebView.b(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.8
 * JD-Core Version:    0.7.0.1
 */