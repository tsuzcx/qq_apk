package com.tencent.qqmail.model.contact.cursor;

import com.tencent.qqmail.model.mail.QMCursorCollector;

class ContactBaseListCursor$5$1
  implements Runnable
{
  ContactBaseListCursor$5$1(ContactBaseListCursor.5 param5) {}
  
  public void run()
  {
    ContactBaseListCursor.access$102(this.this$1.this$0, ContactBaseListCursor.access$200(this.this$1.this$0));
    if (ContactBaseListCursor.access$000(this.this$1.this$0) != null) {
      ContactBaseListCursor.access$000(this.this$1.this$0).run();
    }
    QMCursorCollector.release(this.this$1.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor.5.1
 * JD-Core Version:    0.7.0.1
 */