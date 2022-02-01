package com.tencent.token;

public final class v
{
  private static boolean a = false;
  
  /* Error */
  public static void a(com.tencent.halley.DownloaderConfig paramDownloaderConfig)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 10	com/tencent/token/v:a	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 17	com/tencent/halley/common/f:a	()Landroid/content/Context;
    //   18: ifnull -7 -> 11
    //   21: ldc 19
    //   23: new 21	java/lang/StringBuilder
    //   26: dup
    //   27: ldc 23
    //   29: invokespecial 27	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: invokevirtual 33	com/tencent/halley/DownloaderConfig:getMassTaskNum	()I
    //   36: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: ldc 39
    //   41: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: invokevirtual 45	com/tencent/halley/DownloaderConfig:getEaseTaskNum	()I
    //   48: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 55	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: invokevirtual 33	com/tencent/halley/DownloaderConfig:getMassTaskNum	()I
    //   61: invokestatic 60	com/tencent/token/k:a	(I)V
    //   64: aload_0
    //   65: invokevirtual 45	com/tencent/halley/DownloaderConfig:getEaseTaskNum	()I
    //   68: invokestatic 62	com/tencent/token/k:b	(I)V
    //   71: invokestatic 67	com/tencent/token/x:a	()Lcom/tencent/token/x;
    //   74: pop
    //   75: invokestatic 71	com/tencent/halley/common/f:h	()Landroid/os/Handler;
    //   78: new 73	com/tencent/token/w
    //   81: dup
    //   82: invokespecial 75	com/tencent/token/w:<init>	()V
    //   85: invokevirtual 81	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   88: pop
    //   89: iconst_1
    //   90: putstatic 10	com/tencent/token/v:a	Z
    //   93: goto -82 -> 11
    //   96: astore_0
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramDownloaderConfig	com.tencent.halley.DownloaderConfig
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	96	finally
    //   15	93	96	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.v
 * JD-Core Version:    0.7.0.1
 */