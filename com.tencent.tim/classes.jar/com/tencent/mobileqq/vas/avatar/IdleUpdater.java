package com.tencent.mobileqq.vas.avatar;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mqq.os.MqqHandler;

public abstract class IdleUpdater
  implements MessageQueue.IdleHandler, Runnable
{
  private int ecu;
  
  public IdleUpdater(int paramInt)
  {
    this.ecu = paramInt;
  }
  
  public abstract void onIdle();
  
  public void post()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Looper.myQueue().addIdleHandler(this);
      return;
    }
    ThreadManager.getUIHandler().post(this);
  }
  
  public boolean queueIdle()
  {
    ThreadManagerV2.excute(this, this.ecu, null, true);
    return false;
  }
  
  public void run()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Looper.myQueue().addIdleHandler(this);
      return;
    }
    onIdle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.IdleUpdater
 * JD-Core Version:    0.7.0.1
 */