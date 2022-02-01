package com.tencent.turingfd.sdk.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class bi
{
  public static Map<Integer, Long> a = new HashMap();
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = a.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      localStringBuilder.append(",");
      localStringBuilder.append(i);
      localStringBuilder.append("_");
      localStringBuilder.append(a.get(Integer.valueOf(i)));
    }
    return localStringBuilder.toString();
  }
  
  public static void a(int paramInt, long paramLong)
  {
    a.put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bi
 * JD-Core Version:    0.7.0.1
 */