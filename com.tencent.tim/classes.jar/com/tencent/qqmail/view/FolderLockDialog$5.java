package com.tencent.qqmail.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.view.dialog.PasswordDialogBuilder;
import moai.core.watcher.Watchers;

class FolderLockDialog$5
  implements View.OnKeyListener
{
  FolderLockDialog$5(FolderLockDialog paramFolderLockDialog, int paramInt) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && (paramKeyEvent.getAction() == 0))
    {
      Watchers.bind(FolderLockDialog.access$200(this.this$0), true);
      QMMailManager.sharedInstance().unlockFolder(this.val$unlockAccountId, FolderLockDialog.access$300(this.this$0), FolderLockDialog.access$100(this.this$0).getEditText().getText().toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FolderLockDialog.5
 * JD-Core Version:    0.7.0.1
 */