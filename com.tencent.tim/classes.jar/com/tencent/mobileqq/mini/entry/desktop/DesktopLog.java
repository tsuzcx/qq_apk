package com.tencent.mobileqq.mini.entry.desktop;

import com.tencent.qphone.base.util.QLog;

public class DesktopLog
  implements com.tencent.ditto.utils.Log
{
  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.d(paramString1, 2, paramString2, paramThrowable);
  }
  
  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e(paramString1, 1, paramString2, paramThrowable);
  }
  
  public void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i(paramString1, 2, paramString2, paramThrowable);
  }
  
  public boolean isColoredLevel()
  {
    return QLog.isColorLevel();
  }
  
  public void v(String paramString1, String paramString2, Throwable paramThrowable)
  {
    android.util.Log.v(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.w(paramString1, 1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.DesktopLog
 * JD-Core Version:    0.7.0.1
 */