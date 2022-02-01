package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComposeAddrView$1
  implements View.OnClickListener
{
  ComposeAddrView$1(ComposeAddrView paramComposeAddrView) {}
  
  public void onClick(View paramView)
  {
    paramView.setEnabled(false);
    if (ComposeAddrView.access$000(this.this$0) != null)
    {
      if (ComposeAddrView.access$100(this.this$0)) {
        break label66;
      }
      ComposeAddrView.access$000(this.this$0).clickAddContactButton(this.this$0);
    }
    for (;;)
    {
      paramView.postDelayed(new ComposeAddrView.1.1(this, paramView), 1000L);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label66:
      ComposeAddrView.access$000(this.this$0).clickedAddGroupContactButton(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeAddrView.1
 * JD-Core Version:    0.7.0.1
 */