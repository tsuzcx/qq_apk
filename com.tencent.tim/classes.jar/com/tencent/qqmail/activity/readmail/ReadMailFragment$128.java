package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

class ReadMailFragment$128
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$128(ReadMailFragment paramReadMailFragment, QMUIDialogAction.ActionListener paramActionListener) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    KvHelper.eventReadmailContinueMobileDownload(new double[0]);
    if (this.val$confirmListener != null) {
      this.val$confirmListener.onClick(paramQMUIDialog, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.128
 * JD-Core Version:    0.7.0.1
 */