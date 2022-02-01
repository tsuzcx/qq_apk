package com.tencent.smtt.sdk;

import android.os.Message;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.WebViewTransport;

class i$1
  implements Runnable
{
  i$1(i parami, WebView.WebViewTransport paramWebViewTransport, Message paramMessage) {}
  
  public void run()
  {
    WebView localWebView = this.a.getWebView();
    if (localWebView != null) {
      ((IX5WebViewBase.WebViewTransport)this.b.obj).setWebView(localWebView.b());
    }
    this.b.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.i.1
 * JD-Core Version:    0.7.0.1
 */