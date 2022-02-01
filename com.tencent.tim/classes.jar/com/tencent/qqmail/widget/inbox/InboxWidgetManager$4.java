package com.tencent.qqmail.widget.inbox;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;

class InboxWidgetManager$4
  implements ICallBack
{
  InboxWidgetManager$4(InboxWidgetManager paramInboxWidgetManager) {}
  
  public void callback(Object paramObject)
  {
    QMLog.log(4, "InboxWidgetManager", "inboxUpdateIObserver");
    this.this$0.loadDataSource();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.inbox.InboxWidgetManager.4
 * JD-Core Version:    0.7.0.1
 */