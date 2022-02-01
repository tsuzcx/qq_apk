package com.tencent.qqmail.launcher.base;

import java.util.ArrayList;

class WelcomeLoader$1
  implements Runnable
{
  WelcomeLoader$1(WelcomeLoader paramWelcomeLoader, WelcomeLoader.Callback paramCallback) {}
  
  public void run()
  {
    if (WelcomeLoader.access$000(this.this$0))
    {
      this.val$callback.finish();
      return;
    }
    WelcomeLoader.access$100(this.this$0).add(this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader.1
 * JD-Core Version:    0.7.0.1
 */