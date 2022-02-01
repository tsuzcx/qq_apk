package com.tencent.aekit.target.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class HandlerWrapper
  extends Handler
{
  private MessageHandler mh = null;
  
  public HandlerWrapper(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void call(Runnable paramRunnable)
  {
    synchronized (new Object())
    {
      post(new HandlerWrapper.1(this, ???, paramRunnable));
      try
      {
        ???.wait();
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        for (;;)
        {
          paramRunnable.printStackTrace();
        }
      }
    }
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.mh != null) {
      this.mh.handleMessage(paramMessage);
    }
  }
  
  public void setMessageHandler(MessageHandler paramMessageHandler)
  {
    this.mh = paramMessageHandler;
  }
  
  public static abstract interface MessageHandler
  {
    public abstract void handleMessage(Message paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aekit.target.utils.HandlerWrapper
 * JD-Core Version:    0.7.0.1
 */