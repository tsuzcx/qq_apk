package com.tencent.moai.nativepages.util;

import android.util.Log;

public class LogUtil
{
  public static final String PARSE_XML_FAIL_EVENT = "PARSE_XML_FAIL_EVENT";
  public static final String TAG = "LogUtil";
  private static LogUtilsDelegate delegate;
  
  public static void kvlog(int paramInt, String paramString1, String paramString2)
  {
    if (delegate != null)
    {
      delegate.kvlog(paramString2);
      return;
    }
    Log.println(paramInt, paramString1, paramString2);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    if (delegate != null)
    {
      delegate.log(paramInt, paramString1, paramString2);
      return;
    }
    Log.println(paramInt, paramString1, paramString2);
  }
  
  public static void log(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (delegate != null)
    {
      delegate.log(paramInt, paramString1, String.format(paramString2, paramVarArgs));
      return;
    }
    Log.println(paramInt, paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void setDelegate(LogUtilsDelegate paramLogUtilsDelegate)
  {
    delegate = paramLogUtilsDelegate;
  }
  
  public static abstract interface LogUtilsDelegate
  {
    public abstract void kvlog(String paramString);
    
    public abstract void log(int paramInt, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.util.LogUtil
 * JD-Core Version:    0.7.0.1
 */