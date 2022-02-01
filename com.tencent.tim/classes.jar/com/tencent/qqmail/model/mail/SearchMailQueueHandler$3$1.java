package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;

class SearchMailQueueHandler$3$1
  implements Runnable
{
  SearchMailQueueHandler$3$1(SearchMailQueueHandler.3 param3) {}
  
  public void run()
  {
    QMLog.log(4, "SearchMailQueueHandler", "setOnMoveOn: ---- " + SearchMailQueueHandler.access$200(this.this$1.this$0).isRunning());
    boolean bool = SearchMailQueueHandler.access$200(this.this$1.this$0).isRunning();
    QMWatcherCenter.triggerSearchMailSuccess(new long[] { 0L }, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.3.1
 * JD-Core Version:    0.7.0.1
 */