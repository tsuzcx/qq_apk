package com.tencent.feedback.upload;

import java.util.Map;

public abstract class c
{
  private static c a = null;
  
  /* Error */
  public static c a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	com/tencent/feedback/upload/c:a	Lcom/tencent/feedback/upload/c;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: ifnonnull +23 -> 33
    //   13: new 17	com/tencent/feedback/upload/c$a
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 20	com/tencent/feedback/upload/c$a:<init>	(Landroid/content/Context;)V
    //   21: putstatic 10	com/tencent/feedback/upload/c:a	Lcom/tencent/feedback/upload/c;
    //   24: getstatic 10	com/tencent/feedback/upload/c:a	Lcom/tencent/feedback/upload/c;
    //   27: astore_0
    //   28: ldc 2
    //   30: monitorexit
    //   31: aload_0
    //   32: areturn
    //   33: aload_0
    //   34: invokevirtual 26	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   37: astore_1
    //   38: aload_1
    //   39: ifnull -26 -> 13
    //   42: aload_1
    //   43: astore_0
    //   44: goto -31 -> 13
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramContext	android.content.Context
    //   37	6	1	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   3	9	47	finally
    //   13	24	47	finally
    //   24	28	47	finally
    //   33	38	47	finally
  }
  
  public abstract byte[] a(String paramString, byte[] paramArrayOfByte, b paramb, Map paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.upload.c
 * JD-Core Version:    0.7.0.1
 */