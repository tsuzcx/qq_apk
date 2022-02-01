package com.tencent.halley;

import com.tencent.token.ak;
import com.tencent.token.aq;
import java.util.List;

public class a
{
  public static List a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    try
    {
      if (aq.a() != null)
      {
        paramString = aq.a().a(paramString, paramInt, paramLong, paramBoolean);
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString1, String paramString2, String paramString3, List paramList, DownloaderConfig paramDownloaderConfig)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 24	com/tencent/halley/common/f:a	()Landroid/content/Context;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnull +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: aload_3
    //   21: invokestatic 27	com/tencent/halley/common/f:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: aload_3
    //   28: invokestatic 30	com/tencent/token/aq:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/token/ak;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull +11 -> 44
    //   36: aload_0
    //   37: aload 4
    //   39: invokeinterface 33 2 0
    //   44: aload 5
    //   46: invokestatic 38	com/tencent/halley/downloader/DownloaderFactory:a	(Lcom/tencent/halley/DownloaderConfig;)V
    //   49: goto -36 -> 13
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	paramContext	android.content.Context
    //   0	58	1	paramString1	String
    //   0	58	2	paramString2	String
    //   0	58	3	paramString3	String
    //   0	58	4	paramList	List
    //   0	58	5	paramDownloaderConfig	DownloaderConfig
    //   6	3	6	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   3	8	52	finally
    //   17	32	52	finally
    //   36	44	52	finally
    //   44	49	52	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.a
 * JD-Core Version:    0.7.0.1
 */