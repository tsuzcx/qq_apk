package com.tencent.mobileqq.activity;

import arhz;
import uhv;

public class AutoLoginHelper$6
  implements Runnable
{
  public AutoLoginHelper$6(uhv paramuhv) {}
  
  public void run()
  {
    try
    {
      if ((uhv.a(this.this$0) != null) && (uhv.a(this.this$0).isShowing()))
      {
        uhv.a(this.this$0).dismiss();
        uhv.a(this.this$0).cancel();
      }
      uhv.a(this.this$0, null);
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
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper.6
 * JD-Core Version:    0.7.0.1
 */