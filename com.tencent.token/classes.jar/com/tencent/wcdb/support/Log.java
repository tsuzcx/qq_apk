package com.tencent.wcdb.support;

public class Log
{
  public static final int LOGGER_DEFAULT = 1;
  public static final int LOGGER_NONE = 0;
  private static LogCallback mCallback = null;
  
  public static void d(String paramString1, String paramString2)
  {
    println(3, paramString1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(3, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void e(String paramString1, String paramString2)
  {
    println(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(6, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void f(String paramString1, String paramString2)
  {
    println(7, paramString1, paramString2);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(7, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void i(String paramString1, String paramString2)
  {
    println(4, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(4, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  private static native void nativePrintLn(int paramInt, String paramString1, String paramString2);
  
  private static native void nativeSetLogger(int paramInt, LogCallback paramLogCallback);
  
  public static void println(int paramInt, String paramString1, String paramString2)
  {
    if (mCallback != null)
    {
      mCallback.println(paramInt, paramString1, paramString2);
      return;
    }
    nativePrintLn(paramInt, paramString1, paramString2);
  }
  
  public static void setLogger(int paramInt)
  {
    mCallback = null;
    nativeSetLogger(paramInt, null);
  }
  
  public static void setLogger(LogCallback paramLogCallback)
  {
    mCallback = paramLogCallback;
    nativeSetLogger(-1, paramLogCallback);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    println(2, paramString1, paramString2);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(2, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void w(String paramString1, String paramString2)
  {
    println(5, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(5, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static abstract interface LogCallback
  {
    public abstract void println(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.Log
 * JD-Core Version:    0.7.0.1
 */