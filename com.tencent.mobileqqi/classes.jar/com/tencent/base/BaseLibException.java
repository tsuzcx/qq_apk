package com.tencent.base;

public class BaseLibException
  extends RuntimeException
{
  private static final long serialVersionUID = 2945737496904114992L;
  
  public BaseLibException() {}
  
  public BaseLibException(String paramString)
  {
    super(paramString);
  }
  
  public BaseLibException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public BaseLibException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.base.BaseLibException
 * JD-Core Version:    0.7.0.1
 */