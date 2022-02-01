package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class ComposeNoteActivity$1
  implements QMUnlockFolderPwdWatcher
{
  ComposeNoteActivity$1(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void onCancel(int paramInt1, int paramInt2)
  {
    this.this$0.unLockCancelFinish();
  }
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    ComposeNoteActivity.access$300(this.this$0, new ComposeNoteActivity.1.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    ComposeNoteActivity.access$200(this.this$0, new ComposeNoteActivity.1.1(this, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.1
 * JD-Core Version:    0.7.0.1
 */