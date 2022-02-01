package com.tencent.mobileqq.webview.swift;

import arar.b;
import arcp;
import com.tencent.qphone.base.util.QLog;

public class WebViewWrapper$WebViewClientImpl$2
  implements Runnable
{
  public WebViewWrapper$WebViewClientImpl$2(arar.b paramb, WebViewPluginEngine paramWebViewPluginEngine, String paramString) {}
  
  public void run()
  {
    boolean bool = this.b.shouldOverrideUrlRequest(this.val$fUrl);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewWrapper", 2, new Object[] { "post intercept:", Boolean.valueOf(bool), " ", arcp.qb(this.val$fUrl) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.2
 * JD-Core Version:    0.7.0.1
 */