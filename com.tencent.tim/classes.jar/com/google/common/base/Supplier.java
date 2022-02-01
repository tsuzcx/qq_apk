package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
public abstract interface Supplier<T>
{
  @CanIgnoreReturnValue
  public abstract T get();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Supplier
 * JD-Core Version:    0.7.0.1
 */