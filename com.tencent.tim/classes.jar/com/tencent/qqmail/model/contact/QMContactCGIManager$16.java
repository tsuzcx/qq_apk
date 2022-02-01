package com.tencent.qqmail.model.contact;

import android.util.Log;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class QMContactCGIManager$16
  implements QMCallback.ISuccessCallback
{
  QMContactCGIManager$16(QMContactCGIManager paramQMContactCGIManager, String paramString, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    int i = 0;
    RequestFilter.resetRequestRunningState(this.val$requestFilterKey);
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    JSONArray localJSONArray;
    Object localObject;
    ArrayList localArrayList;
    if (paramQMNetworkResponse.containsKey("addrs"))
    {
      localJSONArray = paramQMNetworkResponse.getJSONArray("addrs");
      localObject = new ArrayList();
      localArrayList = new ArrayList();
      paramQMNetworkRequest = QMContactCGIManager.access$000(this.this$0).getWritableDatabase();
    }
    for (;;)
    {
      try
      {
        paramQMNetworkRequest.beginTransactionNonExclusive();
        if (i < localJSONArray.size())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          String str = localJSONObject.getString("id");
          if (QMContactCGIManager.access$000(this.this$0).contact.isContactExistWithAccountAndCid(paramQMNetworkRequest, this.val$accountId, str)) {
            ((ArrayList)localObject).add(str);
          } else {
            localArrayList.add(QMContactCGIManager.access$500(this.this$0, localJSONObject, this.val$accountId));
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "QMContactCGIManager", Log.getStackTraceString(localException));
        paramQMNetworkRequest.endTransaction();
        if (paramQMNetworkResponse.containsKey("svr")) {
          QMSettingManager.sharedInstance().setAddrVipLoadUTC(this.val$accountId, paramQMNetworkResponse.getLong("svr").longValue());
        }
        QMWatcherCenter.triggerLoadVipContactListSuccess(this.val$accountId);
        return;
        QMContactCGIManager.access$000(this.this$0).contact.clearAllVipByAccount(paramQMNetworkRequest, this.val$accountId);
        QMContactCGIManager.access$000(this.this$0).contact.setVipContactByAccount(paramQMNetworkRequest, this.val$accountId, (List)localObject);
        Iterator localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
        {
          localObject = (MailContact)localIterator.next();
          QMContactCGIManager.access$000(this.this$0).contact.insertContact(paramQMNetworkRequest, this.val$accountId, (MailContact)localObject);
          QMContactCGIManager.access$000(this.this$0).contact.rebuildContactHash(paramQMNetworkRequest, new int[] { ((MailContact)localObject).getHash() });
          continue;
        }
      }
      finally
      {
        paramQMNetworkRequest.endTransaction();
      }
      paramQMNetworkRequest.setTransactionSuccessful();
      paramQMNetworkRequest.endTransaction();
      continue;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.16
 * JD-Core Version:    0.7.0.1
 */