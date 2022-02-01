package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import java.util.concurrent.Callable;

class ContactBaseListCursor$5
  implements Callable<Cursor>
{
  ContactBaseListCursor$5(ContactBaseListCursor paramContactBaseListCursor, Cursor paramCursor) {}
  
  public Cursor call()
  {
    Cursor localCursor = this.this$0.queryRawCursor();
    if (localCursor != null) {
      localCursor.getCount();
    }
    ContactBaseListCursor.access$300(this.this$0).runOnMainThreadWithContext(new ContactBaseListCursor.5.1(this));
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor.5
 * JD-Core Version:    0.7.0.1
 */