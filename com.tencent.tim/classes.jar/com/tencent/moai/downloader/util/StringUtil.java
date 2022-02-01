package com.tencent.moai.downloader.util;

import com.tencent.moai.downloader.network.HttpParam;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class StringUtil
{
  private static String decodeURI(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = new String(paramString);
    try
    {
      str = urlDecode(str).replaceAll("%26", "&");
      return str;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    if (paramString == null) {}
    while ("".equals(paramString)) {
      return true;
    }
    return false;
  }
  
  public static List<HttpParam> parseParams(String paramString1, String paramString2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return localArrayList;
    }
    if ((paramString2 == null) || (paramString2.equals(""))) {
      return localArrayList;
    }
    String[] arrayOfString = paramString1.split(paramString2);
    int i = 0;
    while (i < arrayOfString.length)
    {
      paramString2 = arrayOfString[i];
      if ((paramString2 != null) && (!paramString2.equals("")))
      {
        int j = paramString2.indexOf('=');
        if (j > 0)
        {
          String str = paramString2.substring(0, j);
          paramString1 = "";
          if (j + 1 < paramString2.length()) {
            paramString1 = paramString2.substring(j + 1, paramString2.length());
          }
          paramString2 = paramString1;
          if (paramBoolean) {
            paramString2 = decodeURI(paramString1);
          }
          localArrayList.add(new HttpParam(str, paramString2));
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<HttpParam> parseParams(String paramString, boolean paramBoolean)
  {
    return parseParams(paramString, "&", paramBoolean);
  }
  
  private static String urlDecode(String paramString)
    throws UnsupportedEncodingException
  {
    String str = paramString;
    if (paramString != null) {
      str = URLDecoder.decode(paramString, "utf-8");
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.util.StringUtil
 * JD-Core Version:    0.7.0.1
 */