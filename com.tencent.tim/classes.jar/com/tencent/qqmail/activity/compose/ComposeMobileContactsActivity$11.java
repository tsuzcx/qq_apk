package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeMobileContactsActivity$11
  implements View.OnClickListener
{
  ComposeMobileContactsActivity$11(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void onClick(View paramView)
  {
    if (!ComposeMobileContactsActivity.access$1200(this.this$0)) {
      ComposeMobileContactsActivity.access$1500(this.this$0, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.11
 * JD-Core Version:    0.7.0.1
 */