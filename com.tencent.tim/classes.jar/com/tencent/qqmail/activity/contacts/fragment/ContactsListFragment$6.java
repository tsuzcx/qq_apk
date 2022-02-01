package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.contact.QMContactManager;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import java.util.concurrent.Callable;

class ContactsListFragment$6
  implements Callable<ContactBaseListCursor>
{
  ContactsListFragment$6(ContactsListFragment paramContactsListFragment) {}
  
  public ContactBaseListCursor call()
  {
    ContactBaseListCursor localContactBaseListCursor = QMContactManager.sharedInstance().getContactListCursor(ContactsListFragment.access$200(this.this$0), ContactsListFragment.access$1500(this.this$0), ContactsListFragment.access$300(this.this$0), ContactsListFragment.access$1600(this.this$0), ContactsListFragment.access$1700(this.this$0));
    localContactBaseListCursor.setOnRefresh(new ContactsListFragment.6.1(this));
    localContactBaseListCursor.setThreadWrapper(new ContactsListFragment.6.2(this));
    localContactBaseListCursor.refresh(true, null);
    return localContactBaseListCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.6
 * JD-Core Version:    0.7.0.1
 */