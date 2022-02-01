package com.tencent.qqmail.utilities;

import com.tencent.qqmail.utilities.log.QMLog;
import moai.log.SimpleMLog;

class QMSoChecker$1$1
  extends SimpleMLog
{
  QMSoChecker$1$1(QMSoChecker.1 param1) {}
  
  public void process(int paramInt, String paramString1, String paramString2)
  {
    QMLog.log(paramInt, paramString1, paramString2);
  }
  
  public void process(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    QMLog.log(paramInt, paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMSoChecker.1.1
 * JD-Core Version:    0.7.0.1
 */