package com.tencent.tbs.logger.file.naming;

import com.tencent.tbs.logger.LogItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateLogNameGenerator
  implements LogNameGenerator
{
  ThreadLocal<SimpleDateFormat> mLocalDateFormat = new DateLogNameGenerator.1(this);
  
  public String generateFileName(LogItem paramLogItem)
  {
    if (paramLogItem != null) {}
    for (long l = paramLogItem.timeMillis;; l = System.currentTimeMillis())
    {
      paramLogItem = (SimpleDateFormat)this.mLocalDateFormat.get();
      paramLogItem.setTimeZone(TimeZone.getDefault());
      return paramLogItem.format(new Date(l));
    }
  }
  
  public boolean isFileNameChangeable()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.logger.file.naming.DateLogNameGenerator
 * JD-Core Version:    0.7.0.1
 */