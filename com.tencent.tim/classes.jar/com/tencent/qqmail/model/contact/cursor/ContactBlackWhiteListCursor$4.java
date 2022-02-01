package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import java.util.concurrent.Callable;

class ContactBlackWhiteListCursor$4
  implements Callable<Cursor>
{
  ContactBlackWhiteListCursor$4(ContactBlackWhiteListCursor paramContactBlackWhiteListCursor) {}
  
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
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBlackWhiteListCursor.4
 * JD-Core Version:    0.7.0.1
 */