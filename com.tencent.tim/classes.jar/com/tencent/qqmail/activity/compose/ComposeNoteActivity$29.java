package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.AttachInfo;

class ComposeNoteActivity$29
  implements Runnable
{
  ComposeNoteActivity$29(ComposeNoteActivity paramComposeNoteActivity, AttachInfo paramAttachInfo) {}
  
  public void run()
  {
    if (ComposeNoteActivity.access$900(this.this$0) != ComposeNoteActivity.SendMailStatus.SENDCLOSED)
    {
      this.val$info.setProcessed(true);
      ComposeNoteActivity.access$3602(this.this$0, ComposeNoteActivity.access$3600(this.this$0) - 1);
      if (ComposeNoteActivity.access$3600(this.this$0) < 0) {
        ComposeNoteActivity.access$3602(this.this$0, 0);
      }
      ComposeNoteActivity.access$3700(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.29
 * JD-Core Version:    0.7.0.1
 */