package com.tencent.qqmail.activity.contacts.fragment;

class ContactsHistoryMailListFragment$1$2
  implements Runnable
{
  ContactsHistoryMailListFragment$1$2(ContactsHistoryMailListFragment.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.val$isRunning)
    {
      ContactsHistoryMailListFragment.access$102(this.this$1.this$0, false);
      ContactsHistoryMailListFragment.access$200(this.this$1.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment.1.2
 * JD-Core Version:    0.7.0.1
 */