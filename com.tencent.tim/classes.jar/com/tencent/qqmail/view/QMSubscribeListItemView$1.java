package com.tencent.qqmail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMSubscribeListItemView$1
  implements View.OnClickListener
{
  QMSubscribeListItemView$1(QMSubscribeListItemView paramQMSubscribeListItemView) {}
  
  public void onClick(View paramView)
  {
    if (QMSubscribeListItemView.access$000(this.this$0) != null) {
      QMSubscribeListItemView.access$000(this.this$0).onClick(this.this$0.getTag(), this.this$0.indexOfChild(paramView) - 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMSubscribeListItemView.1
 * JD-Core Version:    0.7.0.1
 */