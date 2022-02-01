package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMComposeHeader$4
  implements View.OnClickListener
{
  QMComposeHeader$4(QMComposeHeader paramQMComposeHeader) {}
  
  public void onClick(View paramView)
  {
    QMComposeHeader.access$000(this.this$0).handleSenderButton(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeHeader.4
 * JD-Core Version:    0.7.0.1
 */