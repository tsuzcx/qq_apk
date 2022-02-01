package com.tencent.qqmail.model.contact;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.ArrayList;

class QMContactCGIManager$6
  implements QMCallback.ISuccessCallback
{
  QMContactCGIManager$6(QMContactCGIManager paramQMContactCGIManager, MailContact paramMailContact, ArrayList paramArrayList) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    paramQMNetworkRequest = (JSONObject)paramQMNetworkResponse.getResponseJson();
    QMContactCGIManager.access$400(this.this$0, this.val$contact.getAccountId(), paramQMNetworkRequest);
    paramQMNetworkRequest = QMContactCGIManager.access$000(this.this$0).getWritableDatabase();
    QMContactCGIManager.access$000(this.this$0).contact.updateContact(paramQMNetworkRequest, this.val$contact);
    QMContactCGIManager.access$000(this.this$0).contact.resetOffLineOptType(paramQMNetworkRequest, this.val$contact.getId());
    QMContactCGIManager.access$000(this.this$0).contact.rebuildContactHash(paramQMNetworkRequest, new int[] { this.val$contact.getHash() });
    QMWatcherCenter.triggerEditContactListSuccess(this.val$contact.getAccountId(), this.val$editContacts);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.6
 * JD-Core Version:    0.7.0.1
 */