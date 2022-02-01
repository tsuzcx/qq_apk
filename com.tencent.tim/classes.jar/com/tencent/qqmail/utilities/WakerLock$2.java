package com.tencent.qqmail.utilities;

import android.os.Handler;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import java.lang.reflect.Method;

class WakerLock$2
  implements Runnable
{
  WakerLock$2(WakerLock paramWakerLock) {}
  
  public void run()
  {
    try
    {
      boolean bool = ((Boolean)Handler.class.getMethod("hasCallbacks", new Class[] { Runnable.class }).invoke(WakerLock.access$000(this.this$0), new Object[] { WakerLock.access$100(this.this$0) })).booleanValue();
      if (bool) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        Log.w("QQMail.WakerLock", "hasCallbacks call exception", localException);
      } while (!WakerLock.access$300().contains(WakerLock.access$200(this.this$0)));
      if (WakerLock.access$200(this.this$0).isHeld())
      {
        WakerLock.access$200(this.this$0).release();
        throw new DevRuntimeException("wakelock has been holding too long!!");
      }
      WakerLock.access$300().remove(WakerLock.access$200(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.WakerLock.2
 * JD-Core Version:    0.7.0.1
 */