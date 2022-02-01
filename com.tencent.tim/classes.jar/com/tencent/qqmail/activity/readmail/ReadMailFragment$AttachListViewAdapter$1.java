package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.view.DownloadThumbProgressBar;

class ReadMailFragment$AttachListViewAdapter$1
  implements QMUIDialogAction.ActionListener
{
  ReadMailFragment$AttachListViewAdapter$1(ReadMailFragment.AttachListViewAdapter paramAttachListViewAdapter, DownloadThumbProgressBar paramDownloadThumbProgressBar, Attach paramAttach, String paramString) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.val$downloadProgressBar.start();
    ReadMailFragment.access$20400(this.this$1.this$0, this.val$attach, this.val$saveAsPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.AttachListViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */