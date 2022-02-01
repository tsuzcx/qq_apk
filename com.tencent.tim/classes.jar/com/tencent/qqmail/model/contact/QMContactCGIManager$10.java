package com.tencent.qqmail.model.contact;

import android.util.Log;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class QMContactCGIManager$10
  implements QMCallback.ISuccessCallback
{
  QMContactCGIManager$10(QMContactCGIManager paramQMContactCGIManager, MailContact paramMailContact, int paramInt, HashMap paramHashMap) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    Object localObject2 = (JSONObject)paramQMNetworkResponse.getResponseJson();
    paramQMNetworkRequest = QMContactCGIManager.access$000(this.this$0).getWritableDatabase();
    for (;;)
    {
      int i;
      try
      {
        paramQMNetworkRequest.beginTransaction();
        QMContactCGIManager.access$000(this.this$0).contact.deleteContact(paramQMNetworkRequest, this.val$contact.getId());
        QMContactCGIManager.access$000(this.this$0).contact.rebuildContactHash(paramQMNetworkRequest, new int[] { this.val$contact.getHash() });
        paramQMNetworkResponse = new ArrayList();
        localObject1 = new ArrayList();
        if (((JSONObject)localObject2).containsKey("items"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONObject("items");
          if (((JSONObject)localObject2).containsKey("item"))
          {
            localObject2 = ((JSONObject)localObject2).getJSONArray("item");
            i = 0;
            if (i < ((JSONArray)localObject2).size())
            {
              JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
              MailContact localMailContact = new MailContact();
              localMailContact.parseWithDictionary(localJSONObject);
              localMailContact.setAccountId(this.val$accountId);
              localMailContact.setType(MailContact.ContactType.NormalContact);
              localMailContact.setGroup(null);
              localMailContact.setHashType(0);
              localMailContact.setHash(MailContact.generateHash(localMailContact));
              localMailContact.setOfflineType(0);
              localMailContact.setId(MailContact.generateId(localMailContact));
              localMailContact.setIsVip(true);
              if (QMContactCGIManager.access$000(this.this$0).contact.isContactExistWithAccountAndCid(paramQMNetworkRequest, this.val$accountId, localMailContact.getCid())) {
                paramQMNetworkResponse.add(localMailContact.getCid());
              } else {
                ((ArrayList)localObject1).add(localMailContact);
              }
            }
          }
        }
      }
      catch (Exception paramQMNetworkResponse)
      {
        Object localObject1;
        QMLog.log(6, "QMContactCGIManager", Log.getStackTraceString(paramQMNetworkResponse));
        paramQMNetworkRequest.endTransaction();
        QMWatcherCenter.triggerVipContactSuccess(this.val$cidMap);
        return;
        QMContactCGIManager.access$000(this.this$0).contact.clearAllVipByAccount(paramQMNetworkRequest, this.val$accountId);
        QMContactCGIManager.access$000(this.this$0).contact.setVipContactByAccount(paramQMNetworkRequest, this.val$accountId, paramQMNetworkResponse);
        paramQMNetworkResponse = ((ArrayList)localObject1).iterator();
        if (paramQMNetworkResponse.hasNext())
        {
          localObject1 = (MailContact)paramQMNetworkResponse.next();
          QMContactCGIManager.access$000(this.this$0).contact.insertContact(paramQMNetworkRequest, this.val$accountId, (MailContact)localObject1);
          QMContactCGIManager.access$000(this.this$0).contact.rebuildContactHash(paramQMNetworkRequest, new int[] { ((MailContact)localObject1).getHash() });
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
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.10
 * JD-Core Version:    0.7.0.1
 */