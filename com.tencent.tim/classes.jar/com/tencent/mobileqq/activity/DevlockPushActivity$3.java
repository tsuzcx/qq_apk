package com.tencent.mobileqq.activity;

import arhz;

class DevlockPushActivity$3
  implements Runnable
{
  DevlockPushActivity$3(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.this$0.w == null) && (!this.this$0.isFinishing()))
      {
        this.this$0.w = new arhz(this.this$0, this.this$0.getTitleBarHeight());
        this.this$0.w.setMessage(2131696693);
      }
      if ((this.this$0.w != null) && (!this.this$0.w.isShowing())) {
        this.this$0.w.show();
      }
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
 * Qualified Name:     com.tencent.mobileqq.activity.DevlockPushActivity.3
 * JD-Core Version:    0.7.0.1
 */