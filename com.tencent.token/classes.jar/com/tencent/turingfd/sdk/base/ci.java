package com.tencent.turingfd.sdk.base;

import java.util.HashMap;

public class ci
{
  public static String a(String paramString, int paramInt)
  {
    return paramString + paramInt;
  }
  
  public static String a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public static StringBuilder a(String paramString)
  {
    return new StringBuilder().append(paramString);
  }
  
  public static void a(HashMap paramHashMap, Object paramObject1, Object paramObject2, long paramLong, int paramInt)
  {
    paramHashMap.put(paramObject1, paramObject2);
    bi.a(paramInt, System.currentTimeMillis() - paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ci
 * JD-Core Version:    0.7.0.1
 */