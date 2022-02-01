package com.tencent.biz.webviewbase;

import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

class AbsBaseWebViewActivity$WebViewClientImpl$1
  implements Runnable
{
  AbsBaseWebViewActivity$WebViewClientImpl$1(AbsBaseWebViewActivity.b paramb, WebViewPluginEngine paramWebViewPluginEngine, String paramString) {}
  
  public void run()
  {
    this.b.shouldOverrideUrlRequest(this.val$fUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.WebViewClientImpl.1
 * JD-Core Version:    0.7.0.1
 */