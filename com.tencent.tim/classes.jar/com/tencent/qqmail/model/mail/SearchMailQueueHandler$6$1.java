package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class SearchMailQueueHandler$6$1
  implements Runnable
{
  SearchMailQueueHandler$6$1(SearchMailQueueHandler.6 param6, QMNetworkError paramQMNetworkError) {}
  
  public void run()
  {
    if (SearchMailQueueHandler.access$200(this.this$1.this$0).isEmpty())
    {
      QMLog.log(4, "SearchMailQueueHandler", "setOnError:complete");
      QMWatcherCenter.triggerSearchMailComplete();
      return;
    }
    QMLog.log(4, "SearchMailQueueHandler", "setOnError:end, queue isRunning[" + SearchMailQueueHandler.access$200(this.this$1.this$0).isRunning() + "]");
    QMWatcherCenter.triggerSearchMailError(this.val$error, SearchMailQueueHandler.access$200(this.this$1.this$0).isRunning());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.6.1
 * JD-Core Version:    0.7.0.1
 */