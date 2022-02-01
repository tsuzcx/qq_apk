package com.tencent.qqmail.widget.inbox;

import com.tencent.qqmail.model.mail.watcher.LoadListWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class InboxWidgetManager$1
  implements LoadListWatcher
{
  InboxWidgetManager$1(InboxWidgetManager paramInboxWidgetManager) {}
  
  public void onError(int paramInt, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "InboxWidgetManager", "LoadListWatcher onError");
    InboxWidgetManager.access$002(this.this$0, InboxWidgetManager.LoadingState.ERROR);
    this.this$0.notifyDataChange();
  }
  
  public void onPopIn(long paramLong, String paramString) {}
  
  public void onProcess(int paramInt, boolean paramBoolean) {}
  
  public void onSuccess(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    QMLog.log(4, "InboxWidgetManager", "LoadListWatcher onSuccess");
    if (InboxWidgetManager.access$000(this.this$0) == InboxWidgetManager.LoadingState.LODING)
    {
      InboxWidgetManager.access$002(this.this$0, InboxWidgetManager.LoadingState.NORMAL);
      this.this$0.loadDataSource();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.inbox.InboxWidgetManager.1
 * JD-Core Version:    0.7.0.1
 */