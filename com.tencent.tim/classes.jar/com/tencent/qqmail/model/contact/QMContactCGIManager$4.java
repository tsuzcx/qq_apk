package com.tencent.qqmail.model.contact;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContact.ContactType;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;

class QMContactCGIManager$4
  implements QMCallback.ISuccessCallback
{
  QMContactCGIManager$4(QMContactCGIManager paramQMContactCGIManager, int paramInt, MailContact paramMailContact, ArrayList paramArrayList) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkResponse = (JSONObject)paramQMNetworkResponse.getResponseJson();
    QMContactCGIManager.access$400(this.this$0, this.val$accountId, paramQMNetworkResponse);
    if (paramQMNetworkResponse.containsKey("cid"))
    {
      long l = this.val$contact.getId();
      paramQMNetworkRequest = this.val$contact.clone();
      paramQMNetworkRequest.setType(MailContact.ContactType.NormalContact);
      paramQMNetworkRequest.setCid(paramQMNetworkResponse.getString("cid"));
      paramQMNetworkRequest.setHashType(0);
      paramQMNetworkRequest.setHash(MailContact.generateHash(paramQMNetworkRequest));
      paramQMNetworkRequest.setOfflineType(0);
      paramQMNetworkRequest.setId(MailContact.generateId(paramQMNetworkRequest));
      paramQMNetworkResponse = QMContactCGIManager.access$000(this.this$0).getWritableDatabase();
      QMContactCGIManager.access$000(this.this$0).contact.deleteContact(paramQMNetworkResponse, this.val$contact.getId());
      QMContactCGIManager.access$000(this.this$0).contact.insertContact(paramQMNetworkResponse, this.val$accountId, paramQMNetworkRequest);
      QMContactCGIManager.access$000(this.this$0).contact.resetOffLineOptType(paramQMNetworkResponse, paramQMNetworkRequest.getId());
      QMContactCGIManager.access$000(this.this$0).contact.rebuildContactHash(paramQMNetworkResponse, new int[] { paramQMNetworkRequest.getHash() });
      QMCalendarManager.getInstance().updateEventByCid(l, paramQMNetworkRequest.getId());
      paramQMNetworkResponse = new ArrayList();
      paramQMNetworkResponse.add(paramQMNetworkRequest);
      QMWatcherCenter.triggerAddContactListSuccess(this.val$accountId, this.val$originIds, paramQMNetworkResponse);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.4
 * JD-Core Version:    0.7.0.1
 */