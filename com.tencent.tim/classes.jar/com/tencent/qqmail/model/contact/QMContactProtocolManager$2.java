package com.tencent.qqmail.model.contact;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.ContactCreateResp;
import com.tencent.qqmail.protocol.UMA.Contacts;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class QMContactProtocolManager$2
  extends SimpleOnProtocolListener
{
  QMContactProtocolManager$2(QMContactProtocolManager paramQMContactProtocolManager, int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.contact_create_resp_ != null))
    {
      Object localObject1 = paramCloudProtocolResult.contact_create_resp_.sync_key;
      QMSettingManager.sharedInstance().setContactSyncKey(this.val$accountId, MailContact.ContactType.ProtocolContact, (String)localObject1);
      localObject1 = QMContactProtocolManager.access$000(this.this$0).getWritableDatabase();
      ArrayList localArrayList1;
      ArrayList localArrayList2;
      try
      {
        ((SQLiteDatabase)localObject1).beginTransactionNonExclusive();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        Object localObject2 = this.val$mailContacts.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MailContact localMailContact = (MailContact)((Iterator)localObject2).next();
          QMContactProtocolManager.access$000(this.this$0).contact.deleteContact((SQLiteDatabase)localObject1, localMailContact.getId());
          localArrayList1.add(Integer.valueOf(localMailContact.getHash()));
        }
        if (localArrayList1.isEmpty()) {
          break label336;
        }
      }
      catch (Exception paramCloudProtocolResult)
      {
        QMLog.log(6, "QMContactProtocolManager", Log.getStackTraceString(paramCloudProtocolResult));
        return;
        paramCloudProtocolResult = paramCloudProtocolResult.contact_create_resp_.contact_list.iterator();
        while (paramCloudProtocolResult.hasNext())
        {
          localObject2 = (Contacts)paramCloudProtocolResult.next();
          localObject2 = this.this$0.transformProtocolContactToMailContact(this.val$accountId, (Contacts)localObject2);
          localArrayList2.add(localObject2);
          localArrayList1.add(Integer.valueOf(((MailContact)localObject2).getHash()));
          QMContactProtocolManager.access$000(this.this$0).contact.insertContact((SQLiteDatabase)localObject1, this.val$accountId, (MailContact)localObject2);
          QMContactProtocolManager.access$000(this.this$0).contact.resetOffLineOptType((SQLiteDatabase)localObject1, ((MailContact)localObject2).getId());
        }
      }
      finally
      {
        ((SQLiteDatabase)localObject1).endTransaction();
      }
      paramCloudProtocolResult = new int[localArrayList1.size()];
      int i = 0;
      while (i < localArrayList1.size())
      {
        paramCloudProtocolResult[i] = ((Integer)localArrayList1.get(i)).intValue();
        i += 1;
      }
      QMContactProtocolManager.access$000(this.this$0).contact.rebuildContactHash((SQLiteDatabase)localObject1, paramCloudProtocolResult);
      label336:
      ((SQLiteDatabase)localObject1).setTransactionSuccessful();
      QMWatcherCenter.triggerAddContactListSuccess(this.val$accountId, this.val$originIds, localArrayList2);
      ((SQLiteDatabase)localObject1).endTransaction();
      return;
    }
    QMWatcherCenter.triggerAddContactListError(this.val$accountId, this.val$originIds, this.val$mailContacts, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactProtocolManager.2
 * JD-Core Version:    0.7.0.1
 */