package com.tencent.captchasdk;

import android.os.Build.VERSION;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import java.lang.reflect.Method;

class h
  extends WebChromeClient
{
  h(g paramg) {}
  
  public void onCloseWindow(WebView paramWebView)
  {
    super.onCloseWindow(paramWebView);
  }
  
  public boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    try
    {
      paramWebView = new WebView(paramWebView.getContext());
      try
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramWebView.removeJavascriptInterface("searchBoxJavaBridge_");
          paramWebView.removeJavascriptInterface("accessibility");
          paramWebView.removeJavascriptInterface("accessibilityTraversal");
        }
        for (;;)
        {
          paramWebView.setWebViewClient(new i(this));
          ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
          paramMessage.sendToTarget();
          return true;
          Method localMethod = paramWebView.getClass().getMethod("removeJavascriptInterface", new Class[] { String.class });
          if (localMethod != null)
          {
            localMethod.invoke(paramWebView, new Object[] { "searchBoxJavaBridge_" });
            localMethod.invoke(paramWebView, new Object[] { "accessibility" });
            localMethod.invoke(paramWebView, new Object[] { "accessibilityTraversal" });
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return true;
    }
    catch (Exception paramWebView)
    {
      paramWebView.printStackTrace();
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt) {}
  
  public void onReceivedTitle(WebView paramWebView, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.captchasdk.h
 * JD-Core Version:    0.7.0.1
 */