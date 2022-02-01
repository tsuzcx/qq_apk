package com.tencent.mobileqq.mini.zxing;

public abstract class ReaderException
  extends Exception
{
  protected static final StackTraceElement[] NO_TRACE;
  protected static final boolean isStackTrace;
  
  static
  {
    if (System.getProperty("surefire.test.class.path") != null) {}
    for (boolean bool = true;; bool = false)
    {
      isStackTrace = bool;
      NO_TRACE = new StackTraceElement[0];
      return;
    }
  }
  
  ReaderException() {}
  
  ReaderException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public final Throwable fillInStackTrace()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.ReaderException
 * JD-Core Version:    0.7.0.1
 */