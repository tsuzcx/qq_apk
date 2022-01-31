package oicq.wlogin_sdk.quicklogin;

import android.os.Build.VERSION;
import android.webkit.WebView;
import oicq.wlogin_sdk.tools.util;

final class g
  implements Runnable
{
  g(WebView paramWebView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.a.loadUrl(this.b);
      try
      {
        this.a.evaluateJavascript(this.c, null);
        return;
      }
      catch (Exception localException)
      {
        util.LOGI("evaluateJavascript function can't use:" + Build.VERSION.SDK_INT + " message " + localException.getMessage(), "");
        this.a.loadUrl(this.c);
        return;
      }
      catch (Error localError)
      {
        util.LOGI("evaluateJavascript function can't use:" + Build.VERSION.SDK_INT + " message " + localError.getMessage(), "");
        this.a.loadUrl(this.c);
        return;
      }
    }
    this.a.loadUrl(this.c);
    this.a.loadUrl(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.quicklogin.g
 * JD-Core Version:    0.7.0.1
 */