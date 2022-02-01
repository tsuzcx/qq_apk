package com.tencent.qqmail.qmui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMUIDialog$ConfirmMessageDialogBuilder$1
  implements View.OnClickListener
{
  QMUIDialog$ConfirmMessageDialogBuilder$1(QMUIDialog.ConfirmMessageDialogBuilder paramConfirmMessageDialogBuilder) {}
  
  public void onClick(View paramView)
  {
    QMUIDialog.ConfirmMessageDialogBuilder localConfirmMessageDialogBuilder = this.this$0;
    if (!QMUIDialog.ConfirmMessageDialogBuilder.access$000(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      localConfirmMessageDialogBuilder.setChecked(bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialog.ConfirmMessageDialogBuilder.1
 * JD-Core Version:    0.7.0.1
 */