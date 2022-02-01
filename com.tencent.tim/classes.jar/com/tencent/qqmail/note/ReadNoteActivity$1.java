package com.tencent.qqmail.note;

import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;

class ReadNoteActivity$1
  implements QMUnlockFolderPwdWatcher
{
  ReadNoteActivity$1(ReadNoteActivity paramReadNoteActivity) {}
  
  public void onCancel(int paramInt1, int paramInt2) {}
  
  public void onDismiss(int paramInt1, int paramInt2) {}
  
  public void onError(int paramInt1, int paramInt2)
  {
    ReadNoteActivity.access$400(this.this$0, new ReadNoteActivity.1.2(this));
  }
  
  public void onSuccess(int paramInt1, int paramInt2)
  {
    ReadNoteActivity.access$300(this.this$0, new ReadNoteActivity.1.1(this, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.1
 * JD-Core Version:    0.7.0.1
 */