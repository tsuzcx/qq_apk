package com.tencent.mobileqq.cuckoo.utils;

import android.util.Log;

public class Logger
{
  private static final boolean DEBUG = Boolean.parseBoolean("true");
  public static final String PREFIX = "Cuckoo.";
  
  public static void d(String paramString1, String paramString2)
  {
    if (DEBUG) {
      Log.d("Cuckoo." + paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (DEBUG) {
      Log.e("Cuckoo." + paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (DEBUG) {
      Log.e("Cuckoo." + paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (DEBUG) {
      Log.i("Cuckoo." + paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    Log.w("Cuckoo." + paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.utils.Logger
 * JD-Core Version:    0.7.0.1
 */