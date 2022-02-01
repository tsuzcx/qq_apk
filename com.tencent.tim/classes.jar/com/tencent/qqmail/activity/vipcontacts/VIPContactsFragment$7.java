package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VIPContactsFragment$7
  implements View.OnClickListener
{
  VIPContactsFragment$7(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onClick(View paramView)
  {
    if (VIPContactsFragment.access$700(this.this$0) == 0) {
      VIPContactsAdapter.clearSelectContacts();
    }
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.7
 * JD-Core Version:    0.7.0.1
 */