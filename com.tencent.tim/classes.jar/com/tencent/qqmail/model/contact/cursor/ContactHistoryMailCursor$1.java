package com.tencent.qqmail.model.contact.cursor;

import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.utilities.thread.Threads;

class ContactHistoryMailCursor$1
  implements Runnable
{
  ContactHistoryMailCursor$1(ContactHistoryMailCursor paramContactHistoryMailCursor, Runnable paramRunnable) {}
  
  public void run()
  {
    ContactHistoryMailCursor.access$002(this.this$0, ContactHistoryMailCursor.access$300(this.this$0).mail.getSearchMailIds(ContactHistoryMailCursor.access$100(this.this$0).getReadableDatabase(), ContactHistoryMailCursor.access$200(this.this$0)));
    Threads.runOnMainThread(new ContactHistoryMailCursor.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactHistoryMailCursor.1
 * JD-Core Version:    0.7.0.1
 */