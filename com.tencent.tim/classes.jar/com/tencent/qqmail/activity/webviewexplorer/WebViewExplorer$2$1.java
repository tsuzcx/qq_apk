package com.tencent.qqmail.activity.webviewexplorer;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;

class WebViewExplorer$2$1
  implements Runnable
{
  WebViewExplorer$2$1(WebViewExplorer.2 param2, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    if (this.this$1.this$0.mAccountId == this.val$accountId)
    {
      if (this.this$1.this$0.refreshTokenCallbackId != null)
      {
        JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleJsCallBack(true, "refresh token success", this.this$1.this$0.refreshTokenCallbackId));
        this.this$1.this$0.refreshTokenCallbackId = null;
      }
      if (this.this$1.this$0.refreshSKeyCallbackId != null)
      {
        localObject = AccountManager.shareInstance().getAccountList().getAccountById(this.val$accountId);
        if ((localObject == null) || (!(localObject instanceof QQMailAccount)) || (((QQMailAccount)localObject).getLoginUser() == null)) {
          break label298;
        }
      }
    }
    label298:
    do
    {
      for (;;)
      {
        try
        {
          String str = ((QQMailAccount)localObject).getSid();
          localObject = ((QQMailAccount)localObject).getAesKey();
          QMLog.log(2, "WebViewExplorer", "loginWatcher onSuccss, sid: " + str + ", aesKey: " + (String)localObject);
          str = Aes.encode(str, (String)localObject);
          JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleJsCallBack(true, str, this.this$1.this$0.refreshSKeyCallbackId));
          this.this$1.this$0.refreshSKeyCallbackId = null;
          if (this.this$1.this$0.isRefreshReLoad) {
            this.this$1.this$0.loadUrlWithToken();
          }
          return;
        }
        catch (Exception localException)
        {
          QMLog.log(5, "WebViewExplorer", "loadUrlWithToken url : " + localException.getMessage());
          JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleJsCallBack(false, "refresh skey error ", this.this$1.this$0.refreshSKeyCallbackId));
          continue;
        }
        JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleJsCallBack(false, "refresh skey error ", this.this$1.this$0.refreshSKeyCallbackId));
      }
      if (this.this$1.this$0.refreshTokenCallbackId != null)
      {
        JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleJsCallBack(false, "refresh token error ", this.this$1.this$0.refreshTokenCallbackId));
        this.this$1.this$0.refreshTokenCallbackId = null;
      }
    } while (this.this$1.this$0.refreshSKeyCallbackId == null);
    JSApiUitil.excuteJavaScript(this.this$1.this$0.mWebView, JSApiUitil.handleJsCallBack(false, "refresh skey error ", this.this$1.this$0.refreshSKeyCallbackId));
    this.this$1.this$0.refreshSKeyCallbackId = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.2.1
 * JD-Core Version:    0.7.0.1
 */