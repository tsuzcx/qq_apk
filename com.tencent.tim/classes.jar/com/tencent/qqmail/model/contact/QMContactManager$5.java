package com.tencent.qqmail.model.contact;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

class QMContactManager$5
  implements QMContactManager.ContactConvWatcher
{
  QMContactManager$5(QMContactManager paramQMContactManager) {}
  
  public void onLocalSync(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, boolean paramBoolean)
  {
    paramMailContact.setOfflineType(3);
    QMContactManager.access$500(this.this$0, paramSQLiteDatabase, paramMailContact.getId(), paramMailContact.getOfflineType());
    QMContactManager.access$200(this.this$0).contact.rebuildContactHash(paramSQLiteDatabase, new int[] { paramMailContact.getHash() });
  }
  
  public void onRemoteSync(SQLiteDatabase paramSQLiteDatabase, MailContact paramMailContact, boolean paramBoolean)
  {
    try
    {
      paramSQLiteDatabase = new ArrayList();
      paramSQLiteDatabase.add(Long.valueOf(paramMailContact.getId()));
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramMailContact.getCid())) {
        localArrayList.add(Integer.valueOf(paramMailContact.getCid()));
      }
      if (paramMailContact.getType() == MailContact.ContactType.ProtocolContact)
      {
        QMContactManager.access$300(this.this$0).delContact(paramMailContact.getAccountId(), paramSQLiteDatabase, localArrayList);
        return;
      }
      QMContactManager.access$400(this.this$0).deleteContact(paramMailContact.getAccountId(), paramSQLiteDatabase, localArrayList);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, "QMContactManager", Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactManager.5
 * JD-Core Version:    0.7.0.1
 */