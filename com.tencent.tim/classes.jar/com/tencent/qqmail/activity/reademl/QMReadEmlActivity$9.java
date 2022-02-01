package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMReadEmlActivity$9
  implements View.OnClickListener
{
  QMReadEmlActivity$9(QMReadEmlActivity paramQMReadEmlActivity) {}
  
  public void onClick(View paramView)
  {
    QMReadEmlActivity.access$2900(this.this$0, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.9
 * JD-Core Version:    0.7.0.1
 */