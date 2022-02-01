package com.tencent.tpns.baseapi.base.util;

import java.util.HashMap;

public class MemoryCacheManager
{
  private static volatile HashMap<Object, Object> a = new HashMap(10);
  
  public static boolean containsKey(Object paramObject)
  {
    return a.containsKey(paramObject);
  }
  
  public static Object get(Object paramObject)
  {
    try
    {
      paramObject = a.get(paramObject);
      return paramObject;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
  
  public static void put(Object paramObject1, Object paramObject2)
  {
    try
    {
      a.put(paramObject1, paramObject2);
      return;
    }
    finally
    {
      paramObject1 = finally;
      throw paramObject1;
    }
  }
  
  public static Object remove(Object paramObject)
  {
    try
    {
      paramObject = a.remove(paramObject);
      return paramObject;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.MemoryCacheManager
 * JD-Core Version:    0.7.0.1
 */