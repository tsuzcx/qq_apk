package com.tencent.qqmail.model.contact.cursor;

import com.tencent.qqmail.model.mail.QMCursorCollector;

class ContactBlackWhiteListCursor$6$1
  implements Runnable
{
  ContactBlackWhiteListCursor$6$1(ContactBlackWhiteListCursor.6 param6) {}
  
  public void run()
  {
    ContactBlackWhiteListCursor.access$202(this.this$1.this$0, ContactBlackWhiteListCursor.access$300(this.this$1.this$0));
    if (ContactBlackWhiteListCursor.access$100(this.this$1.this$0) != null) {
      ContactBlackWhiteListCursor.access$100(this.this$1.this$0).run();
    }
    QMCursorCollector.retain(this.this$1.val$originalCursorRecentSender);
    QMCursorCollector.retain(this.this$1.val$originalCursorContactList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBlackWhiteListCursor.6.1
 * JD-Core Version:    0.7.0.1
 */