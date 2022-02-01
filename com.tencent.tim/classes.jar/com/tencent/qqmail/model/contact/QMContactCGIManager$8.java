package com.tencent.qqmail.model.contact;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;

class QMContactCGIManager$8
  implements QMCallback.ISuccessCallback
{
  QMContactCGIManager$8(QMContactCGIManager paramQMContactCGIManager, int paramInt, ArrayList paramArrayList) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    QMContactCGIManager.access$400(this.this$0, this.val$accountId, paramQMNetworkRequest);
    paramQMNetworkRequest = QMContactCGIManager.access$000(this.this$0).getWritableDatabase();
    try
    {
      paramQMNetworkRequest.beginTransaction();
      paramQMNetworkResponse = new int[this.val$ids.size()];
      int i = 0;
      while (i < this.val$ids.size())
      {
        MailContact localMailContact = QMContactCGIManager.access$000(this.this$0).contact.getContactById(paramQMNetworkRequest, ((Long)this.val$ids.get(i)).longValue());
        QMContactCGIManager.access$000(this.this$0).contact.deleteContact(paramQMNetworkRequest, localMailContact.getId());
        paramQMNetworkResponse[i] = localMailContact.getHash();
        i += 1;
      }
      QMContactCGIManager.access$000(this.this$0).contact.rebuildContactHash(paramQMNetworkRequest, paramQMNetworkResponse);
      paramQMNetworkRequest.setTransactionSuccessful();
    }
    catch (Exception paramQMNetworkResponse)
    {
      for (;;)
      {
        QMLog.log(6, "QMContactCGIManager", Log.getStackTraceString(paramQMNetworkResponse));
        paramQMNetworkRequest.endTransaction();
      }
    }
    finally
    {
      paramQMNetworkRequest.endTransaction();
    }
    QMWatcherCenter.triggerDeleteContactListSuccess(this.val$accountId, this.val$ids);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.8
 * JD-Core Version:    0.7.0.1
 */