package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.sendmail.SendMailHelper;

class ComposeMailActivity$115
  implements Runnable
{
  ComposeMailActivity$115(ComposeMailActivity paramComposeMailActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    synchronized (this.this$0.composeView)
    {
      String str = SendMailHelper.updateInlineImgsWithSrc(this.this$0.composeView.getContentText(true), this.val$src, this.val$localPath);
      this.this$0.composeView.setContentText(str, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.115
 * JD-Core Version:    0.7.0.1
 */