package com.tencent.mobileqq.utils;

public class NoiseSuppression
{
  private static NoiseSuppression b;
  public static int dZp = 160;
  private static boolean soLoaded;
  private int dZq = nativeCreate();
  
  /* Error */
  public static NoiseSuppression a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 29	com/tencent/mobileqq/utils/NoiseSuppression:b	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   6: ifnonnull +61 -> 67
    //   9: getstatic 31	com/tencent/mobileqq/utils/NoiseSuppression:soLoaded	Z
    //   12: ifne +25 -> 37
    //   15: aload_0
    //   16: ldc 33
    //   18: invokestatic 39	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
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
    //   34: putstatic 31	com/tencent/mobileqq/utils/NoiseSuppression:soLoaded	Z
    //   37: new 2	com/tencent/mobileqq/utils/NoiseSuppression
    //   40: dup
    //   41: invokespecial 40	com/tencent/mobileqq/utils/NoiseSuppression:<init>	()V
    //   44: putstatic 29	com/tencent/mobileqq/utils/NoiseSuppression:b	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   47: getstatic 45	aqlv:dZQ	I
    //   50: istore_1
    //   51: getstatic 29	com/tencent/mobileqq/utils/NoiseSuppression:b	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   54: iload_1
    //   55: invokevirtual 49	com/tencent/mobileqq/utils/NoiseSuppression:init	(I)I
    //   58: pop
    //   59: getstatic 29	com/tencent/mobileqq/utils/NoiseSuppression:b	Lcom/tencent/mobileqq/utils/NoiseSuppression;
    //   62: iconst_2
    //   63: invokespecial 52	com/tencent/mobileqq/utils/NoiseSuppression:kc	(I)I
    //   66: pop
    //   67: getstatic 29	com/tencent/mobileqq/utils/NoiseSuppression:b	Lcom/tencent/mobileqq/utils/NoiseSuppression;
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
    //   50	5	1	i	int
    //   21	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	22	74	finally
    //   33	37	74	finally
    //   37	67	74	finally
    //   67	71	74	finally
  }
  
  private int kc(int paramInt)
  {
    if (this.dZq != 0) {
      return nativeSetPolicy(this.dZq, paramInt);
    }
    return -1;
  }
  
  private native int nativeCreate();
  
  private native int nativeInit(int paramInt1, int paramInt2);
  
  private native int nativeProcess(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  private native int nativeRelease(int paramInt);
  
  private native int nativeSetPolicy(int paramInt1, int paramInt2);
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    release();
  }
  
  public int init(int paramInt)
  {
    if (this.dZq != 0)
    {
      dZp = paramInt / 50;
      if (dZp > 320) {
        dZp = 320;
      }
      return nativeInit(this.dZq, paramInt);
    }
    return -1;
  }
  
  public int j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 80) && (paramInt2 != 160) && (paramInt2 != dZp)) {
      throw new IllegalArgumentException();
    }
    if (this.dZq != 0) {
      return nativeProcess(this.dZq, paramArrayOfByte, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public int release()
  {
    if (this.dZq != 0) {
      return nativeRelease(this.dZq);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.NoiseSuppression
 * JD-Core Version:    0.7.0.1
 */