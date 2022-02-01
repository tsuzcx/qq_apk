package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract interface DateParser
{
  public abstract Locale getLocale();
  
  public abstract String getPattern();
  
  public abstract TimeZone getTimeZone();
  
  public abstract Date parse(String paramString)
    throws ParseException;
  
  public abstract Date parse(String paramString, ParsePosition paramParsePosition);
  
  public abstract Object parseObject(String paramString)
    throws ParseException;
  
  public abstract Object parseObject(String paramString, ParsePosition paramParsePosition);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.time.DateParser
 * JD-Core Version:    0.7.0.1
 */