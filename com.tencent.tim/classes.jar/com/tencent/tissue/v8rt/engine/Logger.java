package com.tencent.tissue.v8rt.engine;

import com.tencent.tissue.v8rt.anno.CallByNative;

public class Logger
{
  private static ILog sDefLog = new Logger.1();
  private static ILog sLogProxy;
  
  public static int d(String paramString1, String paramString2)
  {
    return getLog().d(paramString1, paramString2);
  }
  
  public static int d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return getLog().d(paramString1, paramString2, paramThrowable);
  }
  
  public static int e(String paramString1, String paramString2)
  {
    return getLog().e(paramString1, paramString2);
  }
  
  public static int e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return getLog().e(paramString1, paramString2, paramThrowable);
  }
  
  public static ILog getLog()
  {
    if (sLogProxy != null) {
      return sLogProxy;
    }
    return sDefLog;
  }
  
  public static int i(String paramString1, String paramString2)
  {
    return getLog().i(paramString1, paramString2);
  }
  
  public static int i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return getLog().i(paramString1, paramString2, paramThrowable);
  }
  
  public static void init(ILog paramILog)
  {
    sLogProxy = paramILog;
  }
  
  @CallByNative
  public static void printNativeLog(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = new String(paramArrayOfByte1);
    paramArrayOfByte2 = new String(paramArrayOfByte2);
    getLog().printNativeLog(paramInt, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public static int w(String paramString1, String paramString2)
  {
    return getLog().w(paramString1, paramString2);
  }
  
  public static int w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return getLog().w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.Logger
 * JD-Core Version:    0.7.0.1
 */