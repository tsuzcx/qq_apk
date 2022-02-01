package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.contact.QMContactManager;

class QMGroupChoserActivity$3
  implements Runnable
{
  QMGroupChoserActivity$3(QMGroupChoserActivity paramQMGroupChoserActivity) {}
  
  public void run()
  {
    QMContactManager.sharedInstance().loadGroupContacts(QMGroupChoserActivity.access$400(this.this$0).getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMGroupChoserActivity.3
 * JD-Core Version:    0.7.0.1
 */