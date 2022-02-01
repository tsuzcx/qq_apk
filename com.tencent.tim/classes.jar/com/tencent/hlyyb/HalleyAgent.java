package com.tencent.hlyyb;

import android.content.Context;
import com.tencent.hlyyb.downloader.Downloader;

public class HalleyAgent
{
  private static volatile boolean a = false;
  private static a b;
  
  /* Error */
  private static void a(a parama)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	com/tencent/hlyyb/HalleyAgent:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: aload_0
    //   16: invokevirtual 22	com/tencent/hlyyb/a:a	()Landroid/content/Context;
    //   19: invokestatic 27	com/tencent/hlyyb/common/b/b:a	(Landroid/content/Context;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_0
    //   24: invokevirtual 31	com/tencent/hlyyb/a:d	()I
    //   27: aload_0
    //   28: invokevirtual 22	com/tencent/hlyyb/a:a	()Landroid/content/Context;
    //   31: aload_0
    //   32: invokevirtual 35	com/tencent/hlyyb/a:c	()Ljava/lang/String;
    //   35: aload_0
    //   36: invokevirtual 37	com/tencent/hlyyb/a:b	()Ljava/lang/String;
    //   39: aload_2
    //   40: invokestatic 42	com/tencent/hlyyb/common/a:a	(ILandroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   43: iconst_1
    //   44: putstatic 12	com/tencent/hlyyb/HalleyAgent:a	Z
    //   47: goto -36 -> 11
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	parama	a
    //   6	2	1	bool	boolean
    //   22	18	2	str	String
    // Exception table:
    //   from	to	target	type
    //   3	7	50	finally
    //   15	47	50	finally
  }
  
  public static Downloader getDownloader()
  {
    if (a) {
      return com.tencent.hlyyb.downloader.c.a.a();
    }
    throw new RuntimeException("halley not init");
  }
  
  public static void init(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new a(paramContext, 2900, paramString2, paramString1);
    b = paramContext;
    a(paramContext);
  }
  
  public static void setFileLog(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.HalleyAgent
 * JD-Core Version:    0.7.0.1
 */