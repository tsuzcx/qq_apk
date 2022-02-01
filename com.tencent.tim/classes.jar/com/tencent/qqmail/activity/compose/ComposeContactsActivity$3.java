package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeContactsActivity$3
  implements View.OnClickListener
{
  ComposeContactsActivity$3(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onClick(View paramView)
  {
    ComposeContactsActivity.access$002(this.this$0, false);
    ComposeContactsActivity.access$102(this.this$0, false);
    ComposeContactsActivity.access$600(this.this$0, new ComposeContactsActivity.3.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.3
 * JD-Core Version:    0.7.0.1
 */