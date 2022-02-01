package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import java.util.concurrent.Callable;

class ContactsListFragment$7
  implements Callable<ContactBaseListCursor>
{
  ContactsListFragment$7(ContactsListFragment paramContactsListFragment) {}
  
  public ContactBaseListCursor call()
  {
    ContactBaseListCursor localContactBaseListCursor = QMContactManager.sharedInstance().getSearchContactListCursor(ContactsListFragment.access$200(this.this$0), ContactsListFragment.access$1500(this.this$0), ContactsListFragment.access$300(this.this$0), ContactsListFragment.access$1600(this.this$0), ContactsListFragment.access$2100(this.this$0));
    localContactBaseListCursor.refresh(true, null);
    localContactBaseListCursor.setOnRefresh(new ContactsListFragment.7.1(this));
    localContactBaseListCursor.setThreadWrapper(new ContactsListFragment.7.2(this));
    return localContactBaseListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.7
 * JD-Core Version:    0.7.0.1
 */