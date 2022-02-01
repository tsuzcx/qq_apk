package com.tencent.qqmail.activity.contacts.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class ContactsMergeFragment$1
  implements View.OnClickListener
{
  ContactsMergeFragment$1(ContactsMergeFragment paramContactsMergeFragment) {}
  
  public void onClick(View paramView)
  {
    ContactsMergeFragment.access$200(this.this$0);
    paramView.setEnabled(false);
    ContactsMergeFragment.access$300(this.this$0, new ContactsMergeFragment.1.1(this), 1000L);
    DataCollector.logEvent("Event_Merge_Contact_Click");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsMergeFragment.1
 * JD-Core Version:    0.7.0.1
 */