package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.protocol.DataCollector;

class QMReadMailView$5
  implements View.OnClickListener
{
  QMReadMailView$5(QMReadMailView paramQMReadMailView) {}
  
  public void onClick(View paramView)
  {
    DataCollector.logEvent("Event_Local_File_Tap_Bubble");
    QMReadMailView.access$300(this.this$0).getBottomBarButton(QMReadMailView.VIEW_ITEM.EDIT.ordinal()).performClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailView.5
 * JD-Core Version:    0.7.0.1
 */