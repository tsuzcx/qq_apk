package com.tencent.qqmail.activity.contacts.fragment;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.view.MailListItemView;

class ContactsHistoryMailListFragment$5
  implements View.OnClickListener
{
  ContactsHistoryMailListFragment$5(ContactsHistoryMailListFragment paramContactsHistoryMailListFragment) {}
  
  public void onClick(View paramView)
  {
    if (ContactsHistoryMailListFragment.access$1500(this.this$0) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      int i = ContactsHistoryMailListFragment.access$1500(this.this$0).getFirstVisiblePosition();
      int j = MailListItemView.VIEW_HEIGHT;
      float f = ContactsHistoryMailListFragment.access$1500(this.this$0).getHeight() * 1.5F;
      int k = Math.round(f / MailListItemView.VIEW_HEIGHT);
      if (i * j > f) {
        ContactsHistoryMailListFragment.access$1500(this.this$0).setSelectionFromTop(k, 0);
      }
      ContactsHistoryMailListFragment.access$1500(this.this$0).smoothScrollToPosition(0);
    }
    for (;;)
    {
      ContactsHistoryMailListFragment.access$1500(this.this$0).smoothScrollToPosition(0);
      break;
      ContactsHistoryMailListFragment.access$1500(this.this$0).setSelectionFromTop(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsHistoryMailListFragment.5
 * JD-Core Version:    0.7.0.1
 */