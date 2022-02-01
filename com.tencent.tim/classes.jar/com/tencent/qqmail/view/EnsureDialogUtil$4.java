package com.tencent.qqmail.view;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class EnsureDialogUtil$4
  implements QMUIDialogAction.ActionListener
{
  EnsureDialogUtil$4(EnsureDialogUtil.Callback paramCallback) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    this.val$callback.ensure(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.EnsureDialogUtil.4
 * JD-Core Version:    0.7.0.1
 */