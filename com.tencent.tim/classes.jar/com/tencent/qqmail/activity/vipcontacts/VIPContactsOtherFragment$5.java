package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VIPContactsOtherFragment$5
  implements View.OnClickListener
{
  VIPContactsOtherFragment$5(VIPContactsOtherFragment paramVIPContactsOtherFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.popBackStack();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsOtherFragment.5
 * JD-Core Version:    0.7.0.1
 */