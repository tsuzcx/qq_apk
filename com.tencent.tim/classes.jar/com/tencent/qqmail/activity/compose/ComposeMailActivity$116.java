package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.sendmail.SendMailHelper;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class ComposeMailActivity$116
  implements Runnable
{
  ComposeMailActivity$116(ComposeMailActivity paramComposeMailActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    synchronized (this.this$0.composeView)
    {
      String str = SendMailHelper.updateInlineImgsByComposeCache(this.this$0.composeView.getOriginContent(), StringExtention.MD5With32Charactor(this.val$src), this.val$localPath);
      this.this$0.composeView.setOriginContent(str, this.this$0.composeMail.getContent().getWidth(), this.this$0.composeMail.getContent().getScale());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.116
 * JD-Core Version:    0.7.0.1
 */