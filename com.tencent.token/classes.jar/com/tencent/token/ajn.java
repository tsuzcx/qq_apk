package com.tencent.token;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class ajn
{
  private static final ThreadLocal<DateFormat> a = new ThreadLocal() {};
  private static final String[] b = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
  private static final DateFormat[] c = new DateFormat[15];
  
  public static String a(Date paramDate)
  {
    return ((DateFormat)a.get()).format(paramDate);
  }
  
  public static Date a(String paramString)
  {
    if (paramString.length() == 0) {
      return null;
    }
    ParsePosition localParsePosition = new ParsePosition(0);
    Object localObject = ((DateFormat)a.get()).parse(paramString, localParsePosition);
    if (localParsePosition.getIndex() == paramString.length()) {
      return localObject;
    }
    for (;;)
    {
      int i;
      synchronized (b)
      {
        int j = b.length;
        i = 0;
        if (i < j)
        {
          DateFormat localDateFormat = c[i];
          localObject = localDateFormat;
          if (localDateFormat == null)
          {
            localObject = new SimpleDateFormat(b[i], Locale.US);
            ((DateFormat)localObject).setTimeZone(aix.g);
            c[i] = localObject;
          }
          localParsePosition.setIndex(0);
          localObject = ((DateFormat)localObject).parse(paramString, localParsePosition);
          if (localParsePosition.getIndex() != 0) {
            return localObject;
          }
        }
        else
        {
          return null;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajn
 * JD-Core Version:    0.7.0.1
 */