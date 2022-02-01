package com.tencent.qqmail.model.mail;

import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.List;

class SearchMailQueueHandler$8
  implements SearchMailQueueHandler.ISearchOnLock
{
  SearchMailQueueHandler$8(SearchMailQueueHandler paramSearchMailQueueHandler) {}
  
  public void run(SearchInfo paramSearchInfo, int paramInt)
  {
    if (SearchMailQueueHandler.access$100(this.this$0).size() == 0)
    {
      QMLog.log(6, "SearchMailQueueHandler", "onLock, carriers.size:" + SearchMailQueueHandler.access$100(this.this$0).size());
      return;
    }
    QMLog.log(4, "SearchMailQueueHandler", "setOnLock: personalCnt " + paramInt);
    QMWatcherCenter.triggerSearchMailLock(paramSearchInfo.getAccountId(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.SearchMailQueueHandler.8
 * JD-Core Version:    0.7.0.1
 */