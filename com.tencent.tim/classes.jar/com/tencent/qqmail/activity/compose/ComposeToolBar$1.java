package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeToolBar$1
  implements View.OnClickListener
{
  ComposeToolBar$1(ComposeToolBar paramComposeToolBar) {}
  
  public void onClick(View paramView)
  {
    if ((!ComposeToolBar.access$000(this.this$0)) && (ComposeToolBar.access$100(this.this$0) != null)) {
      ComposeToolBar.access$100(this.this$0).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeToolBar.1
 * JD-Core Version:    0.7.0.1
 */