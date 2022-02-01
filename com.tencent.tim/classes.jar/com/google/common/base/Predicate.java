package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface Predicate<T>
{
  @CanIgnoreReturnValue
  public abstract boolean apply(@Nullable T paramT);
  
  public abstract boolean equals(@Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Predicate
 * JD-Core Version:    0.7.0.1
 */