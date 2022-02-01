package com.tencent.thumbplayer.log;

public abstract interface ITPLogger
{
  public abstract void debug(String paramString);
  
  public abstract void error(String paramString);
  
  public abstract String getTag();
  
  public abstract void info(String paramString);
  
  public abstract void printException(Exception paramException);
  
  public abstract void updateContext(TPLoggerContext paramTPLoggerContext);
  
  public abstract void updateTaskId(String paramString);
  
  public abstract void verbose(String paramString);
  
  public abstract void warn(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.log.ITPLogger
 * JD-Core Version:    0.7.0.1
 */