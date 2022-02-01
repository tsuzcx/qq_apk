package com.tencent.turingfd.sdk.base;

import java.util.concurrent.atomic.AtomicBoolean;

public class co
{
  public static final Object a = new Object();
  public static Longan b = new Longan();
  
  static
  {
    new AtomicBoolean(false);
  }
  
  /* Error */
  public static Longan a(android.content.Context paramContext)
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
    //   19: ifeq +77 -> 96
    //   22: getstatic 25	com/tencent/turingfd/sdk/base/co:b	Lcom/tencent/turingfd/sdk/base/Longan;
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
    //   47: ldc 64
    //   49: invokestatic 69	com/tencent/turingfd/sdk/base/ci:a	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 76	java/io/File:exists	()Z
    //   60: ifne +10 -> 70
    //   63: aload_0
    //   64: invokevirtual 79	java/io/File:mkdirs	()Z
    //   67: ifeq -55 -> 12
    //   70: new 49	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   77: aload_0
    //   78: invokevirtual 54	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   81: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: getstatic 62	java/io/File:separator	Ljava/lang/String;
    //   87: ldc 81
    //   89: invokestatic 69	com/tencent/turingfd/sdk/base/ci:a	(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_0
    //   93: goto -78 -> 15
    //   96: getstatic 15	com/tencent/turingfd/sdk/base/co:a	Ljava/lang/Object;
    //   99: astore_1
    //   100: aload_1
    //   101: monitorenter
    //   102: aload_0
    //   103: invokestatic 87	com/tencent/turingfd/sdk/base/cm:c	(Ljava/lang/String;)[B
    //   106: astore_0
    //   107: aload_1
    //   108: monitorexit
    //   109: new 89	java/lang/String
    //   112: dup
    //   113: aload_0
    //   114: invokestatic 92	com/tencent/turingfd/sdk/base/cm:b	()[B
    //   117: invokestatic 95	com/tencent/turingfd/sdk/base/cm:b	([B[B)[B
    //   120: invokestatic 98	com/tencent/turingfd/sdk/base/cm:c	([B)[B
    //   123: invokespecial 101	java/lang/String:<init>	([B)V
    //   126: astore_0
    //   127: aload_0
    //   128: ldc 103
    //   130: invokevirtual 107	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   133: astore_0
    //   134: new 22	com/tencent/turingfd/sdk/base/Longan
    //   137: dup
    //   138: invokespecial 23	com/tencent/turingfd/sdk/base/Longan:<init>	()V
    //   141: astore_1
    //   142: aload_1
    //   143: new 109	java/util/ArrayList
    //   146: dup
    //   147: aload_0
    //   148: invokestatic 115	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   151: invokespecial 118	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   154: putfield 122	com/tencent/turingfd/sdk/base/Longan:td	Ljava/util/ArrayList;
    //   157: aload_1
    //   158: areturn
    //   159: astore_0
    //   160: getstatic 25	com/tencent/turingfd/sdk/base/co:b	Lcom/tencent/turingfd/sdk/base/Longan;
    //   163: areturn
    //   164: astore_0
    //   165: aload_1
    //   166: monitorexit
    //   167: aload_0
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   96	102	159	java/lang/Throwable
    //   109	127	159	java/lang/Throwable
    //   127	157	159	java/lang/Throwable
    //   167	169	159	java/lang/Throwable
    //   102	109	164	finally
    //   165	167	164	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.co
 * JD-Core Version:    0.7.0.1
 */