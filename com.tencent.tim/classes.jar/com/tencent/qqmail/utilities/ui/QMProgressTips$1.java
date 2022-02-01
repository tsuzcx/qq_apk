package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.qmui.dialog.QMUITipDialog;

class QMProgressTips$1
  implements View.OnClickListener
{
  QMProgressTips$1(QMProgressTips paramQMProgressTips) {}
  
  public void onClick(View paramView)
  {
    if (QMProgressTips.access$000(this.this$0) != null) {
      QMProgressTips.access$000(this.this$0).onCancel(null);
    }
    QMProgressTips.access$100(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMProgressTips.1
 * JD-Core Version:    0.7.0.1
 */