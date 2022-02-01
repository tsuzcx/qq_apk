package com.tencent.qqmail.note;

import com.tencent.qqmail.view.FolderLockDialog;

class ReadNoteActivity$1$1
  implements Runnable
{
  ReadNoteActivity$1$1(ReadNoteActivity.1 param1, int paramInt) {}
  
  public void run()
  {
    ReadNoteActivity.access$000(this.this$1.this$0).cancelDialog();
    ReadNoteActivity.access$000(this.this$1.this$0).dismissTips();
    if (this.val$fid == -4) {
      ReadNoteActivity.access$200(this.this$1.this$0, ReadNoteActivity.access$100(this.this$1.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.1.1
 * JD-Core Version:    0.7.0.1
 */