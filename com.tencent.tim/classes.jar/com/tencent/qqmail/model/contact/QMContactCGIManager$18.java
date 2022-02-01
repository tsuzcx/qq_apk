package com.tencent.qqmail.model.contact;

import com.alibaba.fastjson.JSONObject;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.model.qmdomain.MailGroupContactList;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.Iterator;
import java.util.List;

class QMContactCGIManager$18
  implements QMCallback.ISuccessCallback
{
  QMContactCGIManager$18(QMContactCGIManager paramQMContactCGIManager, SQLiteDatabase paramSQLiteDatabase, int paramInt) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    QMLog.log(4, "QMContactCGIManager", "grouplist: " + paramQMNetworkRequest);
    if (paramQMNetworkRequest.containsKey("items"))
    {
      QMContactCGIManager.access$000(this.this$0).contact.deleteAccountContactByType(this.val$writableDatabase, this.val$accountId, MailContact.ContactType.GroupContact);
      paramQMNetworkResponse = paramQMNetworkRequest.getJSONObject("items");
      paramQMNetworkRequest = new MailGroupContactList();
      paramQMNetworkRequest.parseWithJson(paramQMNetworkResponse, this.val$accountId);
      paramQMNetworkResponse = paramQMNetworkRequest.getGroupContacts();
      if (paramQMNetworkResponse != null)
      {
        paramQMNetworkResponse = paramQMNetworkResponse.iterator();
        while (paramQMNetworkResponse.hasNext())
        {
          MailGroupContact localMailGroupContact = (MailGroupContact)paramQMNetworkResponse.next();
          QMContactCGIManager.access$000(this.this$0).contact.insertContact(this.val$writableDatabase, this.val$accountId, localMailGroupContact);
        }
      }
      QMSettingManager.sharedInstance().setLastUpdateGroupContactTime(this.val$accountId);
      QMWatcherCenter.triggerLoadGroupContactListSuccess(this.val$accountId, paramQMNetworkRequest);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.18
 * JD-Core Version:    0.7.0.1
 */