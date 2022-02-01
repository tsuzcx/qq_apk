package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import java.util.concurrent.Callable;

class VIPContactsFragment$5
  implements Callable<ContactBaseListCursor>
{
  VIPContactsFragment$5(VIPContactsFragment paramVIPContactsFragment) {}
  
  public ContactBaseListCursor call()
  {
    ContactBaseListCursor localContactBaseListCursor = QMContactManager.sharedInstance().getSearchContactListCursor(VIPContactsFragment.access$700(this.this$0), VIPContactsFragment.access$800(this.this$0), VIPContactsFragment.access$900(this.this$0), VIPContactsFragment.access$1000(this.this$0), VIPContactsFragment.access$1400(this.this$0));
    localContactBaseListCursor.refresh(true, null);
    localContactBaseListCursor.setOnRefresh(new VIPContactsFragment.5.1(this));
    localContactBaseListCursor.setThreadWrapper(new VIPContactsFragment.5.2(this));
    return localContactBaseListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.5
 * JD-Core Version:    0.7.0.1
 */