package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadMailFragment$AttachListViewAdapter$9
  implements View.OnClickListener
{
  ReadMailFragment$AttachListViewAdapter$9(ReadMailFragment.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public void onClick(View paramView)
  {
    if (!ReadMailFragment.AttachListViewAdapter.access$21200(this.this$1)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      ReadMailFragment.access$21300(this.this$1.this$0, i, paramView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.AttachListViewAdapter.9
 * JD-Core Version:    0.7.0.1
 */