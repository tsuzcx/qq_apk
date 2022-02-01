package com.tencent.halley.downloader.d.a;

import com.tencent.token.nh;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class a
  extends PriorityBlockingQueue
{
  public nh a = null;
  private Integer b = null;
  
  public a() {}
  
  public a(byte paramByte)
  {
    super(64);
  }
  
  private Runnable a(long paramLong, TimeUnit paramTimeUnit)
  {
    paramTimeUnit = (Runnable)super.poll(paramLong, paramTimeUnit);
    if (paramTimeUnit == null)
    {
      nh localnh = this.a;
      if (localnh != null) {
        localnh.a();
      }
    }
    return paramTimeUnit;
  }
  
  public final int remainingCapacity()
  {
    return super.remainingCapacity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.d.a.a
 * JD-Core Version:    0.7.0.1
 */