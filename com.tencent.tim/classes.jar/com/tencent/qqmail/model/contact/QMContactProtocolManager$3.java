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
import com.tencent.qqmail.protocol.UMA.ContactModifyResp;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

class QMContactProtocolManager$3
  extends SimpleOnProtocolListener
{
  QMContactProtocolManager$3(QMContactProtocolManager paramQMContactProtocolManager, int paramInt, ArrayList paramArrayList) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.contact_modify_resp_ != null))
    {
      paramCloudProtocolResult = paramCloudProtocolResult.contact_modify_resp_.sync_key;
      QMSettingManager.sharedInstance().setContactSyncKey(this.val$accountId, MailContact.ContactType.ProtocolContact, paramCloudProtocolResult);
      paramCloudProtocolResult = QMContactProtocolManager.access$000(this.this$0).getWritableDatabase();
      try
      {
        int[] arrayOfInt = new int[this.val$filterContact.size()];
        paramCloudProtocolResult.beginTransactionNonExclusive();
        int i = 0;
        while (i < this.val$filterContact.size())
        {
          MailContact localMailContact = (MailContact)this.val$filterContact.get(i);
          QMContactProtocolManager.access$000(this.this$0).contact.updateContact(paramCloudProtocolResult, localMailContact);
          QMContactProtocolManager.access$000(this.this$0).contact.resetOffLineOptType(paramCloudProtocolResult, localMailContact.getId());
          arrayOfInt[i] = localMailContact.getHash();
          i += 1;
        }
        QMContactProtocolManager.access$000(this.this$0).contact.rebuildContactHash(paramCloudProtocolResult, arrayOfInt);
        paramCloudProtocolResult.setTransactionSuccessful();
        QMWatcherCenter.triggerEditContactListSuccess(this.val$accountId, this.val$filterContact);
        return;
      }
      catch (Exception localException)
      {
        QMLog.log(6, "QMContactProtocolManager", Log.getStackTraceString(localException));
        return;
      }
      finally
      {
        paramCloudProtocolResult.endTransaction();
      }
    }
    QMWatcherCenter.triggerEditContactListError(this.val$accountId, this.val$filterContact, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactProtocolManager.3
 * JD-Core Version:    0.7.0.1
 */