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
    if ((paramString != null) && (paramString.startsWith("~SEMI_XML~")))
    {
      String str1 = paramString.substring(10);
      paramString = new HashMap();
      int i = 0;
      int j = str1.length();
      for (;;)
      {
        if (i < j - 4)
        {
          int k = i + 1;
          try
          {
            int m = str1.charAt(i);
            i = k + 1;
            k = (m << 16) + str1.charAt(k) + i;
            String str2 = str1.substring(i, k);
            i = k + 1;
            m = str1.charAt(k);
            k = i + 1;
            i = (m << 16) + str1.charAt(i) + k;
            paramString.put(str2, str1.substring(k, i));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      return paramString;
    }
    return null;
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
        localStringBuilder.append((char)(i >> 16));
        localStringBuilder.append((char)i);
        localStringBuilder.append(str);
        localStringBuilder.append((char)(j >> 16));
        localStringBuilder.append((char)j);
        localStringBuilder.append((String)localObject);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SemiXml
 * JD-Core Version:    0.7.0.1
 */