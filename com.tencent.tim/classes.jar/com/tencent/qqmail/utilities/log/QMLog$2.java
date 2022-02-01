package com.tencent.qqmail.utilities.log;

import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDebug.SQLiteLogger;

final class QMLog$2
  implements SQLiteDebug.SQLiteLogger
{
  public void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    QMLog.log(6, paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2)
  {
    QMLog.log(4, paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    QMLog.log(5, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.QMLog.2
 * JD-Core Version:    0.7.0.1
 */