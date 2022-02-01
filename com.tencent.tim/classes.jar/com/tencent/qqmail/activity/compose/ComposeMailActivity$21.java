package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.thread.Threads;

class ComposeMailActivity$21
  implements Runnable
{
  ComposeMailActivity$21(ComposeMailActivity paramComposeMailActivity) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {}
    while ((this.this$0.composeView == null) || (this.this$0.isFinishing())) {
      return;
    }
    Threads.runOnMainThread(new ComposeMailActivity.21.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.21
 * JD-Core Version:    0.7.0.1
 */