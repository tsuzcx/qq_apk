package com.huawei.updatesdk.a.a.c;

import java.util.List;

public class e
{
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String a(List<String> paramList, String paramString)
  {
    return a(paramList, paramString, (String)null, (String)null);
  }
  
  public static String a(List<String> paramList, String paramString1, String paramString2, String paramString3)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return a((String[])paramList.toArray(new String[0]), paramString1, paramString2, paramString3);
    }
    return "";
  }
  
  public static String a(String[] paramArrayOfString, String paramString)
  {
    return a((String[])paramArrayOfString, paramString, (String)null, (String)null);
  }
  
  public static String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      paramString1 = a(paramString1);
      paramString2 = a(paramString2);
      paramString3 = a(paramString3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2).append(paramArrayOfString[0]).append(paramString3);
      int i = 1;
      while (i < paramArrayOfString.length)
      {
        localStringBuilder.append(paramString1);
        localStringBuilder.append(paramString2).append(paramArrayOfString[i]).append(paramString3);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.e
 * JD-Core Version:    0.7.0.1
 */