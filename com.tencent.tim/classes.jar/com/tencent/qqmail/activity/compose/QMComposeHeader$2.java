package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMComposeHeader$2
  implements View.OnClickListener
{
  QMComposeHeader$2(QMComposeHeader paramQMComposeHeader) {}
  
  public void onClick(View paramView)
  {
    this.this$0.showCCAndBcc();
    QMComposeHeader.access$100(this.this$0).getAddrsViewControl().requestInputAreaFocus();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeHeader.2
 * JD-Core Version:    0.7.0.1
 */