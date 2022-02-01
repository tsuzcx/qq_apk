package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.attachment.model.Attach;
import com.tencent.qqmail.attachment.model.AttachProtocol;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class ComposeMailActivity$119
  implements Runnable
{
  ComposeMailActivity$119(ComposeMailActivity paramComposeMailActivity, Attach paramAttach, String paramString) {}
  
  public void run()
  {
    synchronized (this.this$0.composeView)
    {
      ComposeMailActivity.access$13902(this.this$0, SendMailHelper.updateInlineImgsByComposeCache(ComposeMailActivity.access$13900(this.this$0), this.val$attach.getProtocol().getCid(), this.val$localPath));
      String str = SendMailHelper.updateInlineImgsByComposeCache(this.this$0.composeView.getOriginContent(), this.val$attach.getProtocol().getCid(), this.val$localPath);
      this.this$0.composeView.setOriginContent(str, this.this$0.composeMail.getContent().getWidth(), this.this$0.composeMail.getContent().getScale());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.119
 * JD-Core Version:    0.7.0.1
 */