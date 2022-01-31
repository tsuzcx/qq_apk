package com.tencent.util;

import android.os.SystemClock;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TimeCostTrace
{
  public static final String a = "qzone_launch";
  public static HashMap a;
  private static final boolean jdField_a_of_type_Boolean = false;
  private long jdField_a_of_type_Long = 0L;
  private Map jdField_a_of_type_JavaUtilMap;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString;
  
  private TimeCostTrace(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private static long a()
  {
    return SystemClock.uptimeMillis();
  }
  
  public static TimeCostTrace a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    TimeCostTrace localTimeCostTrace2 = (TimeCostTrace)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    TimeCostTrace localTimeCostTrace1 = localTimeCostTrace2;
    if (localTimeCostTrace2 == null)
    {
      localTimeCostTrace1 = new TimeCostTrace(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localTimeCostTrace1);
    }
    return localTimeCostTrace1;
  }
  
  public static void c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null) {}
    TimeCostTrace localTimeCostTrace;
    do
    {
      return;
      localTimeCostTrace = (TimeCostTrace)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    } while (localTimeCostTrace == null);
    localTimeCostTrace.b();
    jdField_a_of_type_JavaUtilHashMap.remove(paramString);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_Long <= 0L)) {
      return -1;
    }
    int i = (int)(a() - this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
    return i;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() <= 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int[] arrayOfInt = (int[])this.jdField_a_of_type_JavaUtilMap.get(str);
      if (arrayOfInt != null)
      {
        localStringBuilder.append(str).append(":");
        if (arrayOfInt.length > 0)
        {
          localStringBuilder.append(arrayOfInt[0]);
          localStringBuilder.append(",");
        }
        if (arrayOfInt.length > 1) {
          localStringBuilder.append(arrayOfInt[1]);
        }
        localStringBuilder.append(";");
      }
    }
    return localStringBuilder.substring(0, localStringBuilder.length() - 1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = a();
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_Long <= 0L)) {
      return;
    }
    int i = (int)(a() - this.jdField_a_of_type_Long);
    int[] arrayOfInt2 = (int[])this.jdField_a_of_type_JavaUtilMap.get(paramString);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null)
    {
      arrayOfInt1 = new int[2];
      this.jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfInt1);
    }
    arrayOfInt1[0] = i;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap = null;
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_Long <= 0L)) {
      return;
    }
    int i = (int)(a() - this.jdField_a_of_type_Long);
    int[] arrayOfInt2 = (int[])this.jdField_a_of_type_JavaUtilMap.get(paramString);
    int[] arrayOfInt1 = arrayOfInt2;
    if (arrayOfInt2 == null)
    {
      arrayOfInt1 = new int[2];
      this.jdField_a_of_type_JavaUtilMap.put(paramString, arrayOfInt1);
    }
    arrayOfInt1[1] = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.util.TimeCostTrace
 * JD-Core Version:    0.7.0.1
 */