package com.tencent.qqmail.qmui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMUIDialog$AutoResizeDialogBuilder$1
  implements View.OnClickListener
{
  QMUIDialog$AutoResizeDialogBuilder$1(QMUIDialog.AutoResizeDialogBuilder paramAutoResizeDialogBuilder) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialog.AutoResizeDialogBuilder.1
 * JD-Core Version:    0.7.0.1
 */