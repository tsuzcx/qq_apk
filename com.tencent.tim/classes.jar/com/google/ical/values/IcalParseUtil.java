package com.google.ical.values;

import com.google.ical.util.DTBuilder;
import com.google.ical.util.TimeUtils;
import java.text.ParseException;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IcalParseUtil
{
  private static final Pattern DATE_VALUE = Pattern.compile("(\\d{4,})(\\d\\d)(\\d\\d)(?:T([0-1]\\d|2[0-3])([0-5]\\d)([0-5]\\d)(Z)?)?");
  private static final Pattern IGNORABLE_ICAL_WHITESPACE = Pattern.compile("(?:\\r\\n?|\\n)[ \t]");
  
  public static DateValue parseDateValue(String paramString)
    throws ParseException
  {
    return parseDateValue(paramString, null);
  }
  
  public static DateValue parseDateValue(String paramString, TimeZone paramTimeZone)
    throws ParseException
  {
    int i = 0;
    Object localObject = DATE_VALUE.matcher(paramString);
    if (!((Matcher)localObject).matches()) {
      throw new ParseException(paramString, 0);
    }
    int j = Integer.parseInt(((Matcher)localObject).group(1));
    int k = Integer.parseInt(((Matcher)localObject).group(2));
    int m = Integer.parseInt(((Matcher)localObject).group(3));
    if (((Matcher)localObject).group(4) != null)
    {
      int n = Integer.parseInt(((Matcher)localObject).group(4));
      int i1 = Integer.parseInt(((Matcher)localObject).group(5));
      int i2 = Integer.parseInt(((Matcher)localObject).group(6));
      if (((Matcher)localObject).group(7) != null) {
        i = 1;
      }
      localObject = new DTBuilder(j, k, m, n, i1, i2).toDateTime();
      paramString = (String)localObject;
      if (i == 0)
      {
        paramString = (String)localObject;
        if (paramTimeZone != null) {
          paramString = TimeUtils.toUtc((DateValue)localObject, paramTimeZone);
        }
      }
      return paramString;
    }
    return new DTBuilder(j, k, m).toDate();
  }
  
  public static PeriodValue parsePeriodValue(String paramString)
    throws ParseException
  {
    return parsePeriodValue(paramString, null);
  }
  
  public static PeriodValue parsePeriodValue(String paramString, TimeZone paramTimeZone)
    throws ParseException
  {
    int i = paramString.indexOf('/');
    if (i < 0) {
      throw new ParseException(paramString, paramString.length());
    }
    DateValue localDateValue = parseDateValue(paramString.substring(0, i), paramTimeZone);
    paramTimeZone = parseDateValue(paramString.substring(i + 1), paramTimeZone);
    if (localDateValue instanceof TimeValue != paramTimeZone instanceof TimeValue) {
      throw new ParseException(paramString, 0);
    }
    try
    {
      paramTimeZone = PeriodValueImpl.create(localDateValue, paramTimeZone);
      return paramTimeZone;
    }
    catch (IllegalArgumentException paramTimeZone)
    {
      throw ((ParseException)new ParseException(paramString, i + 1).initCause(paramTimeZone));
    }
  }
  
  public static String unfoldIcal(String paramString)
  {
    return IGNORABLE_ICAL_WHITESPACE.matcher(paramString).replaceAll("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.IcalParseUtil
 * JD-Core Version:    0.7.0.1
 */