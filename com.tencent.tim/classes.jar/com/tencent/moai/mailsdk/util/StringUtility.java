package com.tencent.moai.mailsdk.util;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class StringUtility
{
  private static SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss ", Locale.US);
  
  public static String addQuote(String paramString)
  {
    String str = paramString;
    if (!isNullOrEmpty(paramString)) {
      str = "\"" + paramString + "\"";
    }
    return str;
  }
  
  public static String formatDate(Date paramDate)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      synchronized (df)
      {
        df.format(paramDate, localStringBuffer, new FieldPosition(0));
        int i = TimeZone.getDefault().getOffset(paramDate.getTime()) / 60 / 1000;
        if (i < 0)
        {
          localStringBuffer.append('-');
          i = -i;
          int j = i / 60;
          i %= 60;
          localStringBuffer.append(Character.forDigit(j / 10, 10));
          localStringBuffer.append(Character.forDigit(j % 10, 10));
          localStringBuffer.append(Character.forDigit(i / 10, 10));
          localStringBuffer.append(Character.forDigit(i % 10, 10));
          return localStringBuffer.toString();
        }
      }
      localStringBuffer.append('+');
    }
  }
  
  public static String getDomain(String paramString)
  {
    String str = paramString;
    if (!isNullOrEmpty(paramString))
    {
      int i = paramString.indexOf("@");
      str = paramString;
      if (i != -1) {
        str = paramString.substring(i + 1, paramString.length());
      }
    }
    return str;
  }
  
  public static String htmlEncode(String paramString)
  {
    if (!isNullOrEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (i < paramString.length())
      {
        switch (paramString.charAt(i))
        {
        default: 
          localStringBuilder.append(paramString.charAt(i));
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append("&amp;");
          continue;
          localStringBuilder.append("&quot;");
          continue;
          localStringBuilder.append("&apos;");
          continue;
          localStringBuilder.append("&lt;");
          continue;
          localStringBuilder.append("&gt;");
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isTrimEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0) || (paramString.trim().length() == 0);
  }
  
  public static String removeQuote(String paramString)
  {
    String str = paramString;
    if (!isNullOrEmpty(paramString))
    {
      int i = paramString.indexOf("\"");
      str = paramString;
      if (i == 0)
      {
        int j = paramString.indexOf("\"", i + 1);
        str = paramString;
        if (j == paramString.length() - 1) {
          str = paramString.substring(i + 1, j);
        }
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.StringUtility
 * JD-Core Version:    0.7.0.1
 */