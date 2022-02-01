package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
public final class Runnables
{
  private static final Runnable EMPTY_RUNNABLE = new Runnables.1();
  
  public static Runnable doNothing()
  {
    return EMPTY_RUNNABLE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Runnables
 * JD-Core Version:    0.7.0.1
 */