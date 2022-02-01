package com.tencent.qqmail.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSTagFilter
{
  public static final String TAG = XSSTagFilter.class.getSimpleName();
  
  public static String removeDataTextHtml(String paramString)
  {
    System.currentTimeMillis();
    String str2 = paramString.toLowerCase();
    Object localObject = paramString;
    if (str2.indexOf("data:text/html") >= 0)
    {
      String str1 = paramString;
      if (str2.indexOf("<object") > 0) {
        str1 = Pattern.compile("<object[^>]*data:text/html;base64,", 2).matcher(paramString).replaceAll("<object ");
      }
      localObject = str1;
      if (str2.indexOf("<meta") > 0) {
        localObject = Pattern.compile("<meta[^>]*data:text/html", 2).matcher(str1).replaceAll("<meta ");
      }
    }
    paramString = (String)localObject;
    if (str2.indexOf("<marquee") >= 0) {
      paramString = Pattern.compile("<marquee[^>]*>", 2).matcher((CharSequence)localObject).replaceAll("");
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.XSSTagFilter
 * JD-Core Version:    0.7.0.1
 */