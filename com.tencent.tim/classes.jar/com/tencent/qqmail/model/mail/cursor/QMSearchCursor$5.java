package com.tencent.qqmail.model.mail.cursor;

import com.tencent.qqmail.model.mail.SearchMailQueueHandler.ISearchFilter;
import com.tencent.qqmail.model.qmdomain.SearchInfo;

class QMSearchCursor$5
  implements SearchMailQueueHandler.ISearchFilter
{
  QMSearchCursor$5(QMSearchCursor paramQMSearchCursor) {}
  
  public boolean run(SearchInfo paramSearchInfo)
  {
    return this.this$0.queryCanSearchRemote(paramSearchInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.cursor.QMSearchCursor.5
 * JD-Core Version:    0.7.0.1
 */