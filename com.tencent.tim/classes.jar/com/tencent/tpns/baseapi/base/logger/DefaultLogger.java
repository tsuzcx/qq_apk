package com.tencent.tpns.baseapi.base.logger;

import android.util.Log;

class DefaultLogger
  implements LoggerInterface
{
  public void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public void v(String paramString1, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.v(paramString1, paramString2, paramThrowable);
  }
  
  public void w(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.logger.DefaultLogger
 * JD-Core Version:    0.7.0.1
 */