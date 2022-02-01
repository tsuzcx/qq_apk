package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class ReadMailFragment$AttachListViewAdapter$12
  implements View.OnClickListener
{
  ReadMailFragment$AttachListViewAdapter$12(ReadMailFragment.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public void onClick(View paramView)
  {
    if (!ReadMailFragment.AttachListViewAdapter.access$21200(this.this$1)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QMLog.log(4, "ReadMailFragment", "click attach at pos :" + paramView.getTag());
      DataCollector.logEvent("Event_Click_Attach");
      this.this$1.startAttachmentActivityByPos(((Integer)paramView.getTag()).intValue(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.AttachListViewAdapter.12
 * JD-Core Version:    0.7.0.1
 */