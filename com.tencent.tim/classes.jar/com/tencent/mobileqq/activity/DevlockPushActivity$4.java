package com.tencent.mobileqq.activity;

import arhz;

class DevlockPushActivity$4
  implements Runnable
{
  DevlockPushActivity$4(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.w != null) && (this.this$0.w.isShowing()))
      {
        this.this$0.w.dismiss();
        this.this$0.w.cancel();
      }
      this.this$0.w = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity.4
 * JD-Core Version:    0.7.0.1
 */