package com.tencent.mobileqq.activity;

import arhz;
import uhv;

public class AutoLoginHelper$5
  implements Runnable
{
  public AutoLoginHelper$5(uhv paramuhv) {}
  
  public void run()
  {
    try
    {
      if ((uhv.a(this.this$0) == null) && (!uhv.a(this.this$0).isFinishing()))
      {
        uhv.a(this.this$0, new arhz(uhv.a(this.this$0), uhv.a(this.this$0).getTitleBarHeight()));
        uhv.a(this.this$0).setMessage(2131696693);
      }
      if ((uhv.a(this.this$0) != null) && (!uhv.a(this.this$0).isShowing())) {
        uhv.a(this.this$0).show();
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
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.5
 * JD-Core Version:    0.7.0.1
 */