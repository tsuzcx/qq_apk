package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeGroupAddrView$1
  implements View.OnClickListener
{
  ComposeGroupAddrView$1(ComposeGroupAddrView paramComposeGroupAddrView) {}
  
  public void onClick(View paramView)
  {
    ComposeGroupAddrView.access$000(this.this$0).clickedAddGroupContactButton(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeGroupAddrView.1
 * JD-Core Version:    0.7.0.1
 */