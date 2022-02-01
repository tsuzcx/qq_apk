package com.tencent.tbs.one;

public class TBSOneException
  extends Exception
{
  private int a = -1;
  
  public TBSOneException(int paramInt, String paramString)
  {
    super(paramString);
    this.a = paramInt;
  }
  
  public TBSOneException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.a = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "[" + this.a + "] " + getLocalizedMessage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneException
 * JD-Core Version:    0.7.0.1
 */