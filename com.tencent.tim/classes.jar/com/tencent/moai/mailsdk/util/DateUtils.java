package com.tencent.moai.mailsdk.util;

import com.tencent.moai.mailsdk.util.log.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils
{
  public static final int DAYS_MILLis = 86400000;
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
  
  public static String formatTime(long paramLong)
  {
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    try
    {
      String str = sdf.format(new Date(paramLong)) + ".000Z";
      return str;
    }
    catch (Exception localException)
    {
      Logger.log(6, "MailParser", "format time error ");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.DateUtils
 * JD-Core Version:    0.7.0.1
 */