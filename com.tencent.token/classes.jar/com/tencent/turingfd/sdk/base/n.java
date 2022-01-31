package com.tencent.turingfd.sdk.base;

import java.util.concurrent.atomic.AtomicBoolean;

public class n
{
  public static final Object a = new Object();
  public static Herbaceous b = new Herbaceous();
  
  static
  {
    new AtomicBoolean(false);
  }
  
  /* Error */
  public static Herbaceous a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 31
    //   3: iconst_0
    //   4: invokevirtual 37	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull +17 -> 26
    //   12: ldc 39
    //   14: astore_0
    //   15: aload_0
    //   16: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +89 -> 108
    //   22: getstatic 25	com/tencent/turingfd/sdk/base/n:b	Lcom/tencent/turingfd/sdk/base/Herbaceous;
    //   25: areturn
    //   26: new 47	java/io/File
    //   29: dup
    //   30: new 49	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   37: aload_0
    //   38: invokevirtual 54	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   41: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: getstatic 62	java/io/File:separator	Ljava/lang/String;
    //   47: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 64
    //   52: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 74	java/io/File:exists	()Z
    //   66: ifne +10 -> 76
    //   69: aload_0
    //   70: invokevirtual 77	java/io/File:mkdirs	()Z
    //   73: ifeq -61 -> 12
    //   76: new 49	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   83: aload_0
    //   84: invokevirtual 54	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: getstatic 62	java/io/File:separator	Ljava/lang/String;
    //   93: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 79
    //   98: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_0
    //   105: goto -90 -> 15
    //   108: getstatic 15	com/tencent/turingfd/sdk/base/n:a	Ljava/lang/Object;
    //   111: astore_1
    //   112: aload_1
    //   113: monitorenter
    //   114: aload_0
    //   115: invokestatic 85	com/tencent/turingfd/sdk/base/ed:c	(Ljava/lang/String;)[B
    //   118: astore_0
    //   119: aload_1
    //   120: monitorexit
    //   121: new 87	java/lang/String
    //   124: dup
    //   125: aload_0
    //   126: invokestatic 90	com/tencent/turingfd/sdk/base/ed:c	()[B
    //   129: invokestatic 93	com/tencent/turingfd/sdk/base/ed:b	([B[B)[B
    //   132: invokestatic 96	com/tencent/turingfd/sdk/base/ed:c	([B)[B
    //   135: invokespecial 99	java/lang/String:<init>	([B)V
    //   138: astore_0
    //   139: aload_0
    //   140: ldc 101
    //   142: invokevirtual 105	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   145: astore_0
    //   146: new 22	com/tencent/turingfd/sdk/base/Herbaceous
    //   149: dup
    //   150: invokespecial 23	com/tencent/turingfd/sdk/base/Herbaceous:<init>	()V
    //   153: astore_1
    //   154: aload_1
    //   155: new 107	java/util/ArrayList
    //   158: dup
    //   159: aload_0
    //   160: invokestatic 113	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   163: invokespecial 116	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   166: putfield 120	com/tencent/turingfd/sdk/base/Herbaceous:jd	Ljava/util/ArrayList;
    //   169: aload_1
    //   170: areturn
    //   171: astore_0
    //   172: getstatic 25	com/tencent/turingfd/sdk/base/n:b	Lcom/tencent/turingfd/sdk/base/Herbaceous;
    //   175: areturn
    //   176: astore_0
    //   177: aload_1
    //   178: monitorexit
    //   179: aload_0
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   108	114	171	java/lang/Throwable
    //   121	139	171	java/lang/Throwable
    //   139	169	171	java/lang/Throwable
    //   179	181	171	java/lang/Throwable
    //   114	121	176	finally
    //   177	179	176	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.n
 * JD-Core Version:    0.7.0.1
 */