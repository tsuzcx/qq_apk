package com.tencent.qqmail.view;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

class WindowCheckTask$2
  extends Handler
{
  private static final long ASYNC_CHECK_DELAY_TIME = 60000L;
  private long mAsyncCheckAllowedTime = -1L;
  
  WindowCheckTask$2(WindowCheckTask paramWindowCheckTask) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      Log.w("tagorewang:WindowCheckTask", "doAsyncCheck: unkown msg");
    case 1000: 
      do
      {
        return;
      } while (SystemClock.uptimeMillis() < this.mAsyncCheckAllowedTime);
      WindowCheckTask.access$100(this.this$0);
      return;
    }
    removeMessages(1000);
    this.mAsyncCheckAllowedTime = (SystemClock.uptimeMillis() + 60000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.WindowCheckTask.2
 * JD-Core Version:    0.7.0.1
 */