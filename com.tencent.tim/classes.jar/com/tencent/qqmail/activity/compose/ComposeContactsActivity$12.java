package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeContactsActivity$12
  implements View.OnClickListener
{
  ComposeContactsActivity$12(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onClick(View paramView)
  {
    if (ComposeContactsActivity.access$1500(this.this$0)) {
      ComposeContactsActivity.access$1800(this.this$0, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.12
 * JD-Core Version:    0.7.0.1
 */