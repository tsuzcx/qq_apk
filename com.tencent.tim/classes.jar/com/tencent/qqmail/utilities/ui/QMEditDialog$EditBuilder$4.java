package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMEditDialog$EditBuilder$4
  implements View.OnClickListener
{
  QMEditDialog$EditBuilder$4(QMEditDialog.EditBuilder paramEditBuilder) {}
  
  public void onClick(View paramView)
  {
    QMEditDialog.EditBuilder.access$300(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMEditDialog.EditBuilder.4
 * JD-Core Version:    0.7.0.1
 */