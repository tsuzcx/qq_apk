package com.tencent.qqmail.model.contact;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.protocol.UMA.ContactListInfo;
import com.tencent.qqmail.protocol.UMA.Contacts;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.LinkedList;

class QMContactProtocolManager$1
  extends SimpleOnProtocolListener
{
  QMContactProtocolManager$1(QMContactProtocolManager paramQMContactProtocolManager, Account paramAccount, int paramInt) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.contact_sync_info_list_ != null))
    {
      paramCloudProtocolResult = paramCloudProtocolResult.contact_sync_info_list_;
      int k = paramCloudProtocolResult.length;
      i = 0;
      if (i < k)
      {
        localObject1 = paramCloudProtocolResult[i];
        localObject2 = localObject1.account_address;
        localObject3 = localObject1.sync_key;
        if (this.val$account.getEmail().equals(localObject2))
        {
          QMSettingManager.sharedInstance().setContactSyncKey(this.val$accountId, MailContact.ContactType.ProtocolContact, (String)localObject3);
          localObject2 = QMContactProtocolManager.access$000(this.this$0).getWritableDatabase();
        }
      }
    }
    for (;;)
    {
      int[] arrayOfInt;
      int j;
      try
      {
        ((SQLiteDatabase)localObject2).beginTransactionNonExclusive();
        localObject3 = QMContactProtocolManager.access$000(this.this$0).contact.getOffLineOptByAccountIdAndContactType((SQLiteDatabase)localObject2, this.val$accountId, MailContact.ContactType.ProtocolContact);
        if (localObject1.contact_list == null) {
          break label373;
        }
        arrayOfInt = new int[localObject1.contact_list.size()];
        j = 0;
        if (j < localObject1.contact_list.size())
        {
          localContacts = (Contacts)localObject1.contact_list.get(j);
          localMailContact = this.this$0.transformProtocolContactToMailContact(this.val$accountId, localContacts);
          arrayOfInt[j] = localMailContact.getHash();
          if (QMContactProtocolManager.access$000(this.this$0).contact.isContactExistWithAccountAndCid((SQLiteDatabase)localObject2, this.val$accountId, localMailContact.getCid())) {
            if (localContacts.isdel == 1) {
              QMContactProtocolManager.access$000(this.this$0).contact.deleteContact((SQLiteDatabase)localObject2, localMailContact.getId());
            } else if (!QMContactProtocolManager.access$100(this.this$0, (ArrayList)localObject3, localMailContact)) {
              QMContactProtocolManager.access$000(this.this$0).contact.updateContact((SQLiteDatabase)localObject2, localMailContact);
            }
          }
        }
      }
      catch (Exception localException)
      {
        Contacts localContacts;
        MailContact localMailContact;
        QMLog.log(6, "QMContactProtocolManager", Log.getStackTraceString(localException));
        ((SQLiteDatabase)localObject2).endTransaction();
        i += 1;
        break;
        if (localContacts.isdel == 1) {
          break label427;
        }
        QMContactProtocolManager.access$000(this.this$0).contact.insertContact((SQLiteDatabase)localObject2, this.val$accountId, localMailContact);
      }
      finally
      {
        ((SQLiteDatabase)localObject2).endTransaction();
      }
      QMContactProtocolManager.access$000(this.this$0).contact.rebuildContactHash((SQLiteDatabase)localObject2, arrayOfInt);
      label373:
      QMContactManager.sharedInstance().clearContactEmailCountCache();
      QMContactManager.sharedInstance().clearContactTelCache();
      QMContactManager.sharedInstance().clearNickNameCache();
      QMContactManager.sharedInstance().clearComposeContactCache();
      ((SQLiteDatabase)localObject2).setTransactionSuccessful();
      ((SQLiteDatabase)localObject2).endTransaction();
      continue;
      QMWatcherCenter.triggerLoadContactListSuccess(this.val$accountId);
      return;
      QMWatcherCenter.triggerLoadContactListError(this.val$accountId, null);
      return;
      label427:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactProtocolManager.1
 * JD-Core Version:    0.7.0.1
 */