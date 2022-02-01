package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import moai.oss.KvHelper;

class QMReadEmlActivity$AttachListViewAdapter$16
  implements View.OnClickListener
{
  QMReadEmlActivity$AttachListViewAdapter$16(QMReadEmlActivity.AttachListViewAdapter paramAttachListViewAdapter) {}
  
  public void onClick(View paramView)
  {
    if (!QMReadEmlActivity.AttachListViewAdapter.access$5700(this.this$1)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      KvHelper.eventEmlClickAttachMoreBtn(new double[0]);
      QMReadEmlActivity.AttachListViewAdapter.access$5800(this.this$1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.AttachListViewAdapter.16
 * JD-Core Version:    0.7.0.1
 */