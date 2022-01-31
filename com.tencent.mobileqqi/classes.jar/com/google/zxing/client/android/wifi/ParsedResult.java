package com.google.zxing.client.android.wifi;

import android.text.TextUtils;

public abstract class ParsedResult
{
  private final ParsedResultType a;
  
  protected ParsedResult(ParsedResultType paramParsedResultType)
  {
    this.a = paramParsedResultType;
  }
  
  public static void a(String paramString, StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append('\n');
      }
      paramStringBuilder.append(paramString);
    }
  }
  
  public static void a(String[] paramArrayOfString, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        a(paramArrayOfString[i], paramStringBuilder);
        i += 1;
      }
    }
  }
  
  public final ParsedResultType a()
  {
    return this.a;
  }
  
  public abstract String a();
  
  public final String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.google.zxing.client.android.wifi.ParsedResult
 * JD-Core Version:    0.7.0.1
 */