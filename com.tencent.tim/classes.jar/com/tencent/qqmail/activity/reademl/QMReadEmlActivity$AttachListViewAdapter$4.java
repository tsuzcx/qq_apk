package com.tencent.qqmail.activity.reademl;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.view.DownloadThumbProgressBar;

class QMReadEmlActivity$AttachListViewAdapter$4
  implements QMUIDialogAction.ActionListener
{
  QMReadEmlActivity$AttachListViewAdapter$4(QMReadEmlActivity.AttachListViewAdapter paramAttachListViewAdapter, DownloadThumbProgressBar paramDownloadThumbProgressBar, MailBigAttach paramMailBigAttach, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.val$downloadProgressBar.start();
    QMReadEmlActivity.access$4800(this.this$1.this$0, this.val$bigAttach, this.val$saveAsPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.reademl.QMReadEmlActivity.AttachListViewAdapter.4
 * JD-Core Version:    0.7.0.1
 */