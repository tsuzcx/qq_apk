package com.tencent.qqmail.model.contact;

import android.app.Activity;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.utilities.contacts.ContactsHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Iterator;
import java.util.List;
import moai.oss.KvHelper;
import rx.functions.Action1;

class QMContactManager$8$1
  implements Action1<Boolean>
{
  QMContactManager$8$1(QMContactManager.8 param8, Activity paramActivity) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      QMLog.log(4, "QMContactManager", "READ_CONTACTS permission is granted");
      KvHelper.eventPermissionAcceptContacts(new double[0]);
      long l = QMSettingManager.sharedInstance().getLastUpdateMobileContactTime();
      if ((System.currentTimeMillis() - l > 600000L) || (QMSettingManager.sharedInstance().getLastMobileContactCount() != ContactsHelper.getMobileContactCount()))
      {
        QMSettingManager.sharedInstance().setLastUpdateMobileContactTime();
        paramBoolean = QMContactManager.access$200(this.this$1.this$0).getWritableDatabase();
      }
    }
    for (;;)
    {
      try
      {
        paramBoolean.beginTransaction();
        List localList = ContactsHelper.getMobileContacts();
        QMContactManager.access$200(this.this$1.this$0).contact.deleteMobileContacts(paramBoolean);
        Object localObject2;
        if (localList != null)
        {
          QMSettingManager.sharedInstance().setLastMobileContactCount(localList.size());
          localObject2 = localList.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            MailContact localMailContact = (MailContact)((Iterator)localObject2).next();
            QMContactManager.access$200(this.this$1.this$0).contact.insertContact(paramBoolean, 0, localMailContact);
            continue;
          }
        }
        int i;
        QMLog.log(6, "QMContactManager", "READ_CONTACTS permission is not granted");
      }
      catch (Exception localException)
      {
        QMLog.log(6, "QMContactManager", Log.getStackTraceString(localException));
        paramBoolean.endTransaction();
        Threads.runOnMainThread(new QMContactManager.8.1.1(this), 1000L);
        return;
        paramBoolean.setTransactionSuccessful();
        localObject2 = new StringBuilder().append("reindexPhoneContacts size:");
        if (localException != null)
        {
          i = localException.size();
          QMLog.log(4, "QMContactManager", i);
          paramBoolean.endTransaction();
          continue;
        }
        i = 0;
        continue;
      }
      finally
      {
        paramBoolean.endTransaction();
      }
      KvHelper.eventPermissionDenyContacts(new double[0]);
      PermissionUtils.permissionWarn(this.val$topPage, 2131718904, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactManager.8.1
 * JD-Core Version:    0.7.0.1
 */