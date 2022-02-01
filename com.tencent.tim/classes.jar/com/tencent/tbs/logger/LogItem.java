package com.tencent.tbs.logger;

public final class LogItem
{
  public LogLevel level;
  public String msg;
  public String tag;
  public long timeMillis;
  
  LogItem(long paramLong, LogLevel paramLogLevel, String paramString1, String paramString2)
  {
    this.timeMillis = paramLong;
    this.level = paramLogLevel;
    this.tag = paramString1;
    this.msg = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.LogItem
 * JD-Core Version:    0.7.0.1
 */