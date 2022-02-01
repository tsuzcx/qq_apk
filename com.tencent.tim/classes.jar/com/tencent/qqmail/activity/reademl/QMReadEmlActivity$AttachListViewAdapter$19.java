package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.utilities.log.QMLog;

class QMReadEmlActivity$AttachListViewAdapter$19
  implements View.OnClickListener
{
  QMReadEmlActivity$AttachListViewAdapter$19(QMReadEmlActivity.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public void onClick(View paramView)
  {
    QMLog.log(4, "QMReadEmlActivity", "click attach at pos :" + paramView.getTag());
    this.this$1.startAttachmentActivityByPos(((Integer)paramView.getTag()).intValue(), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.AttachListViewAdapter.19
 * JD-Core Version:    0.7.0.1
 */