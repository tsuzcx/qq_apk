package com.tencent.qqmail.note;

import com.tencent.qqmail.view.FolderLockDialog;

class NoteListActivity$4$2
  implements Runnable
{
  NoteListActivity$4$2(NoteListActivity.4 param4) {}
  
  public void run()
  {
    NoteListActivity.access$200(this.this$1.this$0).cancelDialog();
    NoteListActivity.access$200(this.this$1.this$0).dismissTips();
    NoteListActivity.access$200(this.this$1.this$0).errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.4.2
 * JD-Core Version:    0.7.0.1
 */