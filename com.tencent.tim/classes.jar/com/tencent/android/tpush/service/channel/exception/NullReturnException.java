package com.tencent.android.tpush.service.channel.exception;

public class NullReturnException
  extends Exception
{
  private static final long serialVersionUID = -2623309261327598087L;
  private int statusCode = -1;
  
  public NullReturnException(Exception paramException)
  {
    super(paramException);
  }
  
  public NullReturnException(String paramString)
  {
    super(paramString);
  }
  
  public NullReturnException(String paramString, int paramInt)
  {
    super(paramString);
    this.statusCode = paramInt;
  }
  
  public NullReturnException(String paramString, Exception paramException)
  {
    super(paramString, paramException);
  }
  
  public NullReturnException(String paramString, Exception paramException, int paramInt)
  {
    super(paramString, paramException);
    this.statusCode = paramInt;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.channel.exception.NullReturnException
 * JD-Core Version:    0.7.0.1
 */