package com.tencent.smtt.export.external.interfaces;

public abstract class QuicException
  extends NetworkException
{
  protected QuicException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public abstract int getQuicDetailedErrorCode();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.QuicException
 * JD-Core Version:    0.7.0.1
 */