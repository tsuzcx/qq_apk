package com.tencent.tbs.logger.file.naming;

import com.tencent.tbs.logger.LogItem;

public class FixedLogNameGenerator
  implements LogNameGenerator
{
  private final String fileName;
  
  public FixedLogNameGenerator(String paramString)
  {
    this.fileName = paramString;
  }
  
  public String generateFileName(LogItem paramLogItem)
  {
    return this.fileName;
  }
  
  public boolean isFileNameChangeable()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.naming.FixedLogNameGenerator
 * JD-Core Version:    0.7.0.1
 */