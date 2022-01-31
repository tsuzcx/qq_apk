package com.tencent.beacon.a;

import android.content.Context;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static g c = null;
  private Context a = null;
  private Map<String, FileChannel> b = null;
  
  private g(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new HashMap(5);
  }
  
  public static g a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new g(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private java.io.File b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 43	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 22	com/tencent/beacon/a/g:a	Landroid/content/Context;
    //   10: invokevirtual 47	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: new 49	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 51
    //   19: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 60
    //   28: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 71	java/io/File:exists	()Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +24 -> 68
    //   47: ldc 73
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: invokevirtual 76	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 81	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: aload_1
    //   64: invokevirtual 84	java/io/File:createNewFile	()Z
    //   67: pop
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: areturn
    //   72: astore_3
    //   73: aload_3
    //   74: invokevirtual 87	java/io/IOException:printStackTrace	()V
    //   77: goto -9 -> 68
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	g
    //   0	85	1	paramString	String
    //   42	2	2	bool	boolean
    //   72	2	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   47	68	72	java/io/IOException
    //   2	43	80	finally
    //   47	68	80	finally
    //   73	77	80	finally
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +15 -> 18
    //   6: aload_1
    //   7: invokevirtual 95	java/lang/String:trim	()Ljava/lang/String;
    //   10: invokevirtual 99	java/lang/String:length	()I
    //   13: istore_2
    //   14: iload_2
    //   15: ifgt +9 -> 24
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_3
    //   23: ireturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 101	com/tencent/beacon/a/g:b	(Ljava/lang/String;)Ljava/io/File;
    //   29: astore 6
    //   31: aload_0
    //   32: getfield 24	com/tencent/beacon/a/g:b	Ljava/util/Map;
    //   35: aload_1
    //   36: invokeinterface 107 2 0
    //   41: checkcast 109	java/nio/channels/FileChannel
    //   44: astore 5
    //   46: aload 5
    //   48: ifnull +15 -> 63
    //   51: aload 5
    //   53: astore 4
    //   55: aload 5
    //   57: invokevirtual 112	java/nio/channels/FileChannel:isOpen	()Z
    //   60: ifne +43 -> 103
    //   63: ldc 114
    //   65: iconst_1
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_1
    //   72: aastore
    //   73: invokestatic 81	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: new 116	java/io/FileOutputStream
    //   79: dup
    //   80: aload 6
    //   82: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: invokevirtual 123	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   88: astore 4
    //   90: aload_0
    //   91: getfield 24	com/tencent/beacon/a/g:b	Ljava/util/Map;
    //   94: aload_1
    //   95: aload 4
    //   97: invokeinterface 127 3 0
    //   102: pop
    //   103: aload 4
    //   105: invokevirtual 131	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull +22 -> 132
    //   113: aload_1
    //   114: invokevirtual 136	java/nio/channels/FileLock:isValid	()Z
    //   117: istore_3
    //   118: iload_3
    //   119: ifeq +13 -> 132
    //   122: iconst_1
    //   123: istore_3
    //   124: goto -104 -> 20
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 137	java/lang/Throwable:printStackTrace	()V
    //   132: iconst_0
    //   133: istore_3
    //   134: goto -114 -> 20
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	g
    //   0	142	1	paramString	String
    //   13	2	2	i	int
    //   19	115	3	bool	boolean
    //   53	51	4	localFileChannel1	FileChannel
    //   44	12	5	localFileChannel2	FileChannel
    //   29	52	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   31	46	127	java/lang/Throwable
    //   55	63	127	java/lang/Throwable
    //   63	103	127	java/lang/Throwable
    //   103	109	127	java/lang/Throwable
    //   113	118	127	java/lang/Throwable
    //   6	14	137	finally
    //   24	31	137	finally
    //   31	46	137	finally
    //   55	63	137	finally
    //   63	103	137	finally
    //   103	109	137	finally
    //   113	118	137	finally
    //   128	132	137	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.beacon.a.g
 * JD-Core Version:    0.7.0.1
 */