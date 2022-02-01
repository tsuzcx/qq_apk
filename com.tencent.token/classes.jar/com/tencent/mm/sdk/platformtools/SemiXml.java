package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SemiXml
{
  public static final String MAGIC_HEAD = "~SEMI_XML~";
  
  public static Map<String, String> decode(String paramString)
  {
    if ((paramString == null) || (!paramString.startsWith("~SEMI_XML~")))
    {
      paramString = null;
      return paramString;
    }
    String str = paramString.substring(10);
    HashMap localHashMap = new HashMap();
    int i = 0;
    int j = str.length();
    for (;;)
    {
      paramString = localHashMap;
      if (i >= j - 4) {
        break;
      }
      int k = i + 1;
      try
      {
        int m = str.charAt(i);
        i = k + 1;
        k = (m << 16) + str.charAt(k) + i;
        paramString = str.substring(i, k);
        i = k + 1;
        m = str.charAt(k);
        k = i + 1;
        i = (m << 16) + str.charAt(i) + k;
        localHashMap.put(paramString, str.substring(k, i));
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return localHashMap;
  }
  
  public static String encode(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("~SEMI_XML~");
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (localObject != null)
      {
        int i = str.length();
        int j = ((String)localObject).length();
        localStringBuilder.append((char)(i >> 16)).append((char)i).append(str);
        localStringBuilder.append((char)(j >> 16)).append((char)j).append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SemiXml
 * JD-Core Version:    0.7.0.1
 */