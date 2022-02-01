package com.tencent.qqmail.movemail;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;

class ManageFolderActivity$7$2
  implements QMUIDialogAction.ActionListener
{
  ManageFolderActivity$7$2(ManageFolderActivity.7 param7) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    paramQMUIDialog.dismiss();
    if (!ManageFolderActivity.access$200(this.this$1.this$0)) {
      return;
    }
    Threads.runInBackground(new ManageFolderActivity.7.2.1(this));
    ManageFolderActivity.access$000(this.this$1.this$0).setCallback(new ManageFolderActivity.7.2.2(this));
    ManageFolderActivity.access$000(this.this$1.this$0).showLoading("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.7.2
 * JD-Core Version:    0.7.0.1
 */