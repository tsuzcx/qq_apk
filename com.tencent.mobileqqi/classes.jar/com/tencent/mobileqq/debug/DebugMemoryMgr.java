package com.tencent.mobileqq.debug;

import android.content.Context;
import android.util.Pair;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import fnr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DebugMemoryMgr
{
  private static final byte jdField_a_of_type_Byte = 1;
  private static final long jdField_a_of_type_Long = 1048576L;
  private static DebugMemoryMgr jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr = null;
  public static final String a = "MemoryAlertAutoClear";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  public static List a;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static final ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  public static boolean a = false;
  private static final byte jdField_b_of_type_Byte = 2;
  private static final long jdField_b_of_type_Long = 41943040L;
  private static final String jdField_b_of_type_JavaLangString = "Q.Memory.DebugMemoryMgr";
  private static List jdField_b_of_type_JavaUtilList = null;
  private static boolean jdField_b_of_type_Boolean = false;
  private static final byte jdField_c_of_type_Byte = 3;
  private static final long jdField_c_of_type_Long = 5242880L;
  private static List jdField_c_of_type_JavaUtilList;
  private static final byte jdField_d_of_type_Byte = 4;
  private static long jdField_d_of_type_Long = 0L;
  private static List jdField_d_of_type_JavaUtilList;
  private static final byte e = 5;
  
  static
  {
    c = null;
    jdField_d_of_type_JavaUtilList = null;
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    jdField_d_of_type_Long = 0L;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static DebugMemoryMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr == null) {
        jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr = new DebugMemoryMgr();
      }
      return jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr;
    }
    finally {}
  }
  
  public static String a()
  {
    try
    {
      String str = jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.toString();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private static String a(BaseActivity paramBaseActivity)
  {
    return String.format("%s@%x", new Object[] { paramBaseActivity.getClass().getSimpleName(), Integer.valueOf(paramBaseActivity.hashCode()) });
  }
  
  public static ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        fnr localfnr = (fnr)((Map.Entry)localIterator.next()).getValue();
        if ((localfnr != null) && (fnr.a(localfnr) >= 5242880L)) {
          localArrayList.add(Pair.create(fnr.a(localfnr), Long.valueOf(fnr.a(localfnr))));
        }
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_JavaUtilMap != null)) {
      jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public static void a(BaseActivity paramBaseActivity)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(a(paramBaseActivity));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity instanceof SplashActivity)) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramString);
  }
  
  public static void b(Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public static void b(BaseActivity paramBaseActivity) {}
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public static void c(BaseActivity paramBaseActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.debug.DebugMemoryMgr
 * JD-Core Version:    0.7.0.1
 */