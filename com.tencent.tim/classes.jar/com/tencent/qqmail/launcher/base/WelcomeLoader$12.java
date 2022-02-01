package com.tencent.qqmail.launcher.base;

import com.tencent.moai.downloader.delegate.LogDelegate;
import com.tencent.qqmail.utilities.log.QMLog;

class WelcomeLoader$12
  implements LogDelegate
{
  WelcomeLoader$12(WelcomeLoader paramWelcomeLoader) {}
  
  public void log(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      QMLog.log(2, paramString1, paramString2);
      return;
    case 1: 
      QMLog.log(3, paramString1, paramString2);
      return;
    case 2: 
      QMLog.log(4, paramString1, paramString2);
      return;
    case 3: 
      QMLog.log(5, paramString1, paramString2);
      return;
    }
    QMLog.log(6, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.WelcomeLoader.12
 * JD-Core Version:    0.7.0.1
 */