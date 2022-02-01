package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VIPContactsFragment$3
  implements View.OnClickListener
{
  VIPContactsFragment$3(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onClick(View paramView)
  {
    VIPContactsFragment.access$002(this.this$0, false);
    VIPContactsFragment.access$102(this.this$0, false);
    VIPContactsFragment.access$600(this.this$0, new VIPContactsFragment.3.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.3
 * JD-Core Version:    0.7.0.1
 */