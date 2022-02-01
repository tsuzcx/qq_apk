package com.tencent.qqmail;

import com.tencent.qqmail.popularize.model.Popularize;

class WelcomeActivity$2$1
  implements Runnable
{
  WelcomeActivity$2$1(WelcomeActivity.2 param2) {}
  
  public void run()
  {
    WelcomeActivity.access$400(this.this$1.this$0);
    WelcomeActivity localWelcomeActivity = this.this$1.this$0;
    if (WelcomeActivity.access$500(this.this$1.this$0).getDuration() >= 0.0D) {}
    for (long l = WelcomeActivity.access$500(this.this$1.this$0).getDuration();; l = 2000L)
    {
      localWelcomeActivity.directToNextPageInClock(l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.2.1
 * JD-Core Version:    0.7.0.1
 */