package com.tencent.qqmail.model.contact;

import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import java.util.HashMap;

class QMContactCGIManager$12
  implements QMCallback.ISuccessCallback
{
  QMContactCGIManager$12(QMContactCGIManager paramQMContactCGIManager, MailContact paramMailContact, HashMap paramHashMap) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    QMContactCGIManager.access$000(this.this$0).contact.setVipContact(QMContactCGIManager.access$000(this.this$0).getWritableDatabase(), Long.valueOf(this.val$contact.getId()), true);
    QMWatcherCenter.triggerVipContactSuccess(this.val$cidMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactCGIManager.12
 * JD-Core Version:    0.7.0.1
 */