package com.tencent.qqmail.utilities.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class QMProgressTips$2
  implements DialogInterface.OnDismissListener
{
  QMProgressTips$2(QMProgressTips paramQMProgressTips) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QMProgressTips.access$000(this.this$0) != null) {
      QMProgressTips.access$000(this.this$0).onHide(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMProgressTips.2
 * JD-Core Version:    0.7.0.1
 */