package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeAddrView$2
  implements View.OnClickListener
{
  ComposeAddrView$2(ComposeAddrView paramComposeAddrView) {}
  
  public void onClick(View paramView)
  {
    if (!ComposeAddrView.access$100(this.this$0)) {
      if (!ComposeAddrView.access$200(this.this$0).isDropDownShowing())
      {
        ComposeAddrView.access$200(this.this$0).requestInputAreaFocus();
        ComposeAddrView.access$200(this.this$0).showDropDown();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ComposeAddrView.access$000(this.this$0) != null) {
        ComposeAddrView.access$000(this.this$0).clickedAddGroupContactButton(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeAddrView.2
 * JD-Core Version:    0.7.0.1
 */