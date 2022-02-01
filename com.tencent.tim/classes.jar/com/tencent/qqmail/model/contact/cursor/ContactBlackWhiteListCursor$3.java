package com.tencent.qqmail.model.contact.cursor;

import android.database.Cursor;
import java.util.concurrent.Callable;

class ContactBlackWhiteListCursor$3
  implements Callable<Cursor>
{
  ContactBlackWhiteListCursor$3(ContactBlackWhiteListCursor paramContactBlackWhiteListCursor) {}
  
  public Cursor call()
    throws Exception
  {
    Cursor localCursor = ContactBlackWhiteListCursor.access$000(this.this$0);
    if (localCursor != null) {
      localCursor.getCount();
    }
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBlackWhiteListCursor.3
 * JD-Core Version:    0.7.0.1
 */