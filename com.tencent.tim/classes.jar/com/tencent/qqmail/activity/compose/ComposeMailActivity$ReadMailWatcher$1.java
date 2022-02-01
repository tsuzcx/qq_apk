package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.uidomain.ComposeMailUI;

class ComposeMailActivity$ReadMailWatcher$1
  implements Runnable
{
  ComposeMailActivity$ReadMailWatcher$1(ComposeMailActivity.ReadMailWatcher paramReadMailWatcher, ComposeMailActivity paramComposeMailActivity, ComposeMailUI paramComposeMailUI) {}
  
  public void run()
  {
    if (this.val$activity.composeView != null)
    {
      this.val$activity.composeMail = this.val$mail;
      ComposeMailActivity.access$5402(this.val$activity, null);
      this.val$activity.composeMail.setOriginContentComplete(true);
      ComposeMailActivity.access$10700(this.val$activity);
      ComposeMailActivity.access$15800(this.val$activity, this.val$activity.composeMail);
      this.val$activity.composeView.hideContentLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.ReadMailWatcher.1
 * JD-Core Version:    0.7.0.1
 */