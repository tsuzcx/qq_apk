package com.tencent.mobileqq.utils;

public class NoiseSuppression
{
  public static final int a = 0;
  private static NoiseSuppression jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression = null;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = -1;
  public static final int c = 80;
  public static final int d = 160;
  public static final int e = 320;
  public static int f = 160;
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 2;
  private int k = 0;
  
  /* Error */
  public static NoiseSuppression a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 31	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   6: ifnonnull +61 -> 67
    //   9: getstatic 33	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_Boolean	Z
    //   12: ifne +25 -> 37
    //   15: aload_0
    //   16: ldc 46
    //   18: invokestatic 52	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   21: istore_2
    //   22: iload_2
    //   23: ifne +10 -> 33
    //   26: aconst_null
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: iconst_1
    //   34: putstatic 33	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_Boolean	Z
    //   37: new 2	com/tencent/mobileqq/utils/NoiseSuppression
    //   40: dup
    //   41: invokespecial 53	com/tencent/mobileqq/utils/NoiseSuppression:<init>	()V
    //   44: putstatic 31	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   47: getstatic 56	com/tencent/mobileqq/utils/RecordParams:f	I
    //   50: istore_1
    //   51: getstatic 31	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   54: iload_1
    //   55: invokevirtual 59	com/tencent/mobileqq/utils/NoiseSuppression:a	(I)I
    //   58: pop
    //   59: getstatic 31	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   62: iconst_2
    //   63: invokespecial 61	com/tencent/mobileqq/utils/NoiseSuppression:b	(I)I
    //   66: pop
    //   67: getstatic 31	com/tencent/mobileqq/utils/NoiseSuppression:jdField_a_of_type_ComTencentMobileqqUtilsNoiseSuppression	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   70: astore_0
    //   71: goto -43 -> 28
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramContext	android.content.Context
    //   50	5	1	m	int
    //   21	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	22	74	finally
    //   33	37	74	finally
    //   37	67	74	finally
    //   67	71	74	finally
  }
  
  private int b(int paramInt)
  {
    if (this.k != 0) {
      return nativeSetPolicy(this.k, paramInt);
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
    if (this.k != 0) {
      return nativeRelease(this.k);
    }
    return -1;
  }
  
  public int a(int paramInt)
  {
    if (this.k != 0)
    {
      f = paramInt / 50;
      if (f > 320) {
        f = 320;
      }
      return nativeInit(this.k, paramInt);
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 80) && (paramInt2 != 160) && (paramInt2 != f)) {
      throw new IllegalArgumentException();
    }
    if (this.k != 0) {
      return nativeProcess(this.k, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
  
  protected void finalize()
  {
    super.finalize();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NoiseSuppression
 * JD-Core Version:    0.7.0.1
 */