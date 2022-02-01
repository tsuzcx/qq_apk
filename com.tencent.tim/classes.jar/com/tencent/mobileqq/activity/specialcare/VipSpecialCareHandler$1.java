package com.tencent.mobileqq.activity.specialcare;

import abbz;
import abca;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;

public class VipSpecialCareHandler$1
  implements Runnable
{
  public VipSpecialCareHandler$1(abbz paramabbz) {}
  
  public void run()
  {
    abbz.a(this.this$0, ThreadManager.newFreeHandlerThread("special-timer", 0));
    abbz.a(this.this$0).start();
    Looper localLooper = abbz.a(this.this$0).getLooper();
    if (localLooper == null) {
      return;
    }
    abbz.a(this.this$0, new abca(this, localLooper));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
 * JD-Core Version:    0.7.0.1
 */