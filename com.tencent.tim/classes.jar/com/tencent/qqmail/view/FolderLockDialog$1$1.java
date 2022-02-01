package com.tencent.qqmail.view;

import android.widget.TextView;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.view.dialog.PasswordDialogBuilder;

class FolderLockDialog$1$1
  implements Runnable
{
  FolderLockDialog$1$1(FolderLockDialog.1 param1) {}
  
  public void run()
  {
    TextView localTextView = FolderLockDialog.access$100(this.this$1.this$0).getTitleView();
    if (localTextView != null) {
      localTextView.setText(QMApplicationContext.sharedInstance().getString(2131696288));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.FolderLockDialog.1.1
 * JD-Core Version:    0.7.0.1
 */