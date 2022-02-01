package com.tencent.qqmail.movemail;

import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class ManageFolderActivity$11
  implements QMUIDialogAction.ActionListener
{
  ManageFolderActivity$11(ManageFolderActivity paramManageFolderActivity, Runnable paramRunnable) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    this.val$confirm.run();
    paramQMUIDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.11
 * JD-Core Version:    0.7.0.1
 */