package com.tencent.thumbplayer.core.downloadproxy.utils;

import android.util.Log;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;

public class TPDLProxyLog
{
  private static ITPDLProxyLogListener mLogListener;
  private static int mServiceType;
  
  public static void d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (mLogListener != null)
    {
      mLogListener.d(paramString1, paramInt, paramString2, paramString3);
      return;
    }
    Log.d("[" + paramString2 + "][" + paramString1 + ":" + paramInt + "]", paramString3);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (mLogListener != null)
    {
      mLogListener.e(paramString1, paramInt, paramString2, paramString3);
      return;
    }
    Log.e("[" + paramString2 + "][" + paramString1 + ":" + paramInt + "]", paramString3);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (mLogListener != null)
    {
      mLogListener.i(paramString1, paramInt, paramString2, paramString3);
      return;
    }
    Log.i("[" + paramString2 + "][" + paramString1 + ":" + paramInt + "]", paramString3);
  }
  
  public static void setLogListener(int paramInt, ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    mServiceType = paramInt;
    mLogListener = paramITPDLProxyLogListener;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (mLogListener != null)
    {
      mLogListener.w(paramString1, paramInt, paramString2, paramString3);
      return;
    }
    Log.w("[" + paramString2 + "][" + paramString1 + ":" + paramInt + "]", paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog
 * JD-Core Version:    0.7.0.1
 */