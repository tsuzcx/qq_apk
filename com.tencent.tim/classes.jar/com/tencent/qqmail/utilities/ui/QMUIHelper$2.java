package com.tencent.qqmail.utilities.ui;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class QMUIHelper$2
  implements QMUIDialogAction.ActionListener
{
  QMUIHelper$2(Runnable paramRunnable) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (this.val$done != null) {
      this.val$done.run();
    }
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMUIHelper.2
 * JD-Core Version:    0.7.0.1
 */