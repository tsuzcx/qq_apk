package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadMailFragment$9$1
  implements Runnable
{
  ReadMailFragment$9$1(ReadMailFragment.9 param9, int paramInt) {}
  
  public void run()
  {
    if (ReadMailFragment.access$200(this.this$1.this$0) == this.val$accountId)
    {
      if (this.this$1.this$0.refreshTokenCallbackId != null)
      {
        JSApiUitil.excuteJavaScript(ReadMailFragment.access$2300(this.this$1.this$0).getWebView(), JSApiUitil.handleJsCallBack(true, "refresh token success", this.this$1.this$0.refreshTokenCallbackId));
        this.this$1.this$0.refreshTokenCallbackId = null;
      }
      if (this.this$1.this$0.refreshSkeyCallbackId != null)
      {
        Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(this.val$accountId);
        if ((localObject == null) || (!(localObject instanceof QQMailAccount))) {
          break label172;
        }
        localObject = Aes.encode(((QQMailAccount)localObject).getSid(), ((QQMailAccount)localObject).getAesKey());
        JSApiUitil.excuteJavaScript(ReadMailFragment.access$2300(this.this$1.this$0).getWebView(), JSApiUitil.handleJsCallBack(true, (String)localObject, this.this$1.this$0.refreshSkeyCallbackId));
      }
    }
    for (;;)
    {
      this.this$1.this$0.refreshSkeyCallbackId = null;
      return;
      label172:
      JSApiUitil.excuteJavaScript(ReadMailFragment.access$2300(this.this$1.this$0).getWebView(), JSApiUitil.handleJsCallBack(false, "refresh skey error ", this.this$1.this$0.refreshSkeyCallbackId));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.9.1
 * JD-Core Version:    0.7.0.1
 */