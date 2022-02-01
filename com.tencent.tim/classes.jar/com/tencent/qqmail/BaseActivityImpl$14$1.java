package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$14$1
  implements Runnable
{
  BaseActivityImpl$14$1(BaseActivityImpl.14 param14, int paramInt, String paramString) {}
  
  public void run()
  {
    QMLog.log(4, "BaseActivityImpl", "delay triggerXqqwx:" + this.val$accountId + ", tips:" + this.val$tips);
    QMWatcherCenter.triggerXqqwx(this.val$accountId, this.val$tips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.14.1
 * JD-Core Version:    0.7.0.1
 */