package com.tencent.richmediabrowser.log;

import android.util.Log;

public class BrowserLog
  implements IBrowserLog
{
  public void d(String paramString1, int paramInt, String paramString2)
  {
    if (isColorLevel()) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public void e(String paramString1, int paramInt, String paramString2)
  {
    if (isColorLevel()) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public void i(String paramString1, int paramInt, String paramString2)
  {
    if (isColorLevel()) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public boolean isColorLevel()
  {
    return true;
  }
  
  public void w(String paramString1, int paramInt, String paramString2)
  {
    if (isColorLevel()) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.log.BrowserLog
 * JD-Core Version:    0.7.0.1
 */