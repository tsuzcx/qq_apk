package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.MailManagerDelegate.EventCallback;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import java.util.List;

class QMMailManager$25$1
  implements MailManagerDelegate.EventCallback
{
  QMMailManager$25$1(QMMailManager.25 param25, Account paramAccount, QMFolder paramQMFolder1, QMFolder paramQMFolder2, List paramList1, List paramList2) {}
  
  public void run(Object paramObject)
  {
    QMMailManager.access$700(this.this$1.this$0).moveMails(this.val$account, this.val$folder, this.val$toFolder, this.val$syncIds, this.val$syncKeys, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailManager.25.1
 * JD-Core Version:    0.7.0.1
 */