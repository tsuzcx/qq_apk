package com.tencent.qqmail.activity.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMGroupChoserActivity$7
  implements View.OnClickListener
{
  QMGroupChoserActivity$7(QMGroupChoserActivity paramQMGroupChoserActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.showAccountChooseDialog();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMGroupChoserActivity.7
 * JD-Core Version:    0.7.0.1
 */