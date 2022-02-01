package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import moai.oss.KvHelper;

class ReadMailFragment$129
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$129(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    KvHelper.eventReadmailCancelMobileDownload(new double[0]);
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.129
 * JD-Core Version:    0.7.0.1
 */