package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.annotations.Experimental;

@Experimental
public final class BackpressureDrainManager
  extends AtomicLong
  implements Producer
{
  protected final BackpressureQueueCallback actual;
  protected boolean emitting;
  protected Throwable exception;
  protected volatile boolean terminated;
  
  public BackpressureDrainManager(BackpressureQueueCallback paramBackpressureQueueCallback)
  {
    this.actual = paramBackpressureQueueCallback;
  }
  
  /* Error */
  public final void drain()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 28	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   17: aload_0
    //   18: getfield 30	rx/internal/util/BackpressureDrainManager:terminated	Z
    //   21: istore 4
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_0
    //   26: invokevirtual 34	rx/internal/util/BackpressureDrainManager:get	()J
    //   29: lstore 6
    //   31: iconst_0
    //   32: istore_3
    //   33: iload_3
    //   34: istore_1
    //   35: aload_0
    //   36: getfield 24	rx/internal/util/BackpressureDrainManager:actual	Lrx/internal/util/BackpressureDrainManager$BackpressureQueueCallback;
    //   39: astore 10
    //   41: goto +261 -> 302
    //   44: iload 4
    //   46: ifeq +135 -> 181
    //   49: iload_3
    //   50: istore_1
    //   51: aload 10
    //   53: invokeinterface 38 1 0
    //   58: ifnonnull +42 -> 100
    //   61: iconst_1
    //   62: istore_1
    //   63: aload 10
    //   65: aload_0
    //   66: getfield 40	rx/internal/util/BackpressureDrainManager:exception	Ljava/lang/Throwable;
    //   69: invokeinterface 44 2 0
    //   74: return
    //   75: astore 10
    //   77: iload_1
    //   78: ifne +12 -> 90
    //   81: aload_0
    //   82: monitorenter
    //   83: aload_0
    //   84: iconst_0
    //   85: putfield 28	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   88: aload_0
    //   89: monitorexit
    //   90: aload 10
    //   92: athrow
    //   93: astore 10
    //   95: aload_0
    //   96: monitorexit
    //   97: aload 10
    //   99: athrow
    //   100: lload 6
    //   102: lconst_0
    //   103: lcmp
    //   104: ifne +77 -> 181
    //   107: iload_3
    //   108: istore_1
    //   109: aload_0
    //   110: monitorenter
    //   111: aload_0
    //   112: getfield 30	rx/internal/util/BackpressureDrainManager:terminated	Z
    //   115: istore 4
    //   117: aload 10
    //   119: invokeinterface 38 1 0
    //   124: ifnull +104 -> 228
    //   127: iconst_1
    //   128: istore_1
    //   129: aload_0
    //   130: invokevirtual 34	rx/internal/util/BackpressureDrainManager:get	()J
    //   133: lstore 6
    //   135: lload 6
    //   137: ldc2_w 45
    //   140: lcmp
    //   141: ifne +102 -> 243
    //   144: iload_1
    //   145: ifne +88 -> 233
    //   148: iload 4
    //   150: ifne +83 -> 233
    //   153: iconst_1
    //   154: istore_2
    //   155: iload_2
    //   156: istore_1
    //   157: aload_0
    //   158: iconst_0
    //   159: putfield 28	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   162: iload_2
    //   163: istore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: return
    //   167: iload_2
    //   168: istore_1
    //   169: aload_0
    //   170: monitorexit
    //   171: aload 10
    //   173: athrow
    //   174: astore 10
    //   176: iload_2
    //   177: istore_1
    //   178: goto -101 -> 77
    //   181: iload_3
    //   182: istore_1
    //   183: aload 10
    //   185: invokeinterface 49 1 0
    //   190: astore 11
    //   192: aload 11
    //   194: ifnull -87 -> 107
    //   197: iload_3
    //   198: istore_1
    //   199: aload 10
    //   201: aload 11
    //   203: invokeinterface 53 2 0
    //   208: istore 5
    //   210: iload 5
    //   212: ifne +89 -> 301
    //   215: lload 6
    //   217: lconst_1
    //   218: lsub
    //   219: lstore 6
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto +79 -> 304
    //   228: iconst_0
    //   229: istore_1
    //   230: goto -101 -> 129
    //   233: ldc2_w 45
    //   236: lstore 6
    //   238: aload_0
    //   239: monitorexit
    //   240: goto +62 -> 302
    //   243: aload_0
    //   244: iload_2
    //   245: ineg
    //   246: i2l
    //   247: invokevirtual 57	rx/internal/util/BackpressureDrainManager:addAndGet	(J)J
    //   250: lstore 8
    //   252: lload 8
    //   254: lconst_0
    //   255: lcmp
    //   256: ifeq +11 -> 267
    //   259: lload 8
    //   261: lstore 6
    //   263: iload_1
    //   264: ifne -26 -> 238
    //   267: iload 4
    //   269: ifeq +11 -> 280
    //   272: lload 8
    //   274: lstore 6
    //   276: iload_1
    //   277: ifeq -39 -> 238
    //   280: iconst_1
    //   281: istore_2
    //   282: iload_2
    //   283: istore_1
    //   284: aload_0
    //   285: iconst_0
    //   286: putfield 28	rx/internal/util/BackpressureDrainManager:emitting	Z
    //   289: iload_2
    //   290: istore_1
    //   291: aload_0
    //   292: monitorexit
    //   293: return
    //   294: astore 10
    //   296: aload_0
    //   297: monitorexit
    //   298: aload 10
    //   300: athrow
    //   301: return
    //   302: iconst_0
    //   303: istore_2
    //   304: lload 6
    //   306: lconst_0
    //   307: lcmp
    //   308: ifgt -264 -> 44
    //   311: iload 4
    //   313: ifeq -206 -> 107
    //   316: goto -272 -> 44
    //   319: astore 10
    //   321: iload_1
    //   322: istore_2
    //   323: goto -156 -> 167
    //   326: astore 10
    //   328: iconst_0
    //   329: istore_2
    //   330: goto -163 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	BackpressureDrainManager
    //   34	288	1	i	int
    //   154	176	2	j	int
    //   32	166	3	k	int
    //   21	291	4	bool1	boolean
    //   208	3	5	bool2	boolean
    //   29	276	6	l1	long
    //   250	23	8	l2	long
    //   39	25	10	localBackpressureQueueCallback	BackpressureQueueCallback
    //   75	16	10	localObject1	Object
    //   93	79	10	localObject2	Object
    //   174	26	10	localObject3	Object
    //   294	5	10	localObject4	Object
    //   319	1	10	localObject5	Object
    //   326	1	10	localObject6	Object
    //   190	12	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   35	41	75	finally
    //   51	61	75	finally
    //   63	74	75	finally
    //   109	111	75	finally
    //   183	192	75	finally
    //   199	210	75	finally
    //   2	11	93	finally
    //   12	25	93	finally
    //   95	97	93	finally
    //   171	174	174	finally
    //   83	90	294	finally
    //   296	298	294	finally
    //   157	162	319	finally
    //   164	166	319	finally
    //   169	171	319	finally
    //   284	289	319	finally
    //   291	293	319	finally
    //   111	127	326	finally
    //   129	135	326	finally
    //   238	240	326	finally
    //   243	252	326	finally
  }
  
  public final boolean isTerminated()
  {
    return this.terminated;
  }
  
  public final void request(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    label31:
    label70:
    label98:
    for (;;)
    {
      long l2 = get();
      if (l2 == 0L) {}
      for (int i = 1; l2 == 9223372036854775807L; i = 0)
      {
        if (i == 0) {
          break label70;
        }
        drain();
        return;
      }
      long l1;
      if (paramLong == 9223372036854775807L)
      {
        l1 = paramLong;
        i = 1;
      }
      for (;;)
      {
        if (!compareAndSet(l2, l1)) {
          break label98;
        }
        break label31;
        break;
        if (l2 > 9223372036854775807L - paramLong) {
          l1 = 9223372036854775807L;
        } else {
          l1 = l2 + paramLong;
        }
      }
    }
  }
  
  public final void terminate()
  {
    this.terminated = true;
  }
  
  public final void terminate(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.exception = paramThrowable;
      this.terminated = true;
    }
  }
  
  public final void terminateAndDrain()
  {
    this.terminated = true;
    drain();
  }
  
  public final void terminateAndDrain(Throwable paramThrowable)
  {
    if (!this.terminated)
    {
      this.exception = paramThrowable;
      this.terminated = true;
      drain();
    }
  }
  
  public static abstract interface BackpressureQueueCallback
  {
    public abstract boolean accept(Object paramObject);
    
    public abstract void complete(Throwable paramThrowable);
    
    public abstract Object peek();
    
    public abstract Object poll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.util.BackpressureDrainManager
 * JD-Core Version:    0.7.0.1
 */