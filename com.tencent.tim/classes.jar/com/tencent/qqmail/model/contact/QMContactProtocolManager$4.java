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
import com.tencent.qqmail.protocol.UMA.ContactDelResp;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

class QMContactProtocolManager$4
  extends SimpleOnProtocolListener
{
  QMContactProtocolManager$4(QMContactProtocolManager paramQMContactProtocolManager, int paramInt, ArrayList paramArrayList) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    if ((paramCloudProtocolResult.error_code_ == 0) && (paramCloudProtocolResult.contact_del_resp_ != null))
    {
      paramCloudProtocolResult = paramCloudProtocolResult.contact_del_resp_.sync_key;
      QMSettingManager.sharedInstance().setContactSyncKey(this.val$accountId, MailContact.ContactType.ProtocolContact, paramCloudProtocolResult);
      paramCloudProtocolResult = QMContactProtocolManager.access$000(this.this$0).getWritableDatabase();
      try
      {
        paramCloudProtocolResult.beginTransactionNonExclusive();
        int[] arrayOfInt = new int[this.val$ids.size()];
        int i = 0;
        while (i < this.val$ids.size())
        {
          MailContact localMailContact = QMContactProtocolManager.access$000(this.this$0).contact.getContactById(paramCloudProtocolResult, ((Long)this.val$ids.get(i)).longValue());
          QMContactProtocolManager.access$000(this.this$0).contact.deleteContact(paramCloudProtocolResult, localMailContact.getId());
          arrayOfInt[i] = localMailContact.getHash();
          i += 1;
        }
        QMContactProtocolManager.access$000(this.this$0).contact.rebuildContactHash(paramCloudProtocolResult, arrayOfInt);
        paramCloudProtocolResult.setTransactionSuccessful();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.log(6, "QMContactProtocolManager", Log.getStackTraceString(localException));
          paramCloudProtocolResult.endTransaction();
        }
      }
      finally
      {
        paramCloudProtocolResult.endTransaction();
      }
      QMWatcherCenter.triggerDeleteContactListSuccess(this.val$accountId, this.val$ids);
      QMLog.log(4, "QMContactProtocolManager", "delete protocol contact success");
      return;
    }
    QMWatcherCenter.triggerDeleteContactListError(this.val$accountId, this.val$ids, null);
    QMLog.log(6, "QMContactProtocolManager", "delete protocol contact error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactProtocolManager.4
 * JD-Core Version:    0.7.0.1
 */