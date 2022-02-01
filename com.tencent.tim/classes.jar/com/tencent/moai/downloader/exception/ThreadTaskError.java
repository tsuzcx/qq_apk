package com.tencent.moai.downloader.exception;

import android.annotation.TargetApi;

public class ThreadTaskError
  extends Throwable
{
  private int errorCode;
  
  public ThreadTaskError(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public ThreadTaskError(int paramInt, String paramString)
  {
    super(paramString);
    this.errorCode = paramInt;
  }
  
  public ThreadTaskError(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.errorCode = paramInt;
  }
  
  @TargetApi(19)
  protected ThreadTaskError(int paramInt, String paramString, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
    this.errorCode = paramInt;
  }
  
  public ThreadTaskError(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.errorCode = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.exception.ThreadTaskError
 * JD-Core Version:    0.7.0.1
 */