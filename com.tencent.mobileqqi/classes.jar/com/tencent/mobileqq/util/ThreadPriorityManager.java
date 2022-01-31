package com.tencent.mobileqq.util;

import android.os.Handler;
import android.os.Looper;
import com.tencent.util.LongSparseArray;
import hbe;

public class ThreadPriorityManager
{
  private static final int jdField_a_of_type_Int = 1;
  private static final long jdField_a_of_type_Long = 7000L;
  private static Handler jdField_a_of_type_AndroidOsHandler = new hbe(Looper.getMainLooper());
  private static LongSparseArray jdField_a_of_type_ComTencentUtilLongSparseArray;
  private static final int b = 2;
  private static int c = 1;
  
  static
  {
    jdField_a_of_type_ComTencentUtilLongSparseArray = new LongSparseArray(40);
  }
  
  public static void a(boolean paramBoolean)
  {
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localHandler.sendEmptyMessage(i);
      return;
    }
  }
  
  private static Thread[] a()
  {
    ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup();
    Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
    localThreadGroup.enumerate(arrayOfThread);
    return arrayOfThread;
  }
  
  private static void c()
  {
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 7000L);
    if (jdField_a_of_type_ComTencentUtilLongSparseArray.a() > 0) {}
    for (;;)
    {
      return;
      Thread[] arrayOfThread = a();
      if (arrayOfThread.length < 2)
      {
        jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        return;
      }
      int j = arrayOfThread.length;
      int i = 0;
      while (i < j)
      {
        Thread localThread = arrayOfThread[i];
        if ((localThread != null) && (localThread.getId() != 1L) && (localThread.isAlive()))
        {
          jdField_a_of_type_ComTencentUtilLongSparseArray.a(localThread.getId(), Integer.valueOf(localThread.getPriority()));
          localThread.setPriority(c);
        }
        i += 1;
      }
    }
  }
  
  private static void d()
  {
    if (jdField_a_of_type_ComTencentUtilLongSparseArray.a() <= 0) {
      return;
    }
    Thread[] arrayOfThread = a();
    int j = arrayOfThread.length;
    int i = 0;
    while (i < j)
    {
      Thread localThread = arrayOfThread[i];
      if ((localThread != null) && (localThread.isAlive()))
      {
        int k = ((Integer)jdField_a_of_type_ComTencentUtilLongSparseArray.a(localThread.getId(), Integer.valueOf(0))).intValue();
        if (k != 0) {
          localThread.setPriority(k);
        }
      }
      i += 1;
    }
    jdField_a_of_type_ComTencentUtilLongSparseArray.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.ThreadPriorityManager
 * JD-Core Version:    0.7.0.1
 */