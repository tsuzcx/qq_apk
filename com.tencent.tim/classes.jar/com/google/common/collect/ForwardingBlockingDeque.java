package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
public abstract class ForwardingBlockingDeque<E>
  extends ForwardingDeque<E>
  implements BlockingDeque<E>
{
  protected abstract BlockingDeque<E> delegate();
  
  public int drainTo(Collection<? super E> paramCollection)
  {
    return delegate().drainTo(paramCollection);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    return delegate().drainTo(paramCollection, paramInt);
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().offer(paramE, paramLong, paramTimeUnit);
  }
  
  public boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().offerFirst(paramE, paramLong, paramTimeUnit);
  }
  
  public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().offerLast(paramE, paramLong, paramTimeUnit);
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().poll(paramLong, paramTimeUnit);
  }
  
  public E pollFirst(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().pollFirst(paramLong, paramTimeUnit);
  }
  
  public E pollLast(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return delegate().pollLast(paramLong, paramTimeUnit);
  }
  
  public void put(E paramE)
    throws InterruptedException
  {
    delegate().put(paramE);
  }
  
  public void putFirst(E paramE)
    throws InterruptedException
  {
    delegate().putFirst(paramE);
  }
  
  public void putLast(E paramE)
    throws InterruptedException
  {
    delegate().putLast(paramE);
  }
  
  public int remainingCapacity()
  {
    return delegate().remainingCapacity();
  }
  
  public E take()
    throws InterruptedException
  {
    return delegate().take();
  }
  
  public E takeFirst()
    throws InterruptedException
  {
    return delegate().takeFirst();
  }
  
  public E takeLast()
    throws InterruptedException
  {
    return delegate().takeLast();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingBlockingDeque
 * JD-Core Version:    0.7.0.1
 */