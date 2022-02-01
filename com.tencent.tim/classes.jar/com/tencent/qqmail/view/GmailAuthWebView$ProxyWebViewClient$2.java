package com.tencent.qqmail.view;

import android.util.Log;
import android.webkit.ValueCallback;

class GmailAuthWebView$ProxyWebViewClient$2
  implements ValueCallback<String>
{
  GmailAuthWebView$ProxyWebViewClient$2(GmailAuthWebView.ProxyWebViewClient paramProxyWebViewClient) {}
  
  public void onReceiveValue(String paramString)
  {
    Log.d("GmailAuthWebView", "evaluateJavascript value: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.GmailAuthWebView.ProxyWebViewClient.2
 * JD-Core Version:    0.7.0.1
 */