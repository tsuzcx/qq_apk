package com.tencent.qqmail;

import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$10$1
  implements Runnable
{
  BaseActivityImpl$10$1(BaseActivityImpl.10 param10, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    QMLog.log(4, "BaseActivityImpl", "delay triggerAccountStateChange:" + this.val$accountId + ", state:" + this.val$state);
    AccountManager.shareInstance().triggerAccountStateChange(this.val$accountId, this.val$state, this.val$tips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.10.1
 * JD-Core Version:    0.7.0.1
 */