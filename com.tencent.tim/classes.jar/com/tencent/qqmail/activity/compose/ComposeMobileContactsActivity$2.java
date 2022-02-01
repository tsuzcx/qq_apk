package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import java.util.concurrent.Callable;

class ComposeMobileContactsActivity$2
  implements Callable<ContactBaseListCursor>
{
  ComposeMobileContactsActivity$2(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public ContactBaseListCursor call()
  {
    ContactBaseListCursor localContactBaseListCursor = QMContactManager.sharedInstance().getMobileContactCursor();
    localContactBaseListCursor.setOnRefresh(new ComposeMobileContactsActivity.2.1(this));
    localContactBaseListCursor.setThreadWrapper(new ComposeMobileContactsActivity.2.2(this));
    localContactBaseListCursor.refresh(true, null);
    return localContactBaseListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.2
 * JD-Core Version:    0.7.0.1
 */