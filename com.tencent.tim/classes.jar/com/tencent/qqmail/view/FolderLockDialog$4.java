package com.tencent.qqmail.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import moai.core.watcher.Watchers;

class FolderLockDialog$4
  implements DialogInterface.OnDismissListener
{
  FolderLockDialog$4(FolderLockDialog paramFolderLockDialog, int paramInt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Watchers.bind(FolderLockDialog.access$200(this.this$0), false);
    FolderLockDialog.access$200(this.this$0).onDismiss(this.val$unlockAccountId, FolderLockDialog.access$300(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FolderLockDialog.4
 * JD-Core Version:    0.7.0.1
 */