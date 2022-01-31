package com.tencent.mobileqq.utils;

public class PTTAgcWrapper
{
  private static PTTAgcWrapper jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper = null;
  private static boolean jdField_a_of_type_Boolean = false;
  
  private PTTAgcWrapper()
  {
    PTTAGCCreateAPI();
    PTTAGCCalcuAPI();
    PTTAGCResetAPI();
  }
  
  private static native void PTTAGCCalcuAPI();
  
  public static native int PTTAGCCreateAPI();
  
  public static native int PTTAGCFreeAPI();
  
  public static native void PTTAGCResetAPI();
  
  public static native void PTTAGCRunAPI(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native void PTTVMICRunAPI(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  /* Error */
  public static PTTAgcWrapper a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 13	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   6: ifnonnull +42 -> 48
    //   9: getstatic 11	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_Boolean	Z
    //   12: ifne +26 -> 38
    //   15: aload_0
    //   16: ldc 34
    //   18: iconst_4
    //   19: invokestatic 39	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;I)Z
    //   22: istore_1
    //   23: iload_1
    //   24: ifne +10 -> 34
    //   27: aconst_null
    //   28: astore_0
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_0
    //   33: areturn
    //   34: iconst_1
    //   35: putstatic 11	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_Boolean	Z
    //   38: new 2	com/tencent/mobileqq/utils/PTTAgcWrapper
    //   41: dup
    //   42: invokespecial 40	com/tencent/mobileqq/utils/PTTAgcWrapper:<init>	()V
    //   45: putstatic 13	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   48: getstatic 13	com/tencent/mobileqq/utils/PTTAgcWrapper:jdField_a_of_type_ComTencentMobileqqUtilsPTTAgcWrapper	Lcom/tencent/mobileqq/utils/PTTAgcWrapper;
    //   51: astore_0
    //   52: goto -23 -> 29
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramContext	android.content.Context
    //   22	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	23	55	finally
    //   34	38	55	finally
    //   38	48	55	finally
    //   48	52	55	finally
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PTTVMICRunAPI(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    PTTAGCRunAPI(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected void finalize()
  {
    super.finalize();
    PTTAGCFreeAPI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PTTAgcWrapper
 * JD-Core Version:    0.7.0.1
 */