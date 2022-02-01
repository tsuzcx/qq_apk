package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import com.tencent.qqmail.model.mail.QMCursorCollector;

class ContactBaseListCursor$4
  implements Runnable
{
  ContactBaseListCursor$4(ContactBaseListCursor paramContactBaseListCursor, boolean paramBoolean, Cursor paramCursor) {}
  
  public void run()
  {
    if ((this.val$noData) && (ContactBaseListCursor.access$000(this.this$0) != null)) {
      ContactBaseListCursor.access$000(this.this$0).run();
    }
    QMCursorCollector.release(this.val$originalCursor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor.4
 * JD-Core Version:    0.7.0.1
 */