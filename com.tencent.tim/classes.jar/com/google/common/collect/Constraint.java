package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
abstract interface Constraint<E>
{
  @CanIgnoreReturnValue
  public abstract E checkElement(E paramE);
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Constraint
 * JD-Core Version:    0.7.0.1
 */