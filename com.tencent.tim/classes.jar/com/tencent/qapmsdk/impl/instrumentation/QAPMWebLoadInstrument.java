package com.tencent.qapmsdk.impl.instrumentation;

import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.webview.WebViewX5Proxy;

public class QAPMWebLoadInstrument
{
  private static final String TAG = "QAPM_Impl_QAPMWebLoadInstrument";
  public static final int WEB_VIEW_TAG = 33554432;
  
  private static String crocessHeaderStr()
  {
    return "";
  }
  
  public static void setWebViewClient(WebView paramWebView, WebViewClient paramWebViewClient)
  {
    try
    {
      if (Build.VERSION.SDK_INT < 19)
      {
        paramWebView.setWebViewClient(paramWebViewClient);
        return;
      }
      WebViewX5Proxy.getInstance().setCodeTypeIsX5(false);
      if (WebViewX5Proxy.getInstance().getWebViewMonitorState())
      {
        paramWebView.getSettings().setJavaScriptEnabled(true);
        paramWebView.addJavascriptInterface(QAPMJavaScriptBridge.getInstance(), "QAPMAndroidJsBridge");
        paramWebView.setTag(33554432, Integer.valueOf(33554432));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_Impl_QAPMWebLoadInstrument", "set user agent failed:", localException);
      }
    }
    paramWebView.setWebViewClient(paramWebViewClient);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMWebLoadInstrument
 * JD-Core Version:    0.7.0.1
 */