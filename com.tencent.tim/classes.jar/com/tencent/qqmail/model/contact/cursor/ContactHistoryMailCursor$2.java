package com.tencent.qqmail.model.contact.cursor;

import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.SearchMailQueueHandler.ISearchGetCarrier;
import com.tencent.qqmail.model.mail.SearchMailQueueHandler.SearchMailCallback;
import com.tencent.qqmail.model.qmdomain.SearchInfo;
import com.tencent.qqmail.utilities.qmnetwork.IAbortable;

class ContactHistoryMailCursor$2
  implements SearchMailQueueHandler.ISearchGetCarrier
{
  ContactHistoryMailCursor$2(ContactHistoryMailCursor paramContactHistoryMailCursor1, ContactHistoryMailCursor paramContactHistoryMailCursor2) {}
  
  public IAbortable run(SearchInfo paramSearchInfo, SearchMailQueueHandler.SearchMailCallback paramSearchMailCallback)
  {
    return ContactHistoryMailCursor.access$500(this.this$0).searchMails(this.val$self, paramSearchInfo, paramSearchMailCallback, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactHistoryMailCursor.2
 * JD-Core Version:    0.7.0.1
 */