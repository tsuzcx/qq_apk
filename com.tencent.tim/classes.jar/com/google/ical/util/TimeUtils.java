package com.google.ical.util;

import com.google.ical.values.DateTimeValue;
import com.google.ical.values.DateTimeValueImpl;
import com.google.ical.values.DateValue;
import com.google.ical.values.DateValueImpl;
import com.google.ical.values.TimeValue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtils
{
  private static final TimeZone BOGUS_TIMEZONE = TimeZone.getTimeZone("noSuchTimeZone");
  private static int[] MONTH_START_TO_DOY;
  private static final long SECS_PER_DAY = 86400L;
  private static final Pattern UTC_TZID = Pattern.compile("^GMT([+-]0(:00)?)?$|UTC|Zulu|Etc\\/GMT|Greenwich.*", 2);
  private static TimeZone ZULU;
  
  static
  {
    int j = 1;
    if (!TimeUtils.class.desiredAssertionStatus()) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      ZULU = new SimpleTimeZone(0, "Etc/GMT");
      MONTH_START_TO_DOY = new int[12];
      i = j;
      if ($assertionsDisabled) {
        break;
      }
      i = j;
      if (!isLeapYear(1970)) {
        break;
      }
      throw new AssertionError();
    }
    while (i < 12)
    {
      MONTH_START_TO_DOY[i] = (MONTH_START_TO_DOY[(i - 1)] + monthLength(1970, i));
      i += 1;
    }
    assert (365 == MONTH_START_TO_DOY[11] + monthLength(1970, 12)) : ("" + (MONTH_START_TO_DOY[11] + monthLength(1970, 12)));
  }
  
  public static DateValue add(DateValue paramDateValue1, DateValue paramDateValue2)
  {
    DTBuilder localDTBuilder = new DTBuilder(paramDateValue1);
    localDTBuilder.year += paramDateValue2.year();
    localDTBuilder.month += paramDateValue2.month();
    localDTBuilder.day += paramDateValue2.day();
    if ((paramDateValue2 instanceof TimeValue))
    {
      paramDateValue1 = (TimeValue)paramDateValue2;
      localDTBuilder.hour += paramDateValue1.hour();
      localDTBuilder.minute += paramDateValue1.minute();
      localDTBuilder.second += paramDateValue1.second();
      return localDTBuilder.toDateTime();
    }
    if ((paramDateValue1 instanceof TimeValue)) {
      return localDTBuilder.toDateTime();
    }
    return localDTBuilder.toDate();
  }
  
  private static DateTimeValue addSeconds(DateTimeValue paramDateTimeValue, int paramInt)
  {
    return new DTBuilder(paramDateTimeValue.year(), paramDateTimeValue.month(), paramDateTimeValue.day(), paramDateTimeValue.hour(), paramDateTimeValue.minute(), paramDateTimeValue.second() + paramInt).toDateTime();
  }
  
  private static DateTimeValue convert(DateTimeValue paramDateTimeValue, TimeZone paramTimeZone, int paramInt)
  {
    if ((paramTimeZone == null) || (paramTimeZone.hasSameRules(ZULU)) || (paramDateTimeValue.year() == 0)) {
      return paramDateTimeValue;
    }
    long l;
    int j;
    if (paramInt > 0)
    {
      l = timetMillisFromEpochSecs(secsSinceEpoch(paramDateTimeValue), ZULU);
      j = paramTimeZone.getOffset(l);
      if (j >= 0) {
        break label86;
      }
    }
    label86:
    for (int i = -500;; i = 500)
    {
      return addSeconds(paramDateTimeValue, (i + j) / 1000 * paramInt);
      l = timetMillisFromEpochSecs(secsSinceEpoch(paramDateTimeValue), paramTimeZone);
      break;
    }
  }
  
  public static int dayOfYear(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 > 2) && (isLeapYear(paramInt1))) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      return paramInt1 + MONTH_START_TO_DOY[(paramInt2 - 1)] + paramInt3 - 1;
    }
  }
  
  public static DateTimeValue dayStart(DateValue paramDateValue)
  {
    return new DateTimeValueImpl(paramDateValue.year(), paramDateValue.month(), paramDateValue.day(), 0, 0, 0);
  }
  
  public static int daysBetween(DateValue paramDateValue1, DateValue paramDateValue2)
  {
    return fixedFromGregorian(paramDateValue1) - fixedFromGregorian(paramDateValue2);
  }
  
  public static int fixedFromGregorian(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1 - 1;
    int j = i / 4;
    int k = i / 100;
    int m = i / 400;
    int n = (paramInt2 * 367 - 362) / 12;
    if (paramInt2 <= 2) {
      paramInt1 = 0;
    }
    for (;;)
    {
      return paramInt1 + (n + (m + (i * 365 + j - k))) + paramInt3;
      if (isLeapYear(paramInt1)) {
        paramInt1 = -1;
      } else {
        paramInt1 = -2;
      }
    }
  }
  
  private static int fixedFromGregorian(DateValue paramDateValue)
  {
    return fixedFromGregorian(paramDateValue.year(), paramDateValue.month(), paramDateValue.day());
  }
  
  public static DateTimeValue fromUtc(DateTimeValue paramDateTimeValue, TimeZone paramTimeZone)
  {
    return convert(paramDateTimeValue, paramTimeZone, 1);
  }
  
  public static DateValue fromUtc(DateValue paramDateValue, TimeZone paramTimeZone)
  {
    Object localObject = paramDateValue;
    if ((paramDateValue instanceof DateTimeValue)) {
      localObject = fromUtc((DateTimeValue)paramDateValue, paramTimeZone);
    }
    return localObject;
  }
  
  public static boolean isLeapYear(int paramInt)
  {
    return (paramInt % 4 == 0) && ((paramInt % 100 != 0) || (paramInt % 400 == 0));
  }
  
  public static int monthLength(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      throw new AssertionError(paramInt2);
    case 1: 
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    case 10: 
    case 12: 
      return 31;
    case 4: 
    case 6: 
    case 9: 
    case 11: 
      return 30;
    }
    if (isLeapYear(paramInt1)) {
      return 29;
    }
    return 28;
  }
  
  public static long secsSinceEpoch(DateValue paramDateValue)
  {
    long l2 = fixedFromGregorian(paramDateValue) * 86400L;
    long l1 = l2;
    if ((paramDateValue instanceof TimeValue))
    {
      paramDateValue = (TimeValue)paramDateValue;
      l1 = l2 + (paramDateValue.second() + (paramDateValue.minute() + paramDateValue.hour() * 60) * 60);
    }
    return l1;
  }
  
  public static DateTimeValue timeFromSecsSinceEpoch(long paramLong)
  {
    int k = (int)(paramLong % 86400L);
    int m = (int)(paramLong / 86400L);
    int i = (int)((m + 10) * 400L / 146097L);
    int j = i;
    if (m >= fixedFromGregorian(i + 1, 1, 1)) {
      j = i + 1;
    }
    int n = fixedFromGregorian(j, 1, 1);
    if (m < fixedFromGregorian(j, 3, 1)) {
      i = 0;
    }
    int i1;
    int i2;
    for (;;)
    {
      i = ((i + (m - n)) * 12 + 373) / 367;
      n = fixedFromGregorian(j, i, 1);
      i1 = k / 60;
      i2 = i1 / 60;
      if ((i2 >= 0) && (i2 < 24)) {
        break;
      }
      throw new AssertionError("Input was: " + paramLong + "to make hour: " + i2);
      if (isLeapYear(j)) {
        i = 1;
      } else {
        i = 2;
      }
    }
    return new DateTimeValueImpl(j, i, m - n + 1, i2, i1 % 60, k % 60);
  }
  
  public static TimeZone timeZoneForName(String paramString)
  {
    TimeZone localTimeZone2 = TimeZone.getTimeZone(paramString);
    TimeZone localTimeZone1 = localTimeZone2;
    if (localTimeZone2.hasSameRules(BOGUS_TIMEZONE))
    {
      if (UTC_TZID.matcher(paramString).matches()) {
        localTimeZone1 = utcTimezone();
      }
    }
    else {
      return localTimeZone1;
    }
    return null;
  }
  
  private static long timetMillisFromEpochSecs(long paramLong, TimeZone paramTimeZone)
  {
    DateTimeValue localDateTimeValue = timeFromSecsSinceEpoch(paramLong);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(paramTimeZone);
    localGregorianCalendar.clear();
    localGregorianCalendar.setTimeZone(paramTimeZone);
    localGregorianCalendar.set(localDateTimeValue.year(), localDateTimeValue.month() - 1, localDateTimeValue.day(), localDateTimeValue.hour(), localDateTimeValue.minute(), localDateTimeValue.second());
    return localGregorianCalendar.getTimeInMillis();
  }
  
  public static DateValue toDateValue(DateValue paramDateValue)
  {
    if (!(paramDateValue instanceof TimeValue)) {
      return paramDateValue;
    }
    return new DateValueImpl(paramDateValue.year(), paramDateValue.month(), paramDateValue.day());
  }
  
  public static DateValue toUtc(DateValue paramDateValue, TimeZone paramTimeZone)
  {
    Object localObject = paramDateValue;
    if ((paramDateValue instanceof TimeValue)) {
      localObject = convert((DateTimeValue)paramDateValue, paramTimeZone, -1);
    }
    return localObject;
  }
  
  public static TimeZone utcTimezone()
  {
    return ZULU;
  }
  
  public static int yearLength(int paramInt)
  {
    if (isLeapYear(paramInt)) {
      return 366;
    }
    return 365;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.util.TimeUtils
 * JD-Core Version:    0.7.0.1
 */