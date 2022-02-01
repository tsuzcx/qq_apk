package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.thread.Threads;

class SearchMailQueueHandler$2
  implements SearchMailQueueHandler.ISearchOnProcess
{
  SearchMailQueueHandler$2(SearchMailQueueHandler paramSearchMailQueueHandler) {}
  
  public void run(SearchInfo paramSearchInfo, long paramLong)
  {
    Threads.runOnMainThread(new SearchMailQueueHandler.2.1(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.2
 * JD-Core Version:    0.7.0.1
 */