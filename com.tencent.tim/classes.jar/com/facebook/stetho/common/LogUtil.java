package com.facebook.stetho.common;

import java.util.Locale;

public class LogUtil
{
  private static final String TAG = "stetho";
  
  public static void d(String paramString)
  {
    if (isLoggable(3)) {
      LogRedirector.d("stetho", paramString);
    }
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    d(format(paramString, paramVarArgs));
  }
  
  public static void d(Throwable paramThrowable, String paramString)
  {
    if (isLoggable(3)) {
      LogRedirector.d("stetho", paramString, paramThrowable);
    }
  }
  
  public static void d(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    d(paramThrowable, format(paramString, paramVarArgs));
  }
  
  public static void e(String paramString)
  {
    if (isLoggable(6)) {
      LogRedirector.e("stetho", paramString);
    }
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    e(format(paramString, paramVarArgs));
  }
  
  public static void e(Throwable paramThrowable, String paramString)
  {
    if (isLoggable(6)) {
      LogRedirector.e("stetho", paramString, paramThrowable);
    }
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    e(paramThrowable, format(paramString, paramVarArgs));
  }
  
  private static String format(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  public static void i(String paramString)
  {
    if (isLoggable(4)) {
      LogRedirector.i("stetho", paramString);
    }
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    i(format(paramString, paramVarArgs));
  }
  
  public static void i(Throwable paramThrowable, String paramString)
  {
    if (isLoggable(4)) {
      LogRedirector.i("stetho", paramString, paramThrowable);
    }
  }
  
  public static void i(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    i(paramThrowable, format(paramString, paramVarArgs));
  }
  
  public static boolean isLoggable(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return LogRedirector.isLoggable("stetho", paramInt);
    }
    return true;
  }
  
  public static void v(String paramString)
  {
    if (isLoggable(2)) {
      LogRedirector.v("stetho", paramString);
    }
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    v(format(paramString, paramVarArgs));
  }
  
  public static void v(Throwable paramThrowable, String paramString)
  {
    if (isLoggable(2)) {
      LogRedirector.v("stetho", paramString, paramThrowable);
    }
  }
  
  public static void v(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    v(paramThrowable, format(paramString, paramVarArgs));
  }
  
  public static void w(String paramString)
  {
    if (isLoggable(5)) {
      LogRedirector.w("stetho", paramString);
    }
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    w(format(paramString, paramVarArgs));
  }
  
  public static void w(Throwable paramThrowable, String paramString)
  {
    if (isLoggable(5)) {
      LogRedirector.w("stetho", paramString, paramThrowable);
    }
  }
  
  public static void w(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    w(paramThrowable, format(paramString, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.LogUtil
 * JD-Core Version:    0.7.0.1
 */