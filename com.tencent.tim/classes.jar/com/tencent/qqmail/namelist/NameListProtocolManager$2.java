package com.tencent.qqmail.namelist;

import android.util.Log;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.namelist.model.NameListContact;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.log.QMLog;

class NameListProtocolManager$2
  extends SimpleOnProtocolListener
{
  NameListProtocolManager$2(NameListProtocolManager paramNameListProtocolManager, String[] paramArrayOfString, int paramInt1, int paramInt2) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "NameListProtocolManager", "addProtocolNameList result: " + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      paramCloudProtocolResult = this.val$emails;
      int j = paramCloudProtocolResult.length;
      int i = 0;
      if (i < j)
      {
        String str = paramCloudProtocolResult[i];
        if (NameListManager.sharedInstance().getNameListContactById(NameListContact.generateId(this.val$accountId, str)) != null)
        {
          NameListManager.sharedInstance().sqlUpdateNameListContactTypeByContactId(this.val$type, NameListContact.generateId(this.val$accountId, str));
          Log.d("donald", "add update");
        }
        for (;;)
        {
          i += 1;
          break;
          NameListProtocolManager.access$100(this.this$0, str, this.val$type, this.val$accountId);
          Log.d("donald", "add new");
        }
      }
      QMWatcherCenter.triggerAddNameListSuccess(this.val$accountId, this.val$type, this.val$emails);
      return;
    }
    QMWatcherCenter.triggerAddNameListError(this.val$accountId, this.val$type, this.val$emails, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListProtocolManager.2
 * JD-Core Version:    0.7.0.1
 */