package com.tencent.qqmail.calendar.model;

import com.tencent.qqmail.model.MailManagerDelegate.BeforeSendCallback;
import com.tencent.qqmail.model.verify.QMGetVerifyImageWatcher;
import moai.core.watcher.Watchers;

class QMCalendarManager$13$1
  implements MailManagerDelegate.BeforeSendCallback
{
  QMCalendarManager$13$1(QMCalendarManager.13 param13) {}
  
  public void run(Object paramObject)
  {
    ((QMGetVerifyImageWatcher)Watchers.of(QMGetVerifyImageWatcher.class)).onProcess(this.this$1.val$verifyId, this.this$1.val$verifyKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.model.QMCalendarManager.13.1
 * JD-Core Version:    0.7.0.1
 */