package com.tencent.util;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public abstract class URLUtil
{
  public static final String a = "http://";
  public static final String b = "https://";
  
  public static int a(Map paramMap, String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt((String)paramMap.get(paramString));
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  public static String a(Map paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  public static String a(Map paramMap, String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)paramMap.get(paramString1);
      paramMap = paramString1;
      if (paramString1 == null) {
        paramMap = "";
      }
      return paramMap;
    }
    catch (Exception paramMap) {}
    return paramString2;
  }
  
  public static Map a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      int i = paramString.indexOf("?");
      localObject1 = localObject2;
      if (-1 != i) {
        localObject1 = b(paramString.substring(i + 1));
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = new HashMap();
    }
    return paramString;
  }
  
  public static Map b(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        paramString = paramString.split("&");
        int j = paramString.length;
        if (i < j)
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString == null) || (arrayOfString.length != 2)) {
            break label72;
          }
          localHashMap.put(arrayOfString[0], URLDecoder.decode(arrayOfString[1]));
        }
      }
      catch (Exception paramString) {}
      return localHashMap;
      label72:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.util.URLUtil
 * JD-Core Version:    0.7.0.1
 */