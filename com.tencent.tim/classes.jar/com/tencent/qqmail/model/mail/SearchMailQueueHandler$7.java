package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.List;

class SearchMailQueueHandler$7
  implements SearchMailQueueHandler.ISearchOnComplete
{
  SearchMailQueueHandler$7(SearchMailQueueHandler paramSearchMailQueueHandler) {}
  
  public void run(SearchInfo paramSearchInfo)
  {
    if (SearchMailQueueHandler.access$100(this.this$0).size() == 0)
    {
      QMLog.log(6, "SearchMailQueueHandler", "complete, carriers.size:" + SearchMailQueueHandler.access$100(this.this$0).size());
      return;
    }
    QMLog.log(4, "SearchMailQueueHandler", "setOnComplete: in");
    SearchMailQueueHandler.access$200(this.this$0).remove(paramSearchInfo);
    Threads.runOnMainThread(new SearchMailQueueHandler.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.7
 * JD-Core Version:    0.7.0.1
 */