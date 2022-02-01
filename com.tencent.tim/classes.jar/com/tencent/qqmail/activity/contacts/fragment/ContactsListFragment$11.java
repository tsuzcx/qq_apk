package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.activity.contacts.view.ContactUIHelper;

class ContactsListFragment$11
  implements View.OnClickListener
{
  ContactsListFragment$11(ContactsListFragment paramContactsListFragment) {}
  
  public void onClick(View paramView)
  {
    ListView localListView = null;
    if (ContactsListFragment.access$400(this.this$0).getVisibility() == 0)
    {
      localListView = ContactsListFragment.access$400(this.this$0);
      if (localListView != null) {
        break label59;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ContactsListFragment.access$2500(this.this$0).getVisibility() != 0) {
        break;
      }
      localListView = ContactsListFragment.access$2500(this.this$0);
      break;
      label59:
      ContactUIHelper.smoothScrollToTop(localListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.11
 * JD-Core Version:    0.7.0.1
 */