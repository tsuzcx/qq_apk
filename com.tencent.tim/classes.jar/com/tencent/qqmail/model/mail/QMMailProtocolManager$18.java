package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.ConcurrentHashMap;

class QMMailProtocolManager$18
  implements Runnable
{
  QMMailProtocolManager$18(QMMailProtocolManager paramQMMailProtocolManager, Account paramAccount, ComposeMailUI paramComposeMailUI) {}
  
  public void run()
  {
    Mail localMail = QMMailManager.sharedInstance().readLocalMail(Mail.generateId(this.val$account.getId(), this.val$mailUI.getComposeId()));
    if ((localMail != null) && (!localMail.getStatus().isAttrHasAppend()))
    {
      int i = QMFolderManager.sharedInstance().getSentFolderId(this.val$account.getId());
      if (i != 0)
      {
        QMFolder localQMFolder = QMFolderManager.sharedInstance().getFolder(i);
        if (localQMFolder != null)
        {
          QMLog.log(4, "QMMailProtocolManager", "need append after send mail:" + this.val$mailUI.getInformation().getSubject());
          QMMailProtocolManager.access$400(this.this$0).put(localMail.getInformation().getRemoteId(), Boolean.valueOf(true));
          QMMailProtocolManager.access$500(this.this$0).appendMailToServer(this.val$account, localQMFolder, localMail, new QMMailProtocolManager.18.1(this, localMail));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.18
 * JD-Core Version:    0.7.0.1
 */