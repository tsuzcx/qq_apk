package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;

public final class afk
{
  public static final agi<afk> a = new a();
  public static agr b;
  public static int c = -1;
  public static final int[] d = { 1, 5, 4, 8, 9, 2 };
  public Context e;
  public final Handler f;
  public AtomicBoolean g = new AtomicBoolean(false);
  public afe h;
  
  public afk()
  {
    HandlerThread localHandlerThread = new HandlerThread("TuringMMCore");
    localHandlerThread.start();
    this.f = new Handler(localHandlerThread.getLooper());
  }
  
  /* Error */
  public static boolean a(aet paramaet, com.tencent.turingfd.sdk.qps.Codlin paramCodlin)
  {
    // Byte code:
    //   0: getstatic 71	com/tencent/token/ago:a	Ljava/lang/String;
    //   3: astore_3
    //   4: getstatic 73	com/tencent/token/ago:b	Ljava/lang/String;
    //   7: astore_3
    //   8: aload_0
    //   9: checkcast 75	com/tencent/token/aej
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 79	java/lang/Object:getClass	()Ljava/lang/Class;
    //   17: pop
    //   18: ldc 81
    //   20: monitorenter
    //   21: getstatic 83	com/tencent/token/agn:a	Landroid/content/Context;
    //   24: astore_0
    //   25: ldc 81
    //   27: monitorexit
    //   28: invokestatic 88	com/tencent/token/ags:a	()I
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq +11 -> 44
    //   36: iload_2
    //   37: invokestatic 93	com/tencent/token/adt:a	(I)Lcom/tencent/token/adt;
    //   40: astore_0
    //   41: goto +13 -> 54
    //   44: getstatic 98	com/tencent/token/aec:a	Lcom/tencent/token/aec;
    //   47: aload_0
    //   48: iconst_1
    //   49: iconst_1
    //   50: invokevirtual 101	com/tencent/token/aec:a	(Landroid/content/Context;ZI)Lcom/tencent/token/adt;
    //   53: astore_0
    //   54: aload_1
    //   55: aload_0
    //   56: getfield 102	com/tencent/token/adt:b	Ljava/lang/String;
    //   59: putfield 107	com/tencent/turingfd/sdk/qps/Codlin:y	Ljava/lang/String;
    //   62: new 109	com/tencent/turingfd/sdk/qps/Fig
    //   65: dup
    //   66: invokespecial 110	com/tencent/turingfd/sdk/qps/Fig:<init>	()V
    //   69: astore 5
    //   71: aload 5
    //   73: sipush -999
    //   76: putfield 112	com/tencent/turingfd/sdk/qps/Fig:b	I
    //   79: aload_1
    //   80: getstatic 117	com/tencent/token/adz:f	Lcom/tencent/turingfd/sdk/qps/Cumquat;
    //   83: putfield 120	com/tencent/turingfd/sdk/qps/Codlin:D	Lcom/tencent/turingfd/sdk/qps/Cumquat;
    //   86: aconst_null
    //   87: astore_0
    //   88: invokestatic 125	com/tencent/token/acy:a	()Lcom/tencent/token/acy;
    //   91: astore 4
    //   93: aload 4
    //   95: monitorenter
    //   96: aload 4
    //   98: sipush 4103
    //   101: sipush 14103
    //   104: iconst_2
    //   105: aload_1
    //   106: aload 5
    //   108: aconst_null
    //   109: ldc2_w 126
    //   112: invokevirtual 130	com/tencent/token/acy:a	(IIILcom/tencent/turingfd/sdk/qps/final;Lcom/tencent/turingfd/sdk/qps/final;[BJ)Lcom/tencent/token/ada;
    //   115: astore_1
    //   116: aload 4
    //   118: monitorexit
    //   119: aload_1
    //   120: getfield 135	com/tencent/token/ada:b	[B
    //   123: aload_1
    //   124: getfield 138	com/tencent/token/ada:c	Lcom/tencent/turingfd/sdk/qps/final;
    //   127: invokestatic 141	com/tencent/token/agn:a	([BLcom/tencent/turingfd/sdk/qps/final;)Lcom/tencent/turingfd/sdk/qps/final;
    //   130: ifnull +18 -> 148
    //   133: aload_1
    //   134: getfield 135	com/tencent/token/ada:b	[B
    //   137: aload_1
    //   138: getfield 138	com/tencent/token/ada:c	Lcom/tencent/turingfd/sdk/qps/final;
    //   141: invokestatic 141	com/tencent/token/agn:a	([BLcom/tencent/turingfd/sdk/qps/final;)Lcom/tencent/turingfd/sdk/qps/final;
    //   144: checkcast 109	com/tencent/turingfd/sdk/qps/Fig
    //   147: astore_0
    //   148: getstatic 143	com/tencent/token/adz:e	Lcom/tencent/token/agr;
    //   151: invokevirtual 79	java/lang/Object:getClass	()Ljava/lang/Class;
    //   154: pop
    //   155: aload_0
    //   156: ifnull +63 -> 219
    //   159: aload_0
    //   160: getfield 112	com/tencent/turingfd/sdk/qps/Fig:b	I
    //   163: ifne +56 -> 219
    //   166: getstatic 146	com/tencent/token/adz:g	Z
    //   169: ifeq +7 -> 176
    //   172: invokestatic 149	com/tencent/token/adz:a	()Z
    //   175: pop
    //   176: aload_3
    //   177: getfield 152	com/tencent/token/aej:a	Lcom/tencent/token/aeq;
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 79	java/lang/Object:getClass	()Ljava/lang/Class;
    //   185: pop
    //   186: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   189: pop2
    //   190: aload_1
    //   191: getfield 163	com/tencent/token/aeq:c	Lcom/tencent/token/adh;
    //   194: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   197: invokestatic 169	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   200: invokevirtual 174	com/tencent/token/adh:a	(Ljava/lang/Object;)V
    //   203: invokestatic 179	com/tencent/token/abz:a	()Lcom/tencent/token/abz;
    //   206: pop
    //   207: aload_1
    //   208: getfield 181	com/tencent/token/aeq:d	Landroid/content/Context;
    //   211: aload_1
    //   212: getfield 183	com/tencent/token/aeq:g	I
    //   215: aload_1
    //   216: invokestatic 186	com/tencent/token/abz:a	(Landroid/content/Context;ILcom/tencent/token/aeq;)V
    //   219: aload_0
    //   220: ifnull +12 -> 232
    //   223: aload_0
    //   224: getfield 112	com/tencent/turingfd/sdk/qps/Fig:b	I
    //   227: ifne +5 -> 232
    //   230: iconst_1
    //   231: ireturn
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_0
    //   235: aload 4
    //   237: monitorexit
    //   238: aload_0
    //   239: athrow
    //   240: astore_0
    //   241: ldc 81
    //   243: monitorexit
    //   244: aload_0
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramaet	aet
    //   0	246	1	paramCodlin	com.tencent.turingfd.sdk.qps.Codlin
    //   31	6	2	i	int
    //   3	174	3	localObject	Object
    //   69	38	5	localFig	com.tencent.turingfd.sdk.qps.Fig
    // Exception table:
    //   from	to	target	type
    //   96	116	234	finally
    //   21	25	240	finally
  }
  
  public final class a
    extends agi<afk>
  {
    public final Object a()
    {
      return new afk();
    }
  }
  
  public final class b
    implements acq
  {
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afk
 * JD-Core Version:    0.7.0.1
 */