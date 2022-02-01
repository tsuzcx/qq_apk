package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadMailFragment$9$2
  implements Runnable
{
  ReadMailFragment$9$2(ReadMailFragment.9 param9, int paramInt) {}
  
  public void run()
  {
    if (ReadMailFragment.access$200(this.this$1.this$0) == this.val$accountId)
    {
      if (this.this$1.this$0.refreshTokenCallbackId != null)
      {
        JSApiUitil.excuteJavaScript(ReadMailFragment.access$2300(this.this$1.this$0).getWebView(), JSApiUitil.handleJsCallBack(false, "refresh token error ", this.this$1.this$0.refreshTokenCallbackId));
        this.this$1.this$0.refreshTokenCallbackId = null;
      }
      if (this.this$1.this$0.refreshSkeyCallbackId != null)
      {
        JSApiUitil.excuteJavaScript(ReadMailFragment.access$2300(this.this$1.this$0).getWebView(), JSApiUitil.handleJsCallBack(false, "refresh skey error ", this.this$1.this$0.refreshSkeyCallbackId));
        this.this$1.this$0.refreshSkeyCallbackId = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.9.2
 * JD-Core Version:    0.7.0.1
 */