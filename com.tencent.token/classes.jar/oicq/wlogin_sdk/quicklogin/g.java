package oicq.wlogin_sdk.quicklogin;

import android.os.Build.VERSION;
import android.webkit.WebView;
import oicq.wlogin_sdk.tools.util;

final class g
  implements Runnable
{
  g(WebView paramWebView, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.a.loadUrl(this.b);
      try
      {
        this.a.evaluateJavascript(this.c, null);
        return;
      }
      catch (Error localError)
      {
        localStringBuilder = new StringBuilder("evaluateJavascript function can't use:");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        localStringBuilder.append(" message ");
        localStringBuilder.append(localError.getMessage());
        util.LOGI(localStringBuilder.toString(), "");
        this.a.loadUrl(this.c);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder("evaluateJavascript function can't use:");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        localStringBuilder.append(" message ");
        localStringBuilder.append(localException.getMessage());
        util.LOGI(localStringBuilder.toString(), "");
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