package com.tencent.mobileqq.hotpic;

import ahzy;
import android.os.Handler;

public class PresenceInterfaceImpl$1
  implements Runnable
{
  public void run()
  {
    if (this.this$0.isPlaying())
    {
      this.this$0.drE();
      this.this$0.mHandler.postDelayed(this.this$0.gD, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.1
 * JD-Core Version:    0.7.0.1
 */