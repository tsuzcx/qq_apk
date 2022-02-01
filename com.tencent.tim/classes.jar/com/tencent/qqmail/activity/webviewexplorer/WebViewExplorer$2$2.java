package com.tencent.qqmail.activity.webviewexplorer;

import com.tencent.qqmail.popularize.JSApiUitil;

class WebViewExplorer$2$2
  implements Runnable
{
  WebViewExplorer$2$2(WebViewExplorer.2 param2, int paramInt) {}
  
  public void run()
  {
    if (this.this$1.this$0.mAccountId == this.val$accountId)
    {
      if (this.this$1.this$0.refreshTokenCallbackId != null)
      {
        JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleJsCallBack(false, "refresh token error ", this.this$1.this$0.refreshTokenCallbackId));
        this.this$1.this$0.refreshTokenCallbackId = null;
      }
      if (this.this$1.this$0.refreshSKeyCallbackId != null)
      {
        JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleJsCallBack(false, "refresh skey error ", this.this$1.this$0.refreshSKeyCallbackId));
        this.this$1.this$0.refreshSKeyCallbackId = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.2.2
 * JD-Core Version:    0.7.0.1
 */