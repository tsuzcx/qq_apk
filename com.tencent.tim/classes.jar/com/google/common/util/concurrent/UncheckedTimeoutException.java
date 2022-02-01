package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible
public class UncheckedTimeoutException
  extends RuntimeException
{
  private static final long serialVersionUID = 0L;
  
  public UncheckedTimeoutException() {}
  
  public UncheckedTimeoutException(@Nullable String paramString)
  {
    super(paramString);
  }
  
  public UncheckedTimeoutException(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UncheckedTimeoutException(@Nullable Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.UncheckedTimeoutException
 * JD-Core Version:    0.7.0.1
 */