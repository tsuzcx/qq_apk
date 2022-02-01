package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeMobileContactsActivity$5
  implements View.OnClickListener
{
  ComposeMobileContactsActivity$5(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.5
 * JD-Core Version:    0.7.0.1
 */