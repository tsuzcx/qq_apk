package com.google.zxing;

public class ReaderException
  extends Exception
{
  private static final ReaderException a = new ReaderException();
  
  public static ReaderException getInstance()
  {
    return a;
  }
  
  public final Throwable fillInStackTrace()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.ReaderException
 * JD-Core Version:    0.7.0.1
 */