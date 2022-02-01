package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMToggleView$1
  implements View.OnClickListener
{
  QMToggleView$1(QMToggleView paramQMToggleView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.hide();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMToggleView.1
 * JD-Core Version:    0.7.0.1
 */