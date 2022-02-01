package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.MailManagerDelegate.DataCallback;
import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class QMMailProtocolManager$22
  implements MailManagerDelegate.DataCallback
{
  QMMailProtocolManager$22(QMMailProtocolManager paramQMMailProtocolManager, ComposeMailUI paramComposeMailUI, MailManagerDelegate paramMailManagerDelegate, Account paramAccount) {}
  
  public void run(Object paramObject1, Object paramObject2)
  {
    QMContactManager.sharedInstance().syncProtocolHistoryContact(this.val$mailUI.getInformation());
    if (this.val$callback != null) {
      this.val$callback.handleSuccess(paramObject1, paramObject2);
    }
    QMMailProtocolManager.access$1200(this.this$0, this.val$mailUI, this.val$account);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolManager.22
 * JD-Core Version:    0.7.0.1
 */