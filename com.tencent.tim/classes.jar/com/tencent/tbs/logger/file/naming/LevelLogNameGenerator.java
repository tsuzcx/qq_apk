package com.tencent.tbs.logger.file.naming;

import com.tencent.tbs.logger.LogItem;
import com.tencent.tbs.logger.LogLevel;

public class LevelLogNameGenerator
  implements LogNameGenerator
{
  public String generateFileName(LogItem paramLogItem)
  {
    if ((paramLogItem != null) && (paramLogItem.level != null)) {
      return paramLogItem.level.name();
    }
    return "";
  }
  
  public boolean isFileNameChangeable()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.naming.LevelLogNameGenerator
 * JD-Core Version:    0.7.0.1
 */