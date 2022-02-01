package com.tencent.moai.downloader.util;

import android.util.Log;
import com.tencent.moai.downloader.delegate.LogDelegate;

final class Logger$1
  implements LogDelegate
{
  public void log(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      Log.v(paramString1, paramString2);
      return;
    case 1: 
      Log.d(paramString1, paramString2);
      return;
    case 2: 
      Log.i(paramString1, paramString2);
      return;
    case 3: 
      Log.w(paramString1, paramString2);
      return;
    }
    Log.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.util.Logger.1
 * JD-Core Version:    0.7.0.1
 */