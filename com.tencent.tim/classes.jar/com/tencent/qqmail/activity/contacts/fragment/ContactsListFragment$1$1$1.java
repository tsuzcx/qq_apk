package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.activity.contacts.view.ContactUIHelper;
import com.tencent.qqmail.model.mail.callback.QMRefreshCallback;

class ContactsListFragment$1$1$1
  extends QMRefreshCallback
{
  ContactsListFragment$1$1$1(ContactsListFragment.1.1 param1) {}
  
  public void onBeforeRefresh()
  {
    ContactUIHelper.storePostion(ContactsListFragment.access$200(this.this$2.this$1.this$0), ContactsListFragment.access$300(this.this$2.this$1.this$0), ContactsListFragment.access$400(this.this$2.this$1.this$0));
  }
  
  public void onRefreshComplete()
  {
    this.this$2.this$1.this$0.render(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.1.1.1
 * JD-Core Version:    0.7.0.1
 */