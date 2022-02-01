package com.tencent.halley.downloader.d.a;

import com.tencent.token.mw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class d
  extends LinkedBlockingQueue
{
  public mw a = null;
  private Integer b = null;
  
  public d() {}
  
  public d(byte paramByte)
  {
    super(16);
  }
  
  private Runnable a(long paramLong, TimeUnit paramTimeUnit)
  {
    paramTimeUnit = (Runnable)super.poll(paramLong, paramTimeUnit);
    if (paramTimeUnit == null)
    {
      mw localmw = this.a;
      if (localmw != null) {
        localmw.a();
      }
    }
    return paramTimeUnit;
  }
  
  public final boolean a(Runnable paramRunnable, TimeUnit paramTimeUnit)
  {
    if (!this.a.isShutdown()) {
      return super.offer(paramRunnable, 0L, paramTimeUnit);
    }
    throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
  }
  
  public final int remainingCapacity()
  {
    return super.remainingCapacity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.d.a.d
 * JD-Core Version:    0.7.0.1
 */