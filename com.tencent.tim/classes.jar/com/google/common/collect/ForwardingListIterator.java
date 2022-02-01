package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ListIterator;

@GwtCompatible
public abstract class ForwardingListIterator<E>
  extends ForwardingIterator<E>
  implements ListIterator<E>
{
  public void add(E paramE)
  {
    delegate().add(paramE);
  }
  
  protected abstract ListIterator<E> delegate();
  
  public boolean hasPrevious()
  {
    return delegate().hasPrevious();
  }
  
  public int nextIndex()
  {
    return delegate().nextIndex();
  }
  
  @CanIgnoreReturnValue
  public E previous()
  {
    return delegate().previous();
  }
  
  public int previousIndex()
  {
    return delegate().previousIndex();
  }
  
  public void set(E paramE)
  {
    delegate().set(paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingListIterator
 * JD-Core Version:    0.7.0.1
 */