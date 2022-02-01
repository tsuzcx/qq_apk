package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.model.qmdomain.MailBigAttach;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.view.DownloadThumbProgressBar;

class ReadMailFragment$AttachListViewAdapter$7
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$AttachListViewAdapter$7(ReadMailFragment.AttachListViewAdapter paramAttachListViewAdapter, DownloadThumbProgressBar paramDownloadThumbProgressBar, MailBigAttach paramMailBigAttach, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.val$downloadProgressBar.start();
    ReadMailFragment.access$20900(this.this$1.this$0, this.val$bigAttach, this.val$saveAsPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.AttachListViewAdapter.7
 * JD-Core Version:    0.7.0.1
 */