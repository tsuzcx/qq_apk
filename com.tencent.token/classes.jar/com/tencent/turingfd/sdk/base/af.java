package com.tencent.turingfd.sdk.base;

public class af
{
  public static int a = -1;
  public static Foxnut b;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/tencent/turingfd/sdk/base/af:a	I
    //   6: iconst_m1
    //   7: if_icmpeq +9 -> 16
    //   10: getstatic 18	com/tencent/turingfd/sdk/base/af:b	Lcom/tencent/turingfd/sdk/base/Foxnut;
    //   13: ifnonnull +95 -> 108
    //   16: new 20	android/util/SparseArray
    //   19: dup
    //   20: invokespecial 23	android/util/SparseArray:<init>	()V
    //   23: astore_0
    //   24: invokestatic 29	com/tencent/turingfd/sdk/base/cm:e	()Landroid/util/SparseArray;
    //   27: invokestatic 35	com/tencent/turingfd/sdk/base/TuringDIDService$aa:d	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   30: astore_1
    //   31: aload_1
    //   32: astore_0
    //   33: aload_0
    //   34: sipush 201
    //   37: ldc 37
    //   39: invokestatic 40	com/tencent/turingfd/sdk/base/cm:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   42: checkcast 37	java/lang/String
    //   45: astore_1
    //   46: aload_1
    //   47: ifnonnull +83 -> 130
    //   50: ldc 42
    //   52: astore_1
    //   53: aload_0
    //   54: sipush 202
    //   57: ldc 37
    //   59: invokestatic 40	com/tencent/turingfd/sdk/base/cm:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   62: checkcast 37	java/lang/String
    //   65: astore_2
    //   66: aload_2
    //   67: astore_0
    //   68: aload_2
    //   69: ifnonnull +6 -> 75
    //   72: ldc 42
    //   74: astore_0
    //   75: aload_1
    //   76: invokestatic 48	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   79: invokevirtual 52	java/lang/Integer:intValue	()I
    //   82: putstatic 16	com/tencent/turingfd/sdk/base/af:a	I
    //   85: new 54	com/tencent/turingfd/sdk/base/Foxnut
    //   88: dup
    //   89: invokespecial 55	com/tencent/turingfd/sdk/base/Foxnut:<init>	()V
    //   92: putstatic 18	com/tencent/turingfd/sdk/base/af:b	Lcom/tencent/turingfd/sdk/base/Foxnut;
    //   95: getstatic 18	com/tencent/turingfd/sdk/base/af:b	Lcom/tencent/turingfd/sdk/base/Foxnut;
    //   98: aload_0
    //   99: invokestatic 48	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   102: invokevirtual 52	java/lang/Integer:intValue	()I
    //   105: putfield 58	com/tencent/turingfd/sdk/base/Foxnut:uc	I
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
  
  public static Foxnut c()
  {
    try
    {
      if (b == null) {
        a();
      }
      Foxnut localFoxnut = b;
      return localFoxnut;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.af
 * JD-Core Version:    0.7.0.1
 */