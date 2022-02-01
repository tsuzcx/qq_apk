package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeMobileContactsActivity$10
  implements View.OnClickListener
{
  ComposeMobileContactsActivity$10(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void onClick(View paramView)
  {
    if (ComposeMobileContactsActivity.access$1200(this.this$0)) {
      ComposeMobileContactsActivity.access$1500(this.this$0, false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.10
 * JD-Core Version:    0.7.0.1
 */