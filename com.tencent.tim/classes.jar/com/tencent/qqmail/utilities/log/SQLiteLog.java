package com.tencent.qqmail.utilities.log;

import com.tencent.moai.database.sqlite.SQLiteDebug.SQLiteLogger;
import moai.log.MLog;

public class SQLiteLog
  implements SQLiteDebug.SQLiteLogger
{
  private MLog mLogger;
  
  public SQLiteLog(MLog paramMLog)
  {
    this.mLogger = paramMLog;
  }
  
  public void d(String paramString1, String paramString2)
  {
    this.mLogger.d(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    this.mLogger.e(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2)
  {
    this.mLogger.i(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2)
  {
    this.mLogger.v(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    this.mLogger.w(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.SQLiteLog
 * JD-Core Version:    0.7.0.1
 */