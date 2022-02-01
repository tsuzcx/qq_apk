package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMCursorCollector;

class ContactBlackWhiteListCursor$5
  implements Runnable
{
  ContactBlackWhiteListCursor$5(ContactBlackWhiteListCursor paramContactBlackWhiteListCursor, Cursor paramCursor1, Cursor paramCursor2) {}
  
  public void run()
  {
    if (ContactBlackWhiteListCursor.access$100(this.this$0) != null) {
      ContactBlackWhiteListCursor.access$100(this.this$0).run();
    }
    QMCursorCollector.retain(this.val$originalCursorRecentSender);
    QMCursorCollector.retain(this.val$originalCursorContactList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBlackWhiteListCursor.5
 * JD-Core Version:    0.7.0.1
 */