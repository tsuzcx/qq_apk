package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMComposeFooter$1
  implements View.OnClickListener
{
  QMComposeFooter$1(QMComposeFooter paramQMComposeFooter) {}
  
  public void onClick(View paramView)
  {
    if (QMComposeFooter.access$000(this.this$0) != null) {
      QMComposeFooter.access$000(this.this$0).onAddAttaches(this.this$0, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMComposeFooter.1
 * JD-Core Version:    0.7.0.1
 */