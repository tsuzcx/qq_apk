package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
public abstract interface PeekingIterator<E>
  extends Iterator<E>
{
  @CanIgnoreReturnValue
  public abstract E next();
  
  public abstract E peek();
  
  public abstract void remove();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.PeekingIterator
 * JD-Core Version:    0.7.0.1
 */