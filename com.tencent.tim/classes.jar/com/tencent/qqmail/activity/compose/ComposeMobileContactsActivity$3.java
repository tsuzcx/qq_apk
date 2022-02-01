package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import java.util.concurrent.Callable;

class ComposeMobileContactsActivity$3
  implements Callable<ContactBaseListCursor>
{
  ComposeMobileContactsActivity$3(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public ContactBaseListCursor call()
  {
    ContactBaseListCursor localContactBaseListCursor = QMContactManager.sharedInstance().getSearchContactListCursor(1, 0, 0, 0, ComposeMobileContactsActivity.access$600(this.this$0));
    localContactBaseListCursor.refresh(true, null);
    localContactBaseListCursor.setOnRefresh(new ComposeMobileContactsActivity.3.1(this));
    localContactBaseListCursor.setThreadWrapper(new ComposeMobileContactsActivity.3.2(this));
    return localContactBaseListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.3
 * JD-Core Version:    0.7.0.1
 */