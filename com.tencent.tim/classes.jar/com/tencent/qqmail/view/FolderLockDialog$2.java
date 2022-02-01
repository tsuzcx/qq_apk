package com.tencent.qqmail.view;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;

class FolderLockDialog$2
  implements QMUIDialogAction.ActionListener
{
  FolderLockDialog$2(FolderLockDialog paramFolderLockDialog, int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    FolderLockDialog.access$200(this.this$0).onCancel(this.val$unlockAccountId, FolderLockDialog.access$300(this.this$0));
    FolderLockDialog.access$400(this.this$0).cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FolderLockDialog.2
 * JD-Core Version:    0.7.0.1
 */