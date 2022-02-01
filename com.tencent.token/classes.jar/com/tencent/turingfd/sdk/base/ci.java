package com.tencent.turingfd.sdk.base;

import java.util.HashMap;

public class ci
{
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    return paramStringBuilder.toString();
  }
  
  public static StringBuilder a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    return localStringBuilder;
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