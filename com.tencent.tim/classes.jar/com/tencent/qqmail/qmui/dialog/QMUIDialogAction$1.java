package com.tencent.qqmail.qmui.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QMUIDialogAction$1
  implements View.OnClickListener
{
  QMUIDialogAction$1(QMUIDialogAction paramQMUIDialogAction, QMUIDialog paramQMUIDialog, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (QMUIDialogAction.access$000(this.this$0).isEnabled()) {
      QMUIDialogAction.access$100(this.this$0).onClick(this.val$dialog, this.val$index);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmui.dialog.QMUIDialogAction.1
 * JD-Core Version:    0.7.0.1
 */