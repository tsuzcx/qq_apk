package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMReadMailView$11
  implements View.OnClickListener
{
  QMReadMailView$11(QMReadMailView paramQMReadMailView) {}
  
  public void onClick(View paramView)
  {
    QMReadMailView.access$300(this.this$0).getBottomBarButton(QMReadMailView.VIEW_ITEM.MORE.ordinal()).performClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailView.11
 * JD-Core Version:    0.7.0.1
 */