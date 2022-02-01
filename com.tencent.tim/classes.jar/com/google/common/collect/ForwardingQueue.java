package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
public abstract class ForwardingQueue<E>
  extends ForwardingCollection<E>
  implements Queue<E>
{
  protected abstract Queue<E> delegate();
  
  public E element()
  {
    return delegate().element();
  }
  
  @CanIgnoreReturnValue
  public boolean offer(E paramE)
  {
    return delegate().offer(paramE);
  }
  
  public E peek()
  {
    return delegate().peek();
  }
  
  @CanIgnoreReturnValue
  public E poll()
  {
    return delegate().poll();
  }
  
  @CanIgnoreReturnValue
  public E remove()
  {
    return delegate().remove();
  }
  
  protected boolean standardOffer(E paramE)
  {
    try
    {
      boolean bool = add(paramE);
      return bool;
    }
    catch (IllegalStateException paramE) {}
    return false;
  }
  
  protected E standardPeek()
  {
    try
    {
      Object localObject = element();
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException) {}
    return null;
  }
  
  protected E standardPoll()
  {
    try
    {
      Object localObject = remove();
      return localObject;
    }
    catch (NoSuchElementException localNoSuchElementException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingQueue
 * JD-Core Version:    0.7.0.1
 */