package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeNoteActivity$5
  implements View.OnClickListener
{
  ComposeNoteActivity$5(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void onClick(View paramView)
  {
    paramView.setEnabled(false);
    ComposeNoteActivity.access$600(this.this$0);
    paramView.postDelayed(new ComposeNoteActivity.5.1(this, paramView), 1000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.5
 * JD-Core Version:    0.7.0.1
 */