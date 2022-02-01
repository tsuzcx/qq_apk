package com.google.ical.compat.jodatime;

import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.joda.time.DateTimeZone;

final class TimeZoneConverter
{
  private static final Pattern HOUR_MINUTE = Pattern.compile("^[+-]?[0-9]{1,2}:[0-9]{2}(:[0-9]{2})?$");
  static final int MILLISECONDS_PER_HOUR = 3600000;
  static final int MILLISECONDS_PER_MINUTE = 60000;
  static final int MILLISECONDS_PER_SECOND = 1000;
  private static final long MILLIS_SINCE_1_JAN_2000_UTC;
  private static final TimeZone UTC = new SimpleTimeZone(0, "UTC");
  
  static
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(UTC);
    localGregorianCalendar.set(2000, 0, 1, 0, 0, 0);
    MILLIS_SINCE_1_JAN_2000_UTC = localGregorianCalendar.getTimeInMillis();
  }
  
  static String cleanUpTzid(String paramString)
  {
    String str = paramString;
    StringBuilder localStringBuilder;
    if (HOUR_MINUTE.matcher(paramString).matches())
    {
      localStringBuilder = new StringBuilder().append("GMT");
      if ((!paramString.startsWith("-")) && (!paramString.startsWith("+"))) {
        break label64;
      }
    }
    label64:
    for (str = "";; str = "+")
    {
      str = str + paramString;
      return str;
    }
  }
  
  public static TimeZone toTimeZone(DateTimeZone paramDateTimeZone)
  {
    TimeZoneConverter.1 local1 = new TimeZoneConverter.1(paramDateTimeZone);
    local1.setID(cleanUpTzid(paramDateTimeZone.getID()));
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.jodatime.TimeZoneConverter
 * JD-Core Version:    0.7.0.1
 */