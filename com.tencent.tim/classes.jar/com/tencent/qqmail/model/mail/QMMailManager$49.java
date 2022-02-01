package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.ReadMailCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;

class QMMailManager$49
  extends ReadMailCallback
{
  QMMailManager$49(QMMailManager paramQMMailManager, boolean paramBoolean) {}
  
  public void onComplete(Mail paramMail)
  {
    if (paramMail != null)
    {
      QMWatcherCenter.triggerReadLocalMailSuccess(paramMail);
      if (this.val$checkUpdate) {
        this.this$0.tryLoadMail(paramMail, 128);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.49
 * JD-Core Version:    0.7.0.1
 */