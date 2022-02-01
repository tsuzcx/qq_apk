package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.utilities.log.QMLog;

class ContactsHistoryMailListFragment$1$1
  implements Runnable
{
  ContactsHistoryMailListFragment$1$1(ContactsHistoryMailListFragment.1 param1, boolean paramBoolean, long[] paramArrayOfLong) {}
  
  public void run()
  {
    QMLog.log(4, ContactsHistoryMailListFragment.access$000(), " onSuccess isRunning:" + this.val$isRunning);
    if (this.val$mailId.length > 0)
    {
      ContactsHistoryMailListFragment.access$102(this.this$1.this$0, this.val$isRunning);
      ContactsHistoryMailListFragment.access$200(this.this$1.this$0).setMoreLoading(this.val$isRunning);
      ContactsHistoryMailListFragment.access$200(this.this$1.this$0).setError(false);
      ContactsHistoryMailListFragment.access$200(this.this$1.this$0).updateRemote(false);
      ContactsHistoryMailListFragment.access$200(this.this$1.this$0).notifyDataSetChanged();
    }
    ContactsHistoryMailListFragment.access$300(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment.1.1
 * JD-Core Version:    0.7.0.1
 */