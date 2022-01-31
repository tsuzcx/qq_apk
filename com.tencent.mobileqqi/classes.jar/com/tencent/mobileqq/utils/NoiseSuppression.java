package com.tencent.mobileqq.utils;

public class NoiseSuppression
{
  public static final int a = 0;
  private static NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = -1;
  public static final int c = 80;
  public static final int d = 160;
  public static final int e = 8000;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 2;
  private int j = 0;
  
  private int a(int paramInt)
  {
    if (this.j != 0) {
      return nativeInit(this.j, paramInt);
    }
    return -1;
  }
  
  /* Error */
  public static NoiseSuppression a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   6: ifnonnull +60 -> 66
    //   9: getstatic 30	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_Boolean	Z
    //   12: ifne +26 -> 38
    //   15: aload_0
    //   16: ldc 48
    //   18: iconst_1
    //   19: invokestatic 53	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;I)Z
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
    //   35: putstatic 30	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_Boolean	Z
    //   38: new 2	com/tencent/mobileqq/utils/NoiseSuppression
    //   41: dup
    //   42: invokespecial 54	com/tencent/mobileqq/utils/NoiseSuppression:<init>	()V
    //   45: putstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   48: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   51: sipush 8000
    //   54: invokespecial 56	com/tencent/mobileqq/utils/NoiseSuppression:a	(I)I
    //   57: pop
    //   58: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   61: iconst_2
    //   62: invokespecial 58	com/tencent/mobileqq/utils/NoiseSuppression:b	(I)I
    //   65: pop
    //   66: getstatic 28	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   69: astore_0
    //   70: goto -41 -> 29
    //   73: astore_0
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramContext	android.content.Context
    //   22	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	23	73	finally
    //   34	38	73	finally
    //   38	66	73	finally
    //   66	70	73	finally
  }
  
  private int b(int paramInt)
  {
    if (this.j != 0) {
      return nativeSetPolicy(this.j, paramInt);
    }
    return -1;
  }
  
  private native int nativeCreate();
  
  private native int nativeInit(int paramInt1, int paramInt2);
  
  private native int nativeProcess(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private native int nativeRelease(int paramInt);
  
  private native int nativeSetPolicy(int paramInt1, int paramInt2);
  
  public int a()
  {
    if (this.j != 0) {
      return nativeRelease(this.j);
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 80) && (paramInt2 != 160)) {
      throw new IllegalArgumentException();
    }
    if (this.j != 0) {
      return nativeProcess(this.j, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
  
  protected void finalize()
  {
    super.finalize();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NoiseSuppression
 * JD-Core Version:    0.7.0.1
 */