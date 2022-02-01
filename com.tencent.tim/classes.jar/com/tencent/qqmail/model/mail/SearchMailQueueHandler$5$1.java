package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;

class SearchMailQueueHandler$5$1
  implements Runnable
{
  SearchMailQueueHandler$5$1(SearchMailQueueHandler.5 param5) {}
  
  public void run()
  {
    if (SearchMailQueueHandler.access$200(this.this$1.this$0).isEmpty())
    {
      QMLog.log(4, "SearchMailQueueHandler", "setOnEmpty:complete");
      QMWatcherCenter.triggerSearchMailComplete();
      return;
    }
    QMLog.log(4, "SearchMailQueueHandler", "setOnEmpty:end, queue isRunning[" + SearchMailQueueHandler.access$200(this.this$1.this$0).isRunning() + "]");
    boolean bool = SearchMailQueueHandler.access$200(this.this$1.this$0).isRunning();
    QMWatcherCenter.triggerSearchMailSuccess(new long[0], bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.5.1
 * JD-Core Version:    0.7.0.1
 */