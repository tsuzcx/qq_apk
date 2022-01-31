package com.tencent.open.appcommon.js;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MemCache
{
  protected static int a;
  protected static ConcurrentHashMap a;
  protected static int b = 100;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_Int = 2000;
  }
  
  public static String a(String paramString)
  {
    return (String)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Iterator localIterator;
    int i;
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= jdField_a_of_type_Int)
    {
      localIterator = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      i = 0;
    }
    for (;;)
    {
      String str;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (i < b) {}
      }
      else
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
        return;
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.appcommon.js.MemCache
 * JD-Core Version:    0.7.0.1
 */