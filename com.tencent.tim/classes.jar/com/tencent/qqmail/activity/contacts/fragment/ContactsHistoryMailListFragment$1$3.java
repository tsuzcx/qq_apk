package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.model.contact.cursor.ContactHistoryMailCursor;
import com.tencent.qqmail.utilities.log.QMLog;

class ContactsHistoryMailListFragment$1$3
  implements Runnable
{
  ContactsHistoryMailListFragment$1$3(ContactsHistoryMailListFragment.1 param1) {}
  
  public void run()
  {
    QMLog.log(4, ContactsHistoryMailListFragment.access$000(), " onComple tereset!!!");
    ContactsHistoryMailListFragment.access$102(this.this$1.this$0, true);
    ContactsHistoryMailListFragment.access$200(this.this$1.this$0).setError(false);
    ContactsHistoryMailListFragment.access$200(this.this$1.this$0).setMoreLoading(false);
    ContactsHistoryMailListFragment.access$200(this.this$1.this$0).updateRemote(true);
    ContactsHistoryMailListFragment.access$200(this.this$1.this$0).notifyDataSetChanged();
    if ((ContactsHistoryMailListFragment.access$600(this.this$1.this$0) == null) || ((!ContactsHistoryMailListFragment.access$600(this.this$1.this$0).canLoadMore()) && (ContactsHistoryMailListFragment.access$600(this.this$1.this$0).getCount() == 0)))
    {
      ContactsHistoryMailListFragment.access$700(this.this$1.this$0);
      return;
    }
    ContactsHistoryMailListFragment.access$300(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment.1.3
 * JD-Core Version:    0.7.0.1
 */