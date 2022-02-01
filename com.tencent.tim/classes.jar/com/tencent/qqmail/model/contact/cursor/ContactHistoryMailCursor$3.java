package com.tencent.qqmail.model.contact.cursor;

import com.tencent.qqmail.model.mail.SearchMailQueueHandler.ISearchFilter;
import com.tencent.qqmail.model.qmdomain.SearchInfo;

class ContactHistoryMailCursor$3
  implements SearchMailQueueHandler.ISearchFilter
{
  ContactHistoryMailCursor$3(ContactHistoryMailCursor paramContactHistoryMailCursor) {}
  
  public boolean run(SearchInfo paramSearchInfo)
  {
    return this.this$0.queryCanSearchRemote(paramSearchInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactHistoryMailCursor.3
 * JD-Core Version:    0.7.0.1
 */