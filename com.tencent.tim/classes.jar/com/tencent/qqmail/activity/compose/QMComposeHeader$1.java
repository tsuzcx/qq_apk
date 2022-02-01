package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMComposeHeader$1
  implements View.OnClickListener
{
  QMComposeHeader$1(QMComposeHeader paramQMComposeHeader) {}
  
  public void onClick(View paramView)
  {
    if (QMComposeHeader.access$000(this.this$0) != null) {
      QMComposeHeader.access$000(this.this$0).OnClickReceiverTextView();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeHeader.1
 * JD-Core Version:    0.7.0.1
 */