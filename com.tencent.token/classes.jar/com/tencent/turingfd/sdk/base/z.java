package com.tencent.turingfd.sdk.base;

import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.atomic.AtomicBoolean;

public class z
{
  public static final dj a = new s();
  public aa b;
  public final AtomicBoolean c = new AtomicBoolean(false);
  
  /* Error */
  public float a(int paramInt1, int paramInt2, int paramInt3, float paramfloat1, float paramfloat2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/tencent/turingfd/sdk/base/z:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 145	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifeq +156 -> 165
    //   12: new 4	java/lang/Object
    //   15: dup
    //   16: invokespecial 21	java/lang/Object:<init>	()V
    //   19: astore 8
    //   21: new 147	java/util/concurrent/atomic/AtomicReference
    //   24: dup
    //   25: invokespecial 148	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   28: astore 9
    //   30: new 23	java/util/concurrent/atomic/AtomicBoolean
    //   33: dup
    //   34: iconst_0
    //   35: invokespecial 26	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   38: astore 10
    //   40: aload 9
    //   42: aload 5
    //   44: invokevirtual 152	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   47: new 154	com/tencent/turingfd/sdk/base/t
    //   50: dup
    //   51: aload_0
    //   52: aload 10
    //   54: aload 9
    //   56: aload 8
    //   58: invokespecial 157	com/tencent/turingfd/sdk/base/t:<init>	(Lcom/tencent/turingfd/sdk/base/z;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   61: astore 11
    //   63: aload_0
    //   64: getfield 159	com/tencent/turingfd/sdk/base/z:b	Lcom/tencent/turingfd/sdk/base/aa;
    //   67: astore 12
    //   69: new 161	com/tencent/turingfd/sdk/base/ad
    //   72: dup
    //   73: iload_1
    //   74: iload_2
    //   75: iload_3
    //   76: invokespecial 164	com/tencent/turingfd/sdk/base/ad:<init>	(III)V
    //   79: astore 13
    //   81: aload 13
    //   83: aload 4
    //   85: putfield 168	com/tencent/turingfd/sdk/base/ad:d	Lcom/tencent/turingfd/sdk/base/float;
    //   88: aload 13
    //   90: aload 5
    //   92: putfield 171	com/tencent/turingfd/sdk/base/ad:f	Lcom/tencent/turingfd/sdk/base/float;
    //   95: aload 13
    //   97: aload 11
    //   99: putfield 174	com/tencent/turingfd/sdk/base/ad:a	Lcom/tencent/turingfd/sdk/base/ae;
    //   102: aload 12
    //   104: iconst_2
    //   105: aload 13
    //   107: invokevirtual 177	com/tencent/turingfd/sdk/base/ad:a	()Lcom/tencent/turingfd/sdk/base/ac;
    //   110: invokestatic 183	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   113: invokevirtual 186	android/os/Message:sendToTarget	()V
    //   116: aload 8
    //   118: monitorenter
    //   119: aload 8
    //   121: lload 6
    //   123: invokevirtual 190	java/lang/Object:wait	(J)V
    //   126: aload 8
    //   128: monitorexit
    //   129: aload 10
    //   131: iconst_1
    //   132: invokevirtual 192	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   135: aload 9
    //   137: invokevirtual 194	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   140: checkcast 196	com/tencent/turingfd/sdk/base/float
    //   143: astore 4
    //   145: aload_0
    //   146: monitorexit
    //   147: aload 4
    //   149: areturn
    //   150: astore 4
    //   152: aload 8
    //   154: monitorexit
    //   155: aload 4
    //   157: athrow
    //   158: astore 4
    //   160: aload_0
    //   161: monitorexit
    //   162: aload 4
    //   164: athrow
    //   165: new 198	java/lang/RuntimeException
    //   168: dup
    //   169: ldc 200
    //   171: invokespecial 203	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   174: athrow
    //   175: astore 4
    //   177: goto -51 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	z
    //   0	180	1	paramInt1	int
    //   0	180	2	paramInt2	int
    //   0	180	3	paramInt3	int
    //   0	180	4	paramfloat1	float
    //   0	180	5	paramfloat2	float
    //   0	180	6	paramLong	long
    //   19	134	8	localObject	Object
    //   28	108	9	localAtomicReference	java.util.concurrent.atomic.AtomicReference
    //   38	92	10	localAtomicBoolean	AtomicBoolean
    //   61	37	11	localt	t
    //   67	36	12	localaa	aa
    //   79	27	13	localad	ad
    // Exception table:
    //   from	to	target	type
    //   119	126	150	finally
    //   126	129	150	finally
    //   152	155	150	finally
    //   2	119	158	finally
    //   129	145	158	finally
    //   155	158	158	finally
    //   165	175	158	finally
    //   119	126	175	java/lang/InterruptedException
  }
  
  public void a(dg paramdg)
  {
    if (paramdg == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!this.c.compareAndSet(false, true)) {
          continue;
        }
        HandlerThread localHandlerThread = new HandlerThread("TuringFdShark");
        localHandlerThread.start();
        this.b = new aa(localHandlerThread.getLooper(), paramdg);
        Message.obtain(this.b, 1).sendToTarget();
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.z
 * JD-Core Version:    0.7.0.1
 */