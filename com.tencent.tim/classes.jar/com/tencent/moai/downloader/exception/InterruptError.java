package com.tencent.moai.downloader.exception;

import android.annotation.TargetApi;

public class InterruptError
  extends Throwable
{
  public InterruptError() {}
  
  public InterruptError(String paramString)
  {
    super(paramString);
  }
  
  public InterruptError(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  @TargetApi(19)
  public InterruptError(String paramString, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
  }
  
  public InterruptError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.exception.InterruptError
 * JD-Core Version:    0.7.0.1
 */