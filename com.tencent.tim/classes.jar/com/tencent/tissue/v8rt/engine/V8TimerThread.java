package com.tencent.tissue.v8rt.engine;

import java.util.concurrent.atomic.AtomicInteger;

public class V8TimerThread
  extends Thread
{
  public static final String LOG_TAG = "V8Timer";
  private IListener mListener;
  private final AtomicInteger mPendingVSyncCount = new AtomicInteger();
  
  public V8TimerThread(IListener paramIListener)
  {
    this.mListener = paramIListener;
    setPriority(10);
  }
  
  public void run()
  {
    if (this.mListener == null) {
      return;
    }
    this.mListener.onPrepare();
    try
    {
      boolean bool;
      do
      {
        bool = Engine.runLoop();
      } while (!bool);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Logger.e("V8Timer", "run error " + localException.getMessage());
      }
    }
    Logger.e("V8Timer", "run exit");
    this.mListener.onExit();
  }
  
  public static abstract interface IListener
  {
    public abstract void onExit();
    
    public abstract boolean onPrepare();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.V8TimerThread
 * JD-Core Version:    0.7.0.1
 */