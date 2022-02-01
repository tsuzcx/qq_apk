package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
public abstract class ForwardingIterator<T>
  extends ForwardingObject
  implements Iterator<T>
{
  protected abstract Iterator<T> delegate();
  
  public boolean hasNext()
  {
    return delegate().hasNext();
  }
  
  @CanIgnoreReturnValue
  public T next()
  {
    return delegate().next();
  }
  
  public void remove()
  {
    delegate().remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingIterator
 * JD-Core Version:    0.7.0.1
 */