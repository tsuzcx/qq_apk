package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class ComposeMailActivity$108
  implements View.OnClickListener
{
  ComposeMailActivity$108(ComposeMailActivity paramComposeMailActivity) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Compose_Photo");
    paramView.setEnabled(false);
    ComposeMailActivity.access$13000(this.this$0);
    paramView.postDelayed(new ComposeMailActivity.108.1(this, paramView), 1000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.108
 * JD-Core Version:    0.7.0.1
 */