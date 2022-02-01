package org.apache.commons.lang3.time;

import java.text.FieldPosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract interface DatePrinter
{
  public abstract String format(long paramLong);
  
  public abstract String format(Calendar paramCalendar);
  
  public abstract String format(Date paramDate);
  
  public abstract StringBuffer format(long paramLong, StringBuffer paramStringBuffer);
  
  public abstract StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition);
  
  public abstract StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer);
  
  public abstract StringBuffer format(Date paramDate, StringBuffer paramStringBuffer);
  
  public abstract Locale getLocale();
  
  public abstract String getPattern();
  
  public abstract TimeZone getTimeZone();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.time.DatePrinter
 * JD-Core Version:    0.7.0.1
 */