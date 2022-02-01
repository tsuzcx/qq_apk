package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public class VerifyException
  extends RuntimeException
{
  public VerifyException() {}
  
  public VerifyException(@Nullable String paramString)
  {
    super(paramString);
  }
  
  public VerifyException(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public VerifyException(@Nullable Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.base.VerifyException
 * JD-Core Version:    0.7.0.1
 */