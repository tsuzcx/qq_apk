package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailTranslate;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailManager$12
  extends ReadMailTranslateCallback
{
  QMMailManager$12(QMMailManager paramQMMailManager) {}
  
  public void onComplete(MailTranslate paramMailTranslate)
  {
    QMLog.log(4, "QMMailManager", "load translate mail by db cache.");
    QMWatcherCenter.triggerReadLocalTranslateMailSuccess(paramMailTranslate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.12
 * JD-Core Version:    0.7.0.1
 */