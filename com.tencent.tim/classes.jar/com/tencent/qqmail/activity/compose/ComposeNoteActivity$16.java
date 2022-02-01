package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.sendmail.SendMailHelper;
import org.apache.commons.lang3.StringUtils;

class ComposeNoteActivity$16
  implements Runnable
{
  ComposeNoteActivity$16(ComposeNoteActivity paramComposeNoteActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((!StringUtils.isEmpty(this.val$src)) && (!this.val$src.startsWith("http")) && (ComposeNoteActivity.access$2200(this.this$0, this.val$src) != null)) {
      synchronized (ComposeNoteActivity.access$1400(this.this$0))
      {
        ComposeNoteActivity.access$1400(this.this$0).setContentText(SendMailHelper.updateInlineImgsWithSrc(ComposeNoteActivity.access$1400(this.this$0).getContentText(), this.val$src, this.val$localPath));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.16
 * JD-Core Version:    0.7.0.1
 */