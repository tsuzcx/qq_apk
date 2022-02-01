package com.tencent.qqmail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMTips;

class BaseActivityImpl$2$2
  implements Runnable
{
  BaseActivityImpl$2$2(BaseActivityImpl.2 param2, int paramInt) {}
  
  public void run()
  {
    QMLog.log(6, "BaseActivityImpl LaunchSaveToMyFtn", "wechatFtnWatcher save fail:" + this.val$errcode);
    if ((this.val$errcode == -106) || (this.val$errcode == -109))
    {
      this.this$1.this$0.getTips().showError(QMApplicationContext.sharedInstance().getString(2131694061));
      return;
    }
    if (this.val$errcode == -99)
    {
      this.this$1.this$0.getTips().showError(QMApplicationContext.sharedInstance().getString(2131694071));
      return;
    }
    this.this$1.this$0.getTips().showError(QMApplicationContext.sharedInstance().getString(2131718938));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.2.2
 * JD-Core Version:    0.7.0.1
 */