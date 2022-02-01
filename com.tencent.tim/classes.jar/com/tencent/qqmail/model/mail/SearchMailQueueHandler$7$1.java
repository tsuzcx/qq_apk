package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;

class SearchMailQueueHandler$7$1
  implements Runnable
{
  SearchMailQueueHandler$7$1(SearchMailQueueHandler.7 param7) {}
  
  public void run()
  {
    QMLog.log(4, "SearchMailQueueHandler", "setOnComplete");
    if (SearchMailQueueHandler.access$200(this.this$1.this$0).isEmpty())
    {
      QMWatcherCenter.triggerSearchMailComplete();
      return;
    }
    boolean bool = SearchMailQueueHandler.access$200(this.this$1.this$0).isRunning();
    QMWatcherCenter.triggerSearchMailSuccess(new long[] { 0L }, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.7.1
 * JD-Core Version:    0.7.0.1
 */