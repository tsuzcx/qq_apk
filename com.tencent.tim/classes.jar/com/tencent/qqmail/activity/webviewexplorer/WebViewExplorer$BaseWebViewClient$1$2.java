package com.tencent.qqmail.activity.webviewexplorer;

import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.popularize.JSApiUitil.JSCallBack;

class WebViewExplorer$BaseWebViewClient$1$2
  implements JSApiUitil.JSCallBack
{
  WebViewExplorer$BaseWebViewClient$1$2(WebViewExplorer.BaseWebViewClient.1 param1) {}
  
  public void executeJS(String paramString)
  {
    JSApiUitil.excuteJavaScript(this.this$2.this$1.this$0.mWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.BaseWebViewClient.1.2
 * JD-Core Version:    0.7.0.1
 */