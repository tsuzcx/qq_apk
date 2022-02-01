package com.tencent.moai.mailsdk.util.log;

import android.util.Log;

final class Logger$1
  implements LoggerDelegate
{
  public void log(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      Log.v(paramString1, paramString2);
      return;
    case 3: 
      Log.d(paramString1, paramString2);
      return;
    case 4: 
      Log.i(paramString1, paramString2);
      return;
    case 5: 
      Log.w(paramString1, paramString2);
      return;
    case 6: 
      Log.e(paramString1, paramString2);
      return;
    }
    Log.wtf(paramString1, paramString2);
  }
  
  public void ossLog(Object... paramVarArgs) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.log.Logger.1
 * JD-Core Version:    0.7.0.1
 */