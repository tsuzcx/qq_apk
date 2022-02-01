package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.popup.QMUIListPopup;

class ComposeNoteActivity$11
  implements View.OnClickListener
{
  ComposeNoteActivity$11(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void onClick(View paramView)
  {
    if (ComposeNoteActivity.access$1500(this.this$0) == null) {
      ComposeNoteActivity.access$1600(this.this$0);
    }
    if (ComposeNoteActivity.access$1500(this.this$0) != null) {
      ComposeNoteActivity.access$1500(this.this$0).show(ComposeNoteActivity.access$1400(this.this$0), paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.11
 * JD-Core Version:    0.7.0.1
 */