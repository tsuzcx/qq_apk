package com.idlefish.flutterboost;

import android.util.Log;

public class Debuger
{
  private static final Debuger DEBUG = new Debuger();
  private static final String TAG = "FlutterBoost#";
  
  public static void exception(String paramString)
  {
    if (!isDebug())
    {
      Log.e("FlutterBoost#", "exception", new RuntimeException(paramString));
      return;
    }
    throw new RuntimeException(paramString);
  }
  
  public static void exception(Throwable paramThrowable)
  {
    if (!isDebug())
    {
      Log.e("FlutterBoost#", "exception", paramThrowable);
      return;
    }
    throw new RuntimeException(paramThrowable);
  }
  
  public static boolean isDebug()
  {
    try
    {
      boolean bool = FlutterBoost.instance().platform().isDebug();
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static void log(String paramString)
  {
    DEBUG.print(paramString);
  }
  
  private void print(String paramString)
  {
    if (isDebug()) {
      Log.e("FlutterBoost#", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.Debuger
 * JD-Core Version:    0.7.0.1
 */