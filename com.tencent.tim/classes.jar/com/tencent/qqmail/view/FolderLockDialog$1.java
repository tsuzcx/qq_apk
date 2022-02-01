package com.tencent.qqmail.view;

import android.widget.EditText;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialogAction.ActionListener;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.dialog.PasswordDialogBuilder;
import moai.core.watcher.Watchers;

class FolderLockDialog$1
  implements QMUIDialogAction.ActionListener
{
  FolderLockDialog$1(FolderLockDialog paramFolderLockDialog, String paramString, int paramInt) {}
  
  public void onClick(QMUIDialog paramQMUIDialog, int paramInt)
  {
    if (!QMNetworkUtils.isNetworkConnected(FolderLockDialog.access$000(this.this$0)))
    {
      Threads.runOnMainThread(new FolderLockDialog.1.1(this));
      return;
    }
    Threads.runOnMainThread(new FolderLockDialog.1.2(this));
    this.this$0.hideDialog();
    Watchers.bind(FolderLockDialog.access$200(this.this$0), true);
    QMMailManager.sharedInstance().unlockFolder(this.val$unlockAccountId, FolderLockDialog.access$300(this.this$0), FolderLockDialog.access$100(this.this$0).getEditText().getText().toString());
    this.this$0.loadingTips();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FolderLockDialog.1
 * JD-Core Version:    0.7.0.1
 */