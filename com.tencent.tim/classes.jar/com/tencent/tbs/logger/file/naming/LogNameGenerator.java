package com.tencent.tbs.logger.file.naming;

import com.tencent.tbs.logger.LogItem;

public abstract interface LogNameGenerator
{
  public abstract String generateFileName(LogItem paramLogItem);
  
  public abstract boolean isFileNameChangeable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.naming.LogNameGenerator
 * JD-Core Version:    0.7.0.1
 */