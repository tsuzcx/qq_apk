package com.tencent.qqmail.view;

import android.content.Context;
import android.widget.TextView;
import com.tencent.qqmail.view.dialog.PasswordDialogBuilder;

class FolderLockDialog$1$2
  implements Runnable
{
  FolderLockDialog$1$2(FolderLockDialog.1 param1) {}
  
  public void run()
  {
    TextView localTextView = FolderLockDialog.access$100(this.this$1.this$0).getTitleView();
    if (localTextView != null) {
      localTextView.setText(FolderLockDialog.access$000(this.this$1.this$0).getString(2131693948) + this.this$1.val$unlockAccountName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FolderLockDialog.1.2
 * JD-Core Version:    0.7.0.1
 */