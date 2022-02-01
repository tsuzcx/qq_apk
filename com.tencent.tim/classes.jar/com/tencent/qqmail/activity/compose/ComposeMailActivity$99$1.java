package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class ComposeMailActivity$99$1
  implements Runnable
{
  ComposeMailActivity$99$1(ComposeMailActivity.99 param99) {}
  
  public void run()
  {
    if (ComposeMailActivity.access$4400(this.this$1.this$0) != ComposeMailActivity.SendMailStatus.SENDCANCEL)
    {
      if ((!ComposeMailActivity.access$11700(this.this$1.this$0)) && (this.this$1.val$mail != null)) {
        this.this$1.val$mail.deleteComposeCache();
      }
      ComposeMailActivity.access$11800(this.this$1.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.99.1
 * JD-Core Version:    0.7.0.1
 */