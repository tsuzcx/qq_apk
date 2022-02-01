package com.tencent.token;

import com.tencent.turingfd.sdk.base.Foxnut;

public final class acr
{
  public static int a = -1;
  public static Foxnut b;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/tencent/token/acr:a	I
    //   6: iconst_m1
    //   7: if_icmpeq +9 -> 16
    //   10: getstatic 18	com/tencent/token/acr:b	Lcom/tencent/turingfd/sdk/base/Foxnut;
    //   13: ifnonnull +105 -> 118
    //   16: new 20	android/util/SparseArray
    //   19: dup
    //   20: invokespecial 23	android/util/SparseArray:<init>	()V
    //   23: astore_1
    //   24: new 20	android/util/SparseArray
    //   27: dup
    //   28: invokespecial 23	android/util/SparseArray:<init>	()V
    //   31: invokestatic 29	com/tencent/turingfd/sdk/base/TuringDIDService$aa:d	(Landroid/util/SparseArray;)Landroid/util/SparseArray;
    //   34: astore_0
    //   35: aload_0
    //   36: astore_1
    //   37: aload_1
    //   38: sipush 201
    //   41: ldc 31
    //   43: invokestatic 36	com/tencent/token/aey:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   46: checkcast 31	java/lang/String
    //   49: astore_2
    //   50: aload_2
    //   51: astore_0
    //   52: aload_2
    //   53: ifnonnull +6 -> 59
    //   56: ldc 38
    //   58: astore_0
    //   59: aload_1
    //   60: sipush 202
    //   63: ldc 31
    //   65: invokestatic 36	com/tencent/token/aey:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   68: checkcast 31	java/lang/String
    //   71: astore_2
    //   72: aload_2
    //   73: astore_1
    //   74: aload_2
    //   75: ifnonnull +6 -> 81
    //   78: ldc 38
    //   80: astore_1
    //   81: aload_0
    //   82: invokestatic 44	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   85: invokevirtual 48	java/lang/Integer:intValue	()I
    //   88: putstatic 16	com/tencent/token/acr:a	I
    //   91: new 50	com/tencent/turingfd/sdk/base/Foxnut
    //   94: dup
    //   95: invokespecial 51	com/tencent/turingfd/sdk/base/Foxnut:<init>	()V
    //   98: putstatic 18	com/tencent/token/acr:b	Lcom/tencent/turingfd/sdk/base/Foxnut;
    //   101: getstatic 18	com/tencent/token/acr:b	Lcom/tencent/turingfd/sdk/base/Foxnut;
    //   104: aload_1
    //   105: invokestatic 44	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   108: invokevirtual 48	java/lang/Integer:intValue	()I
    //   111: putfield 54	com/tencent/turingfd/sdk/base/Foxnut:uc	I
    //   114: ldc 2
    //   116: monitorexit
    //   117: return
    //   118: ldc 2
    //   120: monitorexit
    //   121: return
    //   122: astore_0
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: goto -92 -> 37
    //   132: astore_0
    //   133: goto -42 -> 91
    //   136: astore_0
    //   137: goto -19 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	48	0	localObject1	Object
    //   122	5	0	localObject2	Object
    //   128	1	0	localThrowable	java.lang.Throwable
    //   132	1	0	localNumberFormatException1	java.lang.NumberFormatException
    //   136	1	0	localNumberFormatException2	java.lang.NumberFormatException
    //   23	82	1	localObject3	Object
    //   49	26	2	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   3	16	122	finally
    //   16	24	122	finally
    //   24	35	122	finally
    //   37	50	122	finally
    //   59	72	122	finally
    //   81	91	122	finally
    //   91	101	122	finally
    //   101	114	122	finally
    //   24	35	128	java/lang/Throwable
    //   81	91	132	java/lang/NumberFormatException
    //   101	114	136	java/lang/NumberFormatException
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
 * Qualified Name:     com.tencent.token.acr
 * JD-Core Version:    0.7.0.1
 */