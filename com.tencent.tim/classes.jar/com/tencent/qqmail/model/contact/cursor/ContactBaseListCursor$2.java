package com.tencent.qqmail.model.contact.cursor;

import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class ContactBaseListCursor$2
  implements Runnable
{
  ContactBaseListCursor$2(ContactBaseListCursor paramContactBaseListCursor, QMRefreshCallback paramQMRefreshCallback) {}
  
  public void run()
  {
    this.val$refreshCallback.onRefreshComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor.2
 * JD-Core Version:    0.7.0.1
 */