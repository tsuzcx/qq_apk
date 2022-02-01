package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import java.util.concurrent.Callable;

class ComposeContactsActivity$5
  implements Callable<ContactBaseListCursor>
{
  ComposeContactsActivity$5(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public ContactBaseListCursor call()
  {
    ContactBaseListCursor localContactBaseListCursor = QMContactManager.sharedInstance().getSearchComposeContactCursor(ComposeContactsActivity.access$900(this.this$0));
    localContactBaseListCursor.refresh(true, null);
    localContactBaseListCursor.setOnRefresh(new ComposeContactsActivity.5.1(this));
    localContactBaseListCursor.setThreadWrapper(new ComposeContactsActivity.5.2(this));
    return localContactBaseListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.5
 * JD-Core Version:    0.7.0.1
 */