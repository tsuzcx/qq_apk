package com.tencent.biz.pubaccount.readinjoy.imageopt;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class RIJImageOptLinkedBlockingDeque
  extends LinkedBlockingDeque
{
  public RIJImageOptLinkedBlockingDeque(int paramInt)
  {
    super(paramInt);
  }
  
  public Object poll()
  {
    return pollLast();
  }
  
  public Object poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return pollLast(paramLong, paramTimeUnit);
  }
  
  public Object take()
    throws InterruptedException
  {
    return takeLast();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptLinkedBlockingDeque
 * JD-Core Version:    0.7.0.1
 */