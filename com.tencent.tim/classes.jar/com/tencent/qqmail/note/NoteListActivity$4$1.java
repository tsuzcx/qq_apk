package com.tencent.qqmail.note;

import com.tencent.qqmail.view.FolderLockDialog;

class NoteListActivity$4$1
  implements Runnable
{
  NoteListActivity$4$1(NoteListActivity.4 param4, int paramInt) {}
  
  public void run()
  {
    if (NoteListActivity.access$200(this.this$1.this$0) != null)
    {
      NoteListActivity.access$200(this.this$1.this$0).cancelDialog();
      NoteListActivity.access$200(this.this$1.this$0).dismissTips();
    }
    if (this.val$fid == -4)
    {
      this.this$1.this$0.refreshData();
      this.this$1.this$0.render();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteListActivity.4.1
 * JD-Core Version:    0.7.0.1
 */