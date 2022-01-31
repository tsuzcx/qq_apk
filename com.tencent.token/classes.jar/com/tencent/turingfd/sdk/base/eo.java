package com.tencent.turingfd.sdk.base;

public class eo
{
  public static int a = -1;
  public static Filbert b;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/tencent/turingfd/sdk/base/eo:a	I
    //   6: iconst_m1
    //   7: if_icmpeq +9 -> 16
    //   10: getstatic 18	com/tencent/turingfd/sdk/base/eo:b	Lcom/tencent/turingfd/sdk/base/Filbert;
    //   13: ifnonnull +95 -> 108
    //   16: new 20	android/util/SparseArray
    //   19: dup
    //   20: invokespecial 23	android/util/SparseArray:<init>	()V
    //   23: astore_0
    //   24: invokestatic 29	com/tencent/turingfd/sdk/base/ed:d	()Landroid/util/SparseArray;
    //   27: invokestatic 34	com/tencent/turingfd/sdk/base/TuringDIDService$aa:d	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_0
    //   34: sipush 201
    //   37: ldc 36
    //   39: invokestatic 39	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   42: checkcast 36	java/lang/String
    //   45: astore_1
    //   46: aload_1
    //   47: ifnonnull +83 -> 130
    //   50: ldc 41
    //   52: astore_1
    //   53: aload_0
    //   54: sipush 202
    //   57: ldc 36
    //   59: invokestatic 39	com/tencent/turingfd/sdk/base/ed:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   62: checkcast 36	java/lang/String
    //   65: astore_2
    //   66: aload_2
    //   67: astore_0
    //   68: aload_2
    //   69: ifnonnull +6 -> 75
    //   72: ldc 41
    //   74: astore_0
    //   75: aload_1
    //   76: invokestatic 47	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 51	java/lang/Integer:intValue	()I
    //   82: putstatic 16	com/tencent/turingfd/sdk/base/eo:a	I
    //   85: new 53	com/tencent/turingfd/sdk/base/Filbert
    //   88: dup
    //   89: invokespecial 54	com/tencent/turingfd/sdk/base/Filbert:<init>	()V
    //   92: putstatic 18	com/tencent/turingfd/sdk/base/eo:b	Lcom/tencent/turingfd/sdk/base/Filbert;
    //   95: getstatic 18	com/tencent/turingfd/sdk/base/eo:b	Lcom/tencent/turingfd/sdk/base/Filbert;
    //   98: aload_0
    //   99: invokestatic 47	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   102: invokevirtual 51	java/lang/Integer:intValue	()I
    //   105: putfield 57	com/tencent/turingfd/sdk/base/Filbert:xc	I
    //   108: ldc 2
    //   110: monitorexit
    //   111: return
    //   112: astore_1
    //   113: goto -80 -> 33
    //   116: astore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: goto -15 -> 108
    //   126: astore_1
    //   127: goto -42 -> 85
    //   130: goto -77 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	76	0	localObject1	Object
    //   116	5	0	localObject2	Object
    //   122	1	0	localNumberFormatException1	java.lang.NumberFormatException
    //   30	46	1	localObject3	Object
    //   112	1	1	localThrowable	java.lang.Throwable
    //   126	1	1	localNumberFormatException2	java.lang.NumberFormatException
    //   65	4	2	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   24	31	112	java/lang/Throwable
    //   3	16	116	finally
    //   16	24	116	finally
    //   24	31	116	finally
    //   33	46	116	finally
    //   53	66	116	finally
    //   75	85	116	finally
    //   85	95	116	finally
    //   95	108	116	finally
    //   95	108	122	java/lang/NumberFormatException
    //   75	85	126	java/lang/NumberFormatException
  }
  
  public static int b()
  {
    try
    {
      if (a == -1) {
        a();
      }
      int i = a;
      return i;
    }
    finally {}
  }
  
  public static Filbert c()
  {
    try
    {
      if (b == null) {
        a();
      }
      Filbert localFilbert = b;
      return localFilbert;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.eo
 * JD-Core Version:    0.7.0.1
 */