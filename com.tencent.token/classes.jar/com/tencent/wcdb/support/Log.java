package com.tencent.wcdb.support;

public class Log
{
  private static LogCallback a;
  
  private static void a(int paramInt, String paramString1, String paramString2)
  {
    LogCallback localLogCallback = a;
    if (localLogCallback != null)
    {
      localLogCallback.println(paramInt, paramString1, paramString2);
      return;
    }
    nativePrintLn(paramInt, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(6, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(6, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(5, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(5, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2);
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    a(4, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  private static native void nativePrintLn(int paramInt, String paramString1, String paramString2);
  
  private static native void nativeSetLogger(int paramInt, LogCallback paramLogCallback);
  
  public static abstract interface LogCallback
  {
    public abstract void println(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.support.Log
 * JD-Core Version:    0.7.0.1
 */