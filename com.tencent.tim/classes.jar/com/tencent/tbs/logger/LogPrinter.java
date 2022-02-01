package com.tencent.tbs.logger;

public abstract interface LogPrinter
{
  public abstract void close();
  
  public abstract void println(LogItem paramLogItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.LogPrinter
 * JD-Core Version:    0.7.0.1
 */