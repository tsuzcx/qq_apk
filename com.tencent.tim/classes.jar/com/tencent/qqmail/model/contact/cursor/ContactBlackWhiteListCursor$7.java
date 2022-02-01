package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import java.util.concurrent.Callable;

class ContactBlackWhiteListCursor$7
  implements Callable<Cursor>
{
  ContactBlackWhiteListCursor$7(ContactBlackWhiteListCursor paramContactBlackWhiteListCursor, Cursor paramCursor1, Cursor paramCursor2) {}
  
  public Cursor call()
  {
    Cursor localCursor = this.this$0.queryRawCursor();
    if (localCursor != null) {
      localCursor.getCount();
    }
    ContactBlackWhiteListCursor.access$400(this.this$0).runOnMainThreadWithContext(new ContactBlackWhiteListCursor.7.1(this));
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBlackWhiteListCursor.7
 * JD-Core Version:    0.7.0.1
 */