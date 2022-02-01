package com.tencent.mobileqq.transfile;

public class FileDownloadFailedException
  extends RuntimeException
{
  public int errorCode;
  public long errorDetailCode;
  public boolean needReport = true;
  private boolean needRetry;
  
  public FileDownloadFailedException(int paramInt1, int paramInt2, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    super(paramString, paramThrowable);
    this.errorCode = paramInt1;
    this.errorDetailCode = paramInt2;
    this.needRetry = paramBoolean;
  }
  
  public FileDownloadFailedException(int paramInt, long paramLong, String paramString, boolean paramBoolean)
  {
    this(paramInt, paramLong, paramString, paramBoolean, true);
  }
  
  public FileDownloadFailedException(int paramInt, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramString);
    this.errorCode = paramInt;
    this.errorDetailCode = paramLong;
    this.needRetry = paramBoolean1;
    this.needReport = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileDownloadFailedException
 * JD-Core Version:    0.7.0.1
 */