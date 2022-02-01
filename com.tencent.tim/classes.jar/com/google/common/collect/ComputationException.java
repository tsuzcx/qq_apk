package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public class ComputationException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  public ComputationException(@Nullable Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ComputationException
 * JD-Core Version:    0.7.0.1
 */