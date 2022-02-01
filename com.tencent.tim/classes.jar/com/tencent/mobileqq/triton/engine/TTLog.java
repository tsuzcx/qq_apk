package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.sdk.ITLog;

public class TTLog
{
  private static ITLog a;
  private static ITLog b = new TTLog.a();
  
  public static int a(String paramString1, String paramString2)
  {
    return a().d(paramString1, paramString2);
  }
  
  public static int a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a().d(paramString1, paramString2, paramThrowable);
  }
  
  public static ITLog a()
  {
    ITLog localITLog = a;
    if (localITLog != null) {
      return localITLog;
    }
    return b;
  }
  
  public static void a(ITLog paramITLog)
  {
    a = paramITLog;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    return a().e(paramString1, paramString2);
  }
  
  public static int b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    return a().e(paramString1, paramString2, paramThrowable);
  }
  
  public static int c(String paramString1, String paramString2)
  {
    return a().i(paramString1, paramString2);
  }
  
  public static int d(String paramString1, String paramString2)
  {
    return a().w(paramString1, paramString2);
  }
  
  @TTNativeCall
  public static void printNativeLog(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = new String(paramArrayOfByte1);
    paramArrayOfByte2 = new String(paramArrayOfByte2);
    a().printNativeLog(paramInt, paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.TTLog
 * JD-Core Version:    0.7.0.1
 */