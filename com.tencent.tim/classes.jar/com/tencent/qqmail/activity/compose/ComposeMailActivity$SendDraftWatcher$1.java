package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.ui.QMProgressTips;

class ComposeMailActivity$SendDraftWatcher$1
  implements Runnable
{
  ComposeMailActivity$SendDraftWatcher$1(ComposeMailActivity.SendDraftWatcher paramSendDraftWatcher, double paramDouble, ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    int i = (int)(this.val$process * 100.0D);
    ComposeMailActivity.access$11500(this.val$activity).updateProgress(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.SendDraftWatcher.1
 * JD-Core Version:    0.7.0.1
 */