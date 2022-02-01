package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class AbstractSequentialIterator<T>
  extends UnmodifiableIterator<T>
{
  private T nextOrNull;
  
  protected AbstractSequentialIterator(@Nullable T paramT)
  {
    this.nextOrNull = paramT;
  }
  
  protected abstract T computeNext(T paramT);
  
  public final boolean hasNext()
  {
    return this.nextOrNull != null;
  }
  
  public final T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    try
    {
      Object localObject1 = this.nextOrNull;
      return localObject1;
    }
    finally
    {
      this.nextOrNull = computeNext(this.nextOrNull);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractSequentialIterator
 * JD-Core Version:    0.7.0.1
 */