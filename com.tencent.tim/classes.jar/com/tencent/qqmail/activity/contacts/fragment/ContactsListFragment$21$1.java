package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer.OnTextChangeListener;

class ContactsListFragment$21$1
  implements TextChangeTimer.OnTextChangeListener
{
  ContactsListFragment$21$1(ContactsListFragment.21 param21) {}
  
  public void onTextChange()
  {
    Threads.runInBackground(new ContactsListFragment.21.1.1(this));
    ContactsListFragment.access$3400(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.21.1
 * JD-Core Version:    0.7.0.1
 */