package com.tencent.qqmail.model.contact;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.network.filter.RequestFilter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class QMContactCGIManager$1
  implements QMCallback.ISuccessCallback
{
  QMContactCGIManager$1(QMContactCGIManager paramQMContactCGIManager, String paramString, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    RequestFilter.resetRequestRunningState(this.val$requestFilterKey);
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    paramQMNetworkRequest = QMContactCGIManager.access$000(this.this$0).getWritableDatabase();
    try
    {
      paramQMNetworkRequest.beginTransaction();
      JSONObject localJSONObject;
      if (paramQMNetworkResponse.containsKey("normallist"))
      {
        localJSONObject = paramQMNetworkResponse.getJSONObject("normallist");
        QMContactCGIManager.access$100(this.this$0, paramQMNetworkRequest, this.val$accountId, MailContact.ContactType.NormalContact, localJSONObject);
        QMContactCGIManager.access$200(this.this$0, this.val$accountId, MailContact.ContactType.NormalContact, localJSONObject);
      }
      if (paramQMNetworkResponse.containsKey("historylist"))
      {
        localJSONObject = paramQMNetworkResponse.getJSONObject("historylist");
        QMContactCGIManager.access$100(this.this$0, paramQMNetworkRequest, this.val$accountId, MailContact.ContactType.HistoryContact, localJSONObject);
        QMContactCGIManager.access$200(this.this$0, this.val$accountId, MailContact.ContactType.HistoryContact, localJSONObject);
      }
      if (paramQMNetworkResponse.containsKey("qqlist"))
      {
        localJSONObject = paramQMNetworkResponse.getJSONObject("qqlist");
        QMContactCGIManager.access$300(this.this$0, paramQMNetworkRequest, this.val$accountId, MailContact.ContactType.QQFriendContact, localJSONObject);
        QMContactCGIManager.access$200(this.this$0, this.val$accountId, MailContact.ContactType.QQFriendContact, localJSONObject);
      }
      if (paramQMNetworkResponse.containsKey("domainlist"))
      {
        paramQMNetworkResponse = paramQMNetworkResponse.getJSONObject("domainlist");
        QMContactCGIManager.access$300(this.this$0, paramQMNetworkRequest, this.val$accountId, MailContact.ContactType.DomainContact, paramQMNetworkResponse);
        QMContactCGIManager.access$200(this.this$0, this.val$accountId, MailContact.ContactType.DomainContact, paramQMNetworkResponse);
      }
      QMContactManager.sharedInstance().clearContactEmailCountCache();
      QMContactManager.sharedInstance().clearContactTelCache();
      QMContactManager.sharedInstance().clearNickNameCache();
      QMContactManager.sharedInstance().clearComposeContactCache();
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
    QMWatcherCenter.triggerLoadContactListSuccess(this.val$accountId);
    this.this$0.loadVipContacts(this.val$accountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.1
 * JD-Core Version:    0.7.0.1
 */