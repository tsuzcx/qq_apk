package com.tencent.mobileqq.activity.aio;

import bsj;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class AIOTimeReporter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  private long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString = "AIOTimeReporter";
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = 0L;
  private boolean jdField_c_of_type_Boolean = false;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  
  private HashMap a(LinkedList paramLinkedList)
  {
    HashMap localHashMap1 = new HashMap();
    if (paramLinkedList == null) {
      return null;
    }
    HashMap localHashMap2;
    Object localObject2;
    Object localObject1;
    int i;
    for (;;)
    {
      try
      {
        localHashMap2 = new HashMap();
        paramLinkedList = paramLinkedList.iterator();
        if (!paramLinkedList.hasNext()) {
          break;
        }
        localObject2 = ((String)paramLinkedList.next()).split("_");
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        if (localHashMap2.containsKey(localObject1))
        {
          String[] arrayOfString = ((String)localHashMap2.get(localObject1)).split("_");
          i = Integer.parseInt(arrayOfString[0]);
          long l1 = Long.parseLong(arrayOfString[1]);
          long l2 = Long.parseLong((String)localObject2);
          localHashMap2.remove(localObject1);
          localHashMap2.put(localObject1, "" + (i + 1) + "_" + (l1 + l2));
        }
        else
        {
          localHashMap2.put(localObject1, "1_" + (String)localObject2);
        }
      }
      catch (Exception paramLinkedList)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AutoMonitor", 4, paramLinkedList.toString());
        }
        return null;
      }
    }
    paramLinkedList = localHashMap2.keySet().iterator();
    while (paramLinkedList.hasNext())
    {
      localObject1 = (String)paramLinkedList.next();
      localObject2 = ((String)localHashMap2.get(localObject1)).split("_");
      i = Integer.parseInt(localObject2[0]);
      double d1 = Long.parseLong(localObject2[1]) / i;
      localHashMap1.put("getview" + (String)localObject1, "" + d1);
    }
    return localHashMap1;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    if (new Random().nextInt(100) != 1) {
      return;
    }
    ThreadManager.a(new bsj(this));
  }
  
  public void a(int paramInt)
  {
    long l;
    if (!this.jdField_b_of_type_Boolean) {
      l = System.currentTimeMillis();
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Long = l;
      return;
    case 1: 
      this.jdField_b_of_type_Long = l;
      return;
    case 2: 
      this.jdField_c_of_type_Long = l;
      return;
    case 3: 
      this.d = l;
      return;
    case 4: 
      this.e = l;
      return;
    case 5: 
      this.f = l;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.g = l;
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilLinkedList.add("" + paramInt + "_" + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter
 * JD-Core Version:    0.7.0.1
 */