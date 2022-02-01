package com.tencent.qqmail.ftn.util;

import android.view.View.OnClickListener;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

final class FtnDialogUtils$1
  implements QMUIDialogAction.ActionListener
{
  FtnDialogUtils$1(View.OnClickListener paramOnClickListener, QMUIDialogAction paramQMUIDialogAction) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.val$dialogItemClickListener.onClick(this.val$cancelAction.getButton());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.util.FtnDialogUtils.1
 * JD-Core Version:    0.7.0.1
 */