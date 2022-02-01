package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;

class SearchMailQueueHandler$2$1
  implements Runnable
{
  SearchMailQueueHandler$2$1(SearchMailQueueHandler.2 param2, long paramLong) {}
  
  public void run()
  {
    QMWatcherCenter.triggerSearchMailProcess(this.val$id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.2.1
 * JD-Core Version:    0.7.0.1
 */