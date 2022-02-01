package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeToolBar$3
  implements View.OnClickListener
{
  ComposeToolBar$3(ComposeToolBar paramComposeToolBar) {}
  
  public void onClick(View paramView)
  {
    if (ComposeToolBar.access$000(this.this$0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ComposeToolBar.access$500(this.this$0).isSelected()) {
        ComposeToolBar.access$600(this.this$0);
      } else {
        ComposeToolBar.access$700(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeToolBar.3
 * JD-Core Version:    0.7.0.1
 */