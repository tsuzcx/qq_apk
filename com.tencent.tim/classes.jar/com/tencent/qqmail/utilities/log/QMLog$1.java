package com.tencent.qqmail.utilities.log;

import com.tencent.qphone.base.util.QLog;
import moai.log.LogcatHandler;

final class QMLog$1
  extends LogcatHandler
{
  public int publish(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 4) {
      QLog.i(paramString1, 1, paramString2);
    }
    for (;;)
    {
      return super.publish(paramInt, paramString1, paramString2);
      if (paramInt == 5) {
        QLog.w(paramString1, 1, paramString2);
      } else if (paramInt == 6) {
        QLog.e(paramString1, 1, paramString2);
      }
    }
  }
  
  public int publish(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramInt == 4) {
      QLog.i(paramString1, 1, paramString2, paramThrowable);
    }
    for (;;)
    {
      return super.publish(paramInt, paramString1, paramString2, paramThrowable);
      if (paramInt == 5) {
        QLog.w(paramString1, 1, paramString2, paramThrowable);
      } else if (paramInt == 6) {
        QLog.e(paramString1, 1, paramString2, paramThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLog.1
 * JD-Core Version:    0.7.0.1
 */