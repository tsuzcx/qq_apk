package com.tencent.qqmail.view;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class EnsureDialogUtil$3
  implements QMUIDialogAction.ActionListener
{
  EnsureDialogUtil$3(EnsureDialogUtil.Callback paramCallback) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.val$callback != null) {
      this.val$callback.ensure(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.EnsureDialogUtil.3
 * JD-Core Version:    0.7.0.1
 */