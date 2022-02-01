package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@GwtCompatible
public abstract class Ticker
{
  private static final Ticker SYSTEM_TICKER = new Ticker.1();
  
  public static Ticker systemTicker()
  {
    return SYSTEM_TICKER;
  }
  
  @CanIgnoreReturnValue
  public abstract long read();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.Ticker
 * JD-Core Version:    0.7.0.1
 */