package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.imageextention.ImageUtil;

class ComposeMailActivity$74
  implements Runnable
{
  ComposeMailActivity$74(ComposeMailActivity paramComposeMailActivity, Runnable paramRunnable) {}
  
  public void run()
  {
    ImageUtil.CompressImage(this.this$0.composeMail);
    try
    {
      Thread.sleep(500L);
      ComposeMailActivity.access$8700(this.this$0, new ComposeMailActivity.74.1(this));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.74
 * JD-Core Version:    0.7.0.1
 */