package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import java.util.concurrent.Callable;

class ContactBaseListCursor$3
  implements Callable<Cursor>
{
  ContactBaseListCursor$3(ContactBaseListCursor paramContactBaseListCursor) {}
  
  public Cursor call()
    throws Exception
  {
    Cursor localCursor = this.this$0.queryRawCursor();
    if (localCursor != null) {
      localCursor.getCount();
    }
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor.3
 * JD-Core Version:    0.7.0.1
 */