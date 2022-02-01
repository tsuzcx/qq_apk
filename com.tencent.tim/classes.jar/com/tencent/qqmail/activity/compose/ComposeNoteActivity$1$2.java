package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.view.FolderLockDialog;

class ComposeNoteActivity$1$2
  implements Runnable
{
  ComposeNoteActivity$1$2(ComposeNoteActivity.1 param1) {}
  
  public void run()
  {
    if (ComposeNoteActivity.access$000(this.this$1.this$0) != null)
    {
      ComposeNoteActivity.access$000(this.this$1.this$0).cancelDialog();
      ComposeNoteActivity.access$000(this.this$1.this$0).dismissTips();
      ComposeNoteActivity.access$000(this.this$1.this$0).errorDialog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.1.2
 * JD-Core Version:    0.7.0.1
 */