package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.callback.ReadMailCallback;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.Mail;

class QMMailManager$50
  extends ReadMailCallback
{
  QMMailManager$50(QMMailManager paramQMMailManager) {}
  
  public void onComplete(Mail paramMail)
  {
    if (paramMail != null) {
      QMWatcherCenter.triggerReadLocalMailSuccess(paramMail);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.50
 * JD-Core Version:    0.7.0.1
 */