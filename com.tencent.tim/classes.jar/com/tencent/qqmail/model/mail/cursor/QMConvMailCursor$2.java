package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import java.util.concurrent.Callable;

class QMConvMailCursor$2
  implements Callable<Account>
{
  QMConvMailCursor$2(QMConvMailCursor paramQMConvMailCursor) {}
  
  public Account call()
  {
    Mail localMail = this.this$0.getParentMail();
    if (localMail != null) {
      return AccountManager.shareInstance().getAccountList().getAccountById(localMail.getInformation().getAccountId());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMConvMailCursor.2
 * JD-Core Version:    0.7.0.1
 */