package com.tencent.feedback.eup.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.feedback.eup.CrashHandleListener;

public class NativeExceptionHandlerRqdImp
  implements NativeExceptionHandler
{
  private static NativeExceptionHandlerRqdImp a;
  public static CrashHandleListener listener;
  private String b;
  
  private NativeExceptionHandlerRqdImp(Context paramContext) {}
  
  public static NativeExceptionHandlerRqdImp getInstance()
  {
    try
    {
      NativeExceptionHandlerRqdImp localNativeExceptionHandlerRqdImp = a;
      return localNativeExceptionHandlerRqdImp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static NativeExceptionHandlerRqdImp getInstance(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new NativeExceptionHandlerRqdImp(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public String getTombDir()
  {
    try
    {
      String str = this.b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    handleNativeException(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, -1234567890, "", -1, -1, -1, "", "unknown");
  }
  
  public void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7)
  {
    handleNativeException(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, null);
  }
  
  public void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString)
  {
    c.a().l().handleNativeException2(paramInt1, paramInt2, paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4, paramInt3, paramString5, paramInt4, paramInt5, paramInt6, paramString6, paramString7, paramArrayOfString);
  }
  
  public void setTombDir(String paramString)
  {
    try
    {
      this.b = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.NativeExceptionHandlerRqdImp
 * JD-Core Version:    0.7.0.1
 */