package com.tencent.qqmail.activity.compose;

class ComposeMailActivity$ReadMailWatcher$2
  implements Runnable
{
  ComposeMailActivity$ReadMailWatcher$2(ComposeMailActivity.ReadMailWatcher paramReadMailWatcher, ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    if (this.val$activity.composeView != null) {
      this.val$activity.composeView.showContentLoadingError();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.ReadMailWatcher.2
 * JD-Core Version:    0.7.0.1
 */