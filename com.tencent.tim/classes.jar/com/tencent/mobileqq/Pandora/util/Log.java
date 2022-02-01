package com.tencent.mobileqq.Pandora.util;

public class Log
{
  private static final String TAG = "Log";
  private static ILogCallback sLogCallback = null;
  
  public static void d(String paramString1, String paramString2)
  {
    if (sLogCallback != null) {
      sLogCallback.onWriteLog(paramString1, paramString2);
    }
    android.util.Log.d("Log", paramString1 + " || " + paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (sLogCallback != null) {
      sLogCallback.onWriteLog(paramString1, paramString2, paramThrowable);
    }
    android.util.Log.e("Log", paramString1 + " || " + paramString2, paramThrowable);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (sLogCallback != null) {
      sLogCallback.onWriteLog(paramString1, paramString2);
    }
    android.util.Log.i("Log", paramString1 + " || " + paramString2);
  }
  
  public static void setLogCallback(ILogCallback paramILogCallback)
  {
    sLogCallback = paramILogCallback;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (sLogCallback != null) {
      sLogCallback.onWriteLog(paramString1, paramString2);
    }
    android.util.Log.d("Log", paramString1 + " || " + paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (sLogCallback != null) {
      sLogCallback.onWriteLog(paramString1, paramString2);
    }
    android.util.Log.w("Log", paramString1 + " || " + paramString2);
  }
  
  public static abstract interface ILogCallback
  {
    public abstract void onWriteLog(String paramString1, String paramString2);
    
    public abstract void onWriteLog(String paramString1, String paramString2, Throwable paramThrowable);
    
    public abstract void onWriteLog(String paramString, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.util.Log
 * JD-Core Version:    0.7.0.1
 */