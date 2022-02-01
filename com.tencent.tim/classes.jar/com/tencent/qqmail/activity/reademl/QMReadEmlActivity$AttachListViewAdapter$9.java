package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class QMReadEmlActivity$AttachListViewAdapter$9
  implements QMUIDialogAction.ActionListener
{
  QMReadEmlActivity$AttachListViewAdapter$9(QMReadEmlActivity.AttachListViewAdapter paramAttachListViewAdapter, QMUIDialogAction.ActionListener paramActionListener) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (this.val$confirmListener != null) {
      this.val$confirmListener.onClick(paramQMUIDialog, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.AttachListViewAdapter.9
 * JD-Core Version:    0.7.0.1
 */