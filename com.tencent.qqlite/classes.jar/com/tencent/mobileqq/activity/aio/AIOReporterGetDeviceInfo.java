package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class AIOReporterGetDeviceInfo
{
  private static AIOReporterGetDeviceInfo a;
  public String a;
  public boolean a;
  public String b = "LowLevelDevice";
  private String c = "";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo = null;
  }
  
  private AIOReporterGetDeviceInfo()
  {
    this.jdField_a_of_type_JavaLangString = "HighLevelDevice";
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public static AIOReporterGetDeviceInfo a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo	Lcom/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo;
    //   6: ifnonnull +22 -> 28
    //   9: new 2	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo
    //   12: dup
    //   13: invokespecial 34	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:<init>	()V
    //   16: putstatic 14	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo	Lcom/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo;
    //   19: getstatic 14	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo	Lcom/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo;
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: getstatic 14	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_ComTencentMobileqqActivityAioAIOReporterGetDeviceInfo	Lcom/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo;
    //   31: iconst_0
    //   32: putfield 28	com/tencent/mobileqq/activity/aio/AIOReporterGetDeviceInfo:jdField_a_of_type_Boolean	Z
    //   35: goto -16 -> 19
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	5	0	localAIOReporterGetDeviceInfo	AIOReporterGetDeviceInfo
    //   38	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	38	finally
    //   19	23	38	finally
    //   28	35	38	finally
  }
  
  public String a()
  {
    if ("".equals(this.c)) {
      if ((DeviceInfoUtil.c() >>> 20 <= 900L) || (DeviceInfoUtil.b() <= 2) || (DeviceInfoUtil.a() <= 1150L)) {
        break label55;
      }
    }
    label55:
    for (this.c = this.jdField_a_of_type_JavaLangString;; this.c = this.b) {
      return this.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOReporterGetDeviceInfo
 * JD-Core Version:    0.7.0.1
 */