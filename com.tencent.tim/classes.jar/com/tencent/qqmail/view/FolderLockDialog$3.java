package com.tencent.qqmail.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import moai.core.watcher.Watchers;

class FolderLockDialog$3
  implements DialogInterface.OnCancelListener
{
  FolderLockDialog$3(FolderLockDialog paramFolderLockDialog) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    Watchers.bind(FolderLockDialog.access$200(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FolderLockDialog.3
 * JD-Core Version:    0.7.0.1
 */