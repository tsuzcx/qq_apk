package com.tencent.token.global.taiji;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class j
  extends Handler
{
  public j(d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    removeMessages(paramMessage.what);
    if (d.d(this.a))
    {
      long l = System.currentTimeMillis();
      if ((d.d() > 0L) && (Math.abs(d.e() - l) > d.d())) {
        this.a.c();
      }
      sendEmptyMessageDelayed(1, 1000L);
      return;
    }
    d.e(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.j
 * JD-Core Version:    0.7.0.1
 */