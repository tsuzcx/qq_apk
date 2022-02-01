package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import java.util.concurrent.Callable;

class ComposeContactsActivity$4
  implements Callable<ContactBaseListCursor>
{
  ComposeContactsActivity$4(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public ContactBaseListCursor call()
  {
    ContactBaseListCursor localContactBaseListCursor = QMContactManager.sharedInstance().getComposeContactCursor();
    localContactBaseListCursor.setOnRefresh(new ComposeContactsActivity.4.1(this));
    localContactBaseListCursor.setThreadWrapper(new ComposeContactsActivity.4.2(this));
    localContactBaseListCursor.refresh(true, null);
    return localContactBaseListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.4
 * JD-Core Version:    0.7.0.1
 */