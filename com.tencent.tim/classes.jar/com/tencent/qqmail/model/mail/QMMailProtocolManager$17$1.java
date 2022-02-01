package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.ConcurrentHashMap;

class QMMailProtocolManager$17$1
  extends MailManagerDelegate
{
  QMMailProtocolManager$17$1(QMMailProtocolManager.17 param17) {}
  
  public void handleError(Object arg1)
  {
    QMLog.log(6, "QMMailProtocolManager", "append fail:" + this.this$1.val$localMail.getInformation().getRemoteId() + ",subject:" + this.this$1.val$localMail.getInformation().getSubject());
    synchronized (QMMailProtocolManager.access$400(this.this$1.this$0))
    {
      QMMailProtocolManager.access$400(this.this$1.this$0).remove(this.this$1.val$localMail.getInformation().getRemoteId());
      return;
    }
  }
  
  public void handleSuccess(Object arg1, Object paramObject2)
  {
    QMLog.log(4, "QMMailProtocolManager", "append success:" + this.this$1.val$localMail.getInformation().getRemoteId() + ",subject:" + this.this$1.val$localMail.getInformation().getSubject());
    synchronized (QMMailProtocolManager.access$400(this.this$1.this$0))
    {
      QMMailProtocolManager.access$400(this.this$1.this$0).remove(this.this$1.val$localMail.getInformation().getRemoteId());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.17.1
 * JD-Core Version:    0.7.0.1
 */