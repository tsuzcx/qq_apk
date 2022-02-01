package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Looper;

public abstract class SyncTask<R>
{
  private final long bg;
  private long bh;
  private long bi;
  private Runnable bj = new SyncTask.1(this);
  private Object lock = new Object();
  private R result;
  
  public SyncTask()
  {
    this(0L, null);
  }
  
  public SyncTask(long paramLong, R paramR)
  {
    this.bg = paramLong;
    this.result = paramR;
  }
  
  public R exec(Handler paramHandler)
  {
    if (paramHandler == null)
    {
      Log.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
      return run();
    }
    if (Thread.currentThread().getId() == paramHandler.getLooper().getThread().getId())
    {
      Log.d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
      return run();
    }
    this.bh = Util.currentTicks();
    try
    {
      synchronized (this.lock)
      {
        paramHandler.post(this.bj);
        this.lock.wait(this.bg);
      }
      long l;
      return this.result;
    }
    catch (InterruptedException paramHandler)
    {
      paramHandler.printStackTrace();
      l = Util.ticksToNow(this.bh);
      paramHandler = new StringBuilder();
      paramHandler.append(this.result);
      Log.v("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", new Object[] { paramHandler.toString(), Long.valueOf(l), Long.valueOf(this.bi), Long.valueOf(l - this.bi) });
    }
  }
  
  protected abstract R run();
  
  public void setResult(R arg1)
  {
    this.result = ???;
    synchronized (this.lock)
    {
      this.lock.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SyncTask
 * JD-Core Version:    0.7.0.1
 */