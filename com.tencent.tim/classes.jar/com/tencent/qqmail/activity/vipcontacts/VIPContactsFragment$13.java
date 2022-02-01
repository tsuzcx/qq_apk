package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VIPContactsFragment$13
  implements View.OnClickListener
{
  VIPContactsFragment$13(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onClick(View paramView)
  {
    if (!VIPContactsFragment.access$2100(this.this$0)) {
      VIPContactsFragment.access$2400(this.this$0, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.13
 * JD-Core Version:    0.7.0.1
 */