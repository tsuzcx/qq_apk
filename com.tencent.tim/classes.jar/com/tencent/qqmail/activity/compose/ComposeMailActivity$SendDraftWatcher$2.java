package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class ComposeMailActivity$SendDraftWatcher$2
  implements Runnable
{
  ComposeMailActivity$SendDraftWatcher$2(ComposeMailActivity.SendDraftWatcher paramSendDraftWatcher, ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    if (ComposeMailActivity.access$4400(this.val$activity) != ComposeMailActivity.SendMailStatus.SENDCANCEL)
    {
      if ((!ComposeMailActivity.access$11700(this.val$activity)) && (this.val$activity.composeMail != null)) {
        this.val$activity.composeMail.deleteComposeCache();
      }
      ComposeMailActivity.access$11800(this.val$activity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.SendDraftWatcher.2
 * JD-Core Version:    0.7.0.1
 */