package com.huawei.hms.push.c;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class b
{
  public static long a(String paramString)
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    String str = paramString.substring(0, paramString.indexOf("."));
    paramString = paramString.substring(paramString.indexOf("."));
    paramString = paramString.substring(0, 4) + "Z";
    return localSimpleDateFormat.parse(str + paramString).getTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.push.c.b
 * JD-Core Version:    0.7.0.1
 */