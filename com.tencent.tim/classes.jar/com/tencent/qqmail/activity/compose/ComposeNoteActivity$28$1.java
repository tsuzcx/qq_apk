package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.attachment.model.AttachType;
import com.tencent.qqmail.model.qmdomain.AttachInfo;

class ComposeNoteActivity$28$1
  implements Runnable
{
  ComposeNoteActivity$28$1(ComposeNoteActivity.28 param28, AttachInfo paramAttachInfo) {}
  
  public void run()
  {
    if ((!this.this$1.this$0.isDestroyed()) && (AttachType.IMAGE.equals(this.val$info.getFileType()))) {
      this.this$1.this$0.addToContent(this.val$info);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.28.1
 * JD-Core Version:    0.7.0.1
 */