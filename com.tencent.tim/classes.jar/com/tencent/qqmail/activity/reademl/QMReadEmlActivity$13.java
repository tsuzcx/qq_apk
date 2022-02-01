package com.tencent.qqmail.activity.reademl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMReadEmlActivity$13
  implements View.OnClickListener
{
  QMReadEmlActivity$13(QMReadEmlActivity paramQMReadEmlActivity) {}
  
  public void onClick(View paramView)
  {
    QMReadEmlActivity.access$3800(this.this$0);
    QMReadEmlActivity.access$3900(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.13
 * JD-Core Version:    0.7.0.1
 */