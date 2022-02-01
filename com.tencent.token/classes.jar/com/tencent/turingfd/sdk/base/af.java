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
    //   13: ifnonnull +97 -> 110
    //   16: new 20	android/util/SparseArray
    //   19: dup
    //   20: invokespecial 23	android/util/SparseArray:<init>	()V
    //   23: astore_1
    //   24: invokestatic 29	com/tencent/turingfd/sdk/base/cm:e	()Landroid/util/SparseArray;
    //   27: invokestatic 35	com/tencent/turingfd/sdk/base/TuringDIDService$aa:d	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   30: astore_0
    //   31: aload_0
    //   32: astore_1
    //   33: aload_1
    //   34: sipush 201
    //   37: ldc 37
    //   39: invokestatic 40	com/tencent/turingfd/sdk/base/cm:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   42: checkcast 37	java/lang/String
    //   45: astore_2
    //   46: aload_2
    //   47: astore_0
    //   48: aload_2
    //   49: ifnonnull +6 -> 55
    //   52: ldc 42
    //   54: astore_0
    //   55: aload_1
    //   56: sipush 202
    //   59: ldc 37
    //   61: invokestatic 40	com/tencent/turingfd/sdk/base/cm:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   64: checkcast 37	java/lang/String
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: ifnonnull +6 -> 77
    //   74: ldc 42
    //   76: astore_1
    //   77: aload_0
    //   78: invokestatic 48	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   81: invokevirtual 52	java/lang/Integer:intValue	()I
    //   84: putstatic 16	com/tencent/turingfd/sdk/base/af:a	I
    //   87: new 54	com/tencent/turingfd/sdk/base/Foxnut
    //   90: dup
    //   91: invokespecial 55	com/tencent/turingfd/sdk/base/Foxnut:<init>	()V
    //   94: putstatic 18	com/tencent/turingfd/sdk/base/af:b	Lcom/tencent/turingfd/sdk/base/Foxnut;
    //   97: getstatic 18	com/tencent/turingfd/sdk/base/af:b	Lcom/tencent/turingfd/sdk/base/Foxnut;
    //   100: aload_1
    //   101: invokestatic 48	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   104: invokevirtual 52	java/lang/Integer:intValue	()I
    //   107: putfield 58	com/tencent/turingfd/sdk/base/Foxnut:uc	I
    //   110: ldc 2
    //   112: monitorexit
    //   113: return
    //   114: astore_0
    //   115: ldc 2
    //   117: monitorexit
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -88 -> 33
    //   124: astore_0
    //   125: goto -38 -> 87
    //   128: astore_0
    //   129: goto -19 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	48	0	localObject1	Object
    //   114	5	0	localObject2	Object
    //   120	1	0	localThrowable	java.lang.Throwable
    //   124	1	0	localNumberFormatException1	java.lang.NumberFormatException
    //   128	1	0	localNumberFormatException2	java.lang.NumberFormatException
    //   23	78	1	localObject3	Object
    //   45	26	2	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   3	16	114	finally
    //   16	24	114	finally
    //   24	31	114	finally
    //   33	46	114	finally
    //   55	68	114	finally
    //   77	87	114	finally
    //   87	97	114	finally
    //   97	110	114	finally
    //   24	31	120	java/lang/Throwable
    //   77	87	124	java/lang/NumberFormatException
    //   97	110	128	java/lang/NumberFormatException
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