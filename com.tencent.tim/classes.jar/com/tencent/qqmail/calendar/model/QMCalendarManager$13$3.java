package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.model.MailManagerDelegate.MailErrorCallback;
import com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import moai.core.watcher.Watchers;

class QMCalendarManager$13$3
  implements MailManagerDelegate.MailErrorCallback
{
  QMCalendarManager$13$3(QMCalendarManager.13 param13) {}
  
  public void run(Object paramObject)
  {
    QMLog.log(6, "QMCalendarManager", "getVerifyImage error verifyId:" + this.this$1.val$verifyId + " verifyKey:" + this.this$1.val$verifyKey);
    if ((paramObject instanceof QMNetworkError))
    {
      paramObject = (QMNetworkError)paramObject;
      ((QMGetVerifyImageWatcher)Watchers.of(QMGetVerifyImageWatcher.class)).onError(this.this$1.val$verifyId, this.this$1.val$verifyKey, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.13.3
 * JD-Core Version:    0.7.0.1
 */