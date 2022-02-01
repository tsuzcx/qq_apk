package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeFeedbackActivity$9$1
  implements View.OnClickListener
{
  ComposeFeedbackActivity$9$1(ComposeFeedbackActivity.9 param9) {}
  
  public void onClick(View paramView)
  {
    ComposeFeedbackActivity.access$000(this.this$1.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.9.1
 * JD-Core Version:    0.7.0.1
 */