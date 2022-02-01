package com.tencent.mobileqq.webview;

import aqyg.b;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public class AbsWebView$WebViewClientImpl$1
  implements Runnable
{
  public AbsWebView$WebViewClientImpl$1(aqyg.b paramb, WebViewPluginEngine paramWebViewPluginEngine, String paramString) {}
  
  public void run()
  {
    if (this.b != null) {
      this.b.shouldOverrideUrlRequest(this.val$fUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl.1
 * JD-Core Version:    0.7.0.1
 */