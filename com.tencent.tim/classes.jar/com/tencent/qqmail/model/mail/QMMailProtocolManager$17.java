package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;

class QMMailProtocolManager$17
  implements Runnable
{
  QMMailProtocolManager$17(QMMailProtocolManager paramQMMailProtocolManager, Mail paramMail, Account paramAccount, QMFolder paramQMFolder) {}
  
  public void run()
  {
    Mail localMail = QMMailManager.sharedInstance().readLocalMail(this.val$localMail.getInformation().getId());
    if (localMail != null)
    {
      QMLog.log(4, "QMMailProtocolManager", "append mail:" + localMail.getInformation().getSubject() + "," + localMail.getInformation().getDate());
      QMMailProtocolManager.access$500(this.this$0).appendMailToServer(this.val$account, this.val$folder, localMail, new QMMailProtocolManager.17.1(this));
      QMMailProtocolManager.access$000(this.this$0).mail.updateMailAttr(QMMailProtocolManager.access$000(this.this$0).getWritableDatabase(), new long[] { localMail.getInformation().getId() }, 274877906944L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.17
 * JD-Core Version:    0.7.0.1
 */