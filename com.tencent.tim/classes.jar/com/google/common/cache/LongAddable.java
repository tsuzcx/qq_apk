package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
abstract interface LongAddable
{
  public abstract void add(long paramLong);
  
  public abstract void increment();
  
  public abstract long sum();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LongAddable
 * JD-Core Version:    0.7.0.1
 */