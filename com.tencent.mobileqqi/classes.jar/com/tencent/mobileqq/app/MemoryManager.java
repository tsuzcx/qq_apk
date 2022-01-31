package com.tencent.mobileqq.app;

import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class MemoryManager
{
  private static final long jdField_a_of_type_Long = 1048576L;
  private static MemoryManager jdField_a_of_type_ComTencentMobileqqAppMemoryManager;
  public static final String a = "com.tencent.process.exit";
  private static long jdField_b_of_type_Long = 0L;
  private static final String jdField_b_of_type_JavaLangString = "Q.Memory.MemoryManager";
  
  static
  {
    a = null;
    b = 0L;
  }
  
  public static long a()
  {
    if (b > 0L) {
      return b;
    }
    long l1 = DeviceInfoUtil.c();
    long l2 = DeviceInfoUtil.d();
    long l3 = (3L * l1 + 7L * l2) / 10L;
    long l4 = DeviceInfoUtil.e();
    if (l3 <= 157286400L) {
      b = Math.min(25165824L, l4);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + b / 1048576L + "M, totalMemSize=" + l1 / 1048576L + "M, remainMemSize=" + l2 / 1048576L + "M, availMemSize=" + l3 / 1048576L + "M, classMemSize=" + l4 / 1048576L + "M");
      }
      return b;
      if (l3 <= 262144000L) {
        b = Math.min(37748736L, l4);
      } else if (l3 <= 419430400L) {
        b = Math.min(67108864L, l4);
      } else if (l3 <= 524288000L) {
        b = Math.min(134217728L, l4);
      } else {
        b = Math.min(268435456L, l4);
      }
    }
  }
  
  public static MemoryManager a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new MemoryManager();
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MemoryManager
 * JD-Core Version:    0.7.0.1
 */