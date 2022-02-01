package com.tencent.qqmail.widget.inbox;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.concurrent.Callable;

class InboxWidgetManager$3
  implements Callable<QMMailListCursor>
{
  InboxWidgetManager$3(InboxWidgetManager paramInboxWidgetManager) {}
  
  public QMMailListCursor call()
  {
    int i = InboxWidgetManager.access$100(this.this$0).getId();
    int j = InboxWidgetManager.access$200(this.this$0).getId();
    QMLog.log(4, "InboxWidgetManager", "Update inbox widget folder-name = " + InboxWidgetManager.access$200(this.this$0).getName() + " folder-id = " + InboxWidgetManager.access$200(this.this$0).getId());
    QMMailListCursor localQMMailListCursor = QMMailManager.sharedInstance().getMailListCursor(i, j);
    if (localQMMailListCursor != null)
    {
      localQMMailListCursor.setOnRefresh(new InboxWidgetManager.3.1(this));
      localQMMailListCursor.setThreadWrapper(new InboxWidgetManager.3.2(this));
      localQMMailListCursor.refresh(true, new InboxWidgetManager.3.3(this));
    }
    return localQMMailListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.inbox.InboxWidgetManager.3
 * JD-Core Version:    0.7.0.1
 */