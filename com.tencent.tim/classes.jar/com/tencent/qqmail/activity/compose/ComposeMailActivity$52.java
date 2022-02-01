package com.tencent.qqmail.activity.compose;

import android.view.View;

class ComposeMailActivity$52
  implements Runnable
{
  ComposeMailActivity$52(ComposeMailActivity paramComposeMailActivity, ComposeMailView paramComposeMailView, View paramView, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    do
    {
      do
      {
        return;
      } while (this.val$composeView == null);
      if ((this.val$sender instanceof ComposeAddrView))
      {
        ComposeAddrView localComposeAddrView = (ComposeAddrView)this.val$sender;
        this.val$composeView.adjustAutoCompleteCursor(localComposeAddrView);
        ComposeMailActivity.access$5700(this.this$0);
        return;
      }
    } while ((!(this.val$sender instanceof QMTextField)) || (ComposeMailActivity.access$600(this.this$0) == ComposeCommUI.QMSendType.t_SEND_GROUP_MAIL));
    this.val$composeView.scrollClickChange(this.val$sender, this.val$isKBShown);
    ComposeMailActivity.access$5700(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.52
 * JD-Core Version:    0.7.0.1
 */