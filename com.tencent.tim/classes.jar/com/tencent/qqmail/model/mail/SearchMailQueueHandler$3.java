package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.List;

class SearchMailQueueHandler$3
  implements SearchMailQueueHandler.ISearchOnMoveOn
{
  SearchMailQueueHandler$3(SearchMailQueueHandler paramSearchMailQueueHandler) {}
  
  public void run(SearchInfo paramSearchInfo, long[] paramArrayOfLong)
  {
    if (SearchMailQueueHandler.access$100(this.this$0).size() == 0) {
      return;
    }
    QMLog.log(4, "SearchMailQueueHandler", "setOnMoveOn: in");
    SearchMailQueueHandler.access$200(this.this$0).moveon(paramSearchInfo);
    Threads.runOnMainThread(new SearchMailQueueHandler.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.3
 * JD-Core Version:    0.7.0.1
 */