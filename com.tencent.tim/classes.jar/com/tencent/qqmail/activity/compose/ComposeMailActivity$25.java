package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeMailActivity$25
  implements View.OnClickListener
{
  ComposeMailActivity$25(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(View paramView)
  {
    ComposeMailActivity.access$3000(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.25
 * JD-Core Version:    0.7.0.1
 */