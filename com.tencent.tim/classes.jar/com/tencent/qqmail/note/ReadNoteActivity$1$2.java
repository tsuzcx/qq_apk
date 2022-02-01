package com.tencent.qqmail.note;

import com.tencent.qqmail.view.FolderLockDialog;

class ReadNoteActivity$1$2
  implements Runnable
{
  ReadNoteActivity$1$2(ReadNoteActivity.1 param1) {}
  
  public void run()
  {
    ReadNoteActivity.access$000(this.this$1.this$0).cancelDialog();
    ReadNoteActivity.access$000(this.this$1.this$0).dismissTips();
    ReadNoteActivity.access$000(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.ReadNoteActivity.1.2
 * JD-Core Version:    0.7.0.1
 */