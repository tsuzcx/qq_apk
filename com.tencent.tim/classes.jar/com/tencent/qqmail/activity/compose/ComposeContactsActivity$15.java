package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeContactsActivity$15
  implements View.OnClickListener
{
  ComposeContactsActivity$15(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.launchContactsGroupSelect();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.15
 * JD-Core Version:    0.7.0.1
 */