package com.tencent.qqmail.model.contact;

import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact;
import java.util.ArrayList;

class QMContactManager$7
  implements QMContactManager.ContactConvWatcher
{
  QMContactManager$7(QMContactManager paramQMContactManager, boolean paramBoolean) {}
  
  public void onLocalSync(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, boolean paramBoolean)
  {
    QMContactManager.access$200(this.this$0).contact.setVipContact(paramSQLiteDatabase, Long.valueOf(paramMailContact.getId()), this.val$isVip);
  }
  
  public void onRemoteSync(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, boolean paramBoolean)
  {
    paramSQLiteDatabase = AccountManager.shareInstance().getAccountList().getAccountById(paramMailContact.getAccountId());
    if (paramSQLiteDatabase.isQQMail())
    {
      if (this.val$isVip)
      {
        QMContactManager.access$400(this.this$0).addAndSyncVip(paramSQLiteDatabase.getId(), paramMailContact);
        return;
      }
      QMContactManager.access$400(this.this$0).removeAndSyncVip(paramSQLiteDatabase.getId(), paramMailContact);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMailContact);
    paramMailContact.setIsVip(this.val$isVip);
    QMContactManager.access$300(this.this$0).editContact(paramSQLiteDatabase.getId(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactManager.7
 * JD-Core Version:    0.7.0.1
 */