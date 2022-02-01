package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.view.FolderLockDialog;

class ComposeNoteActivity$1$1
  implements Runnable
{
  ComposeNoteActivity$1$1(ComposeNoteActivity.1 param1, int paramInt) {}
  
  public void run()
  {
    if (ComposeNoteActivity.access$000(this.this$1.this$0) != null)
    {
      ComposeNoteActivity.access$000(this.this$1.this$0).cancelDialog();
      ComposeNoteActivity.access$000(this.this$1.this$0).dismissTips();
    }
    if (this.val$fid == -4) {
      ComposeNoteActivity.access$100(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.1.1
 * JD-Core Version:    0.7.0.1
 */