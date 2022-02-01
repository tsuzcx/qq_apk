package com.tencent.qqmail.widget.inbox;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;
import com.tencent.qqmail.utilities.log.QMLog;

class InboxWidgetManager$3$3
  extends QMRefreshCallback
{
  InboxWidgetManager$3$3(InboxWidgetManager.3 param3) {}
  
  public void onRefreshComplete()
  {
    QMLog.log(4, "InboxWidgetManager", "curosr refresh onRefreshComplete");
    this.this$1.this$0.notifyDataChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.inbox.InboxWidgetManager.3.3
 * JD-Core Version:    0.7.0.1
 */