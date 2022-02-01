package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.List;

class SearchMailQueueHandler$5
  implements SearchMailQueueHandler.ISearchOnEmpty
{
  SearchMailQueueHandler$5(SearchMailQueueHandler paramSearchMailQueueHandler) {}
  
  public void run(SearchInfo paramSearchInfo)
  {
    if (SearchMailQueueHandler.access$100(this.this$0).size() == 0)
    {
      QMLog.log(6, "SearchMailQueueHandler", "empty, carriers.size:" + SearchMailQueueHandler.access$100(this.this$0).size());
      return;
    }
    QMLog.log(4, "SearchMailQueueHandler", "setOnEmpty: in");
    SearchMailQueueHandler.access$200(this.this$0).remove(paramSearchInfo);
    if ((SearchMailQueueHandler.access$200(this.this$0).hasNext()) && (!SearchMailQueueHandler.access$200(this.this$0).hasErrorToStop()))
    {
      this.this$0.sendEmptyMessageDelayed(-980, 0L);
      return;
    }
    Threads.runOnMainThread(new SearchMailQueueHandler.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.5
 * JD-Core Version:    0.7.0.1
 */