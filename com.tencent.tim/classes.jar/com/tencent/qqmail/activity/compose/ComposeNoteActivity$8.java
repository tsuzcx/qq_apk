package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeNoteActivity$8
  implements View.OnClickListener
{
  ComposeNoteActivity$8(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void onClick(View paramView)
  {
    ComposeNoteActivity.access$800(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.8
 * JD-Core Version:    0.7.0.1
 */