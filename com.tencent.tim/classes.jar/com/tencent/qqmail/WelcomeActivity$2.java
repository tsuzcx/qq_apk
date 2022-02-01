package com.tencent.qqmail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;

class WelcomeActivity$2
  implements Runnable
{
  WelcomeActivity$2(WelcomeActivity paramWelcomeActivity) {}
  
  public void run()
  {
    WelcomeActivity.access$100(this.this$0);
    boolean bool = WelcomeActivity.access$200(this.this$0);
    long l = System.currentTimeMillis() - WelcomeActivity.access$300(this.this$0);
    if (l < 1000L) {}
    for (l = 1000L - l;; l = 0L)
    {
      QMLog.log(4, "WelcomeActivity", "hasPopularize " + bool);
      if (!bool) {
        break;
      }
      Threads.runOnMainThread(new WelcomeActivity.2.1(this), l);
      return;
    }
    this.this$0.directToNextPageInClock(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.2
 * JD-Core Version:    0.7.0.1
 */