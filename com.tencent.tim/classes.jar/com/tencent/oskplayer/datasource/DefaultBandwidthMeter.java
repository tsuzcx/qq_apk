package com.tencent.oskplayer.datasource;

import android.os.Handler;

public class DefaultBandwidthMeter
  implements BandwidthMeter
{
  public static final int DEFAULT_MAX_WEIGHT = 2000;
  private static long bitrateEstimate;
  private static int elapsedMs;
  private static long sBitrate;
  private long bytesAccumulator;
  private final Clock clock;
  private final Handler eventHandler;
  private final BandwidthMeter.EventListener eventListener;
  private final SlidingPercentile slidingPercentile;
  private long startTimeMs;
  private int streamCount;
  
  public DefaultBandwidthMeter()
  {
    this(null, null);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener)
  {
    this(paramHandler, paramEventListener, new SystemClock());
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, int paramInt)
  {
    this(paramHandler, paramEventListener, new SystemClock(), paramInt);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, Clock paramClock)
  {
    this(paramHandler, paramEventListener, paramClock, 2000);
  }
  
  public DefaultBandwidthMeter(Handler paramHandler, BandwidthMeter.EventListener paramEventListener, Clock paramClock, int paramInt)
  {
    this.eventHandler = paramHandler;
    this.eventListener = paramEventListener;
    this.clock = paramClock;
    this.slidingPercentile = new SlidingPercentile(paramInt);
    bitrateEstimate = -1L;
  }
  
  public static long getBitrate()
  {
    try
    {
      long l = sBitrate;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int getElapsedMs()
  {
    try
    {
      int i = elapsedMs;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void notifyBandwidthSample(int paramInt, long paramLong1, long paramLong2)
  {
    if ((this.eventHandler != null) && (this.eventListener != null)) {
      this.eventHandler.post(new DefaultBandwidthMeter.1(this, paramInt, paramLong1, paramLong2));
    }
  }
  
  public long getBitrateEstimate()
  {
    try
    {
      long l = bitrateEstimate;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onBytesTransferred(int paramInt)
  {
    try
    {
      this.bytesAccumulator += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void onTransferEnd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:streamCount	I
    //   6: ifle +145 -> 151
    //   9: iconst_1
    //   10: istore_2
    //   11: iload_2
    //   12: invokestatic 95	com/tencent/oskplayer/util/Assertions:checkState	(Z)V
    //   15: aload_0
    //   16: getfield 48	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:clock	Lcom/tencent/oskplayer/datasource/Clock;
    //   19: invokeinterface 100 1 0
    //   24: lstore 5
    //   26: lload 5
    //   28: aload_0
    //   29: getfield 102	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:startTimeMs	J
    //   32: lsub
    //   33: l2i
    //   34: putstatic 69	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:elapsedMs	I
    //   37: getstatic 69	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:elapsedMs	I
    //   40: ifle +80 -> 120
    //   43: aload_0
    //   44: getfield 86	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:bytesAccumulator	J
    //   47: ldc2_w 103
    //   50: lmul
    //   51: getstatic 69	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:elapsedMs	I
    //   54: i2l
    //   55: ldiv
    //   56: l2f
    //   57: fstore_1
    //   58: aload_0
    //   59: getfield 55	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:slidingPercentile	Lcom/tencent/oskplayer/datasource/SlidingPercentile;
    //   62: aload_0
    //   63: getfield 86	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:bytesAccumulator	J
    //   66: l2d
    //   67: invokestatic 110	java/lang/Math:sqrt	(D)D
    //   70: d2i
    //   71: fload_1
    //   72: invokevirtual 114	com/tencent/oskplayer/datasource/SlidingPercentile:addSample	(IF)V
    //   75: aload_0
    //   76: getfield 55	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:slidingPercentile	Lcom/tencent/oskplayer/datasource/SlidingPercentile;
    //   79: ldc 115
    //   81: invokevirtual 119	com/tencent/oskplayer/datasource/SlidingPercentile:getPercentile	(F)F
    //   84: fstore_1
    //   85: fload_1
    //   86: invokestatic 125	java/lang/Float:isNaN	(F)Z
    //   89: ifeq +67 -> 156
    //   92: ldc2_w 56
    //   95: lstore_3
    //   96: lload_3
    //   97: putstatic 59	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:bitrateEstimate	J
    //   100: getstatic 59	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:bitrateEstimate	J
    //   103: putstatic 65	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:sBitrate	J
    //   106: aload_0
    //   107: getstatic 69	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:elapsedMs	I
    //   110: aload_0
    //   111: getfield 86	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:bytesAccumulator	J
    //   114: getstatic 59	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:bitrateEstimate	J
    //   117: invokespecial 127	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:notifyBandwidthSample	(IJJ)V
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 89	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:streamCount	I
    //   125: iconst_1
    //   126: isub
    //   127: putfield 89	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:streamCount	I
    //   130: aload_0
    //   131: getfield 89	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:streamCount	I
    //   134: ifle +9 -> 143
    //   137: aload_0
    //   138: lload 5
    //   140: putfield 102	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:startTimeMs	J
    //   143: aload_0
    //   144: lconst_0
    //   145: putfield 86	com/tencent/oskplayer/datasource/DefaultBandwidthMeter:bytesAccumulator	J
    //   148: aload_0
    //   149: monitorexit
    //   150: return
    //   151: iconst_0
    //   152: istore_2
    //   153: goto -142 -> 11
    //   156: fload_1
    //   157: f2l
    //   158: lstore_3
    //   159: goto -63 -> 96
    //   162: astore 7
    //   164: aload_0
    //   165: monitorexit
    //   166: aload 7
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	DefaultBandwidthMeter
    //   57	100	1	f	float
    //   10	143	2	bool	boolean
    //   95	64	3	l1	long
    //   24	115	5	l2	long
    //   162	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	162	finally
    //   11	92	162	finally
    //   96	120	162	finally
    //   120	143	162	finally
    //   143	148	162	finally
  }
  
  public void onTransferStart()
  {
    try
    {
      if (this.streamCount == 0) {
        this.startTimeMs = this.clock.elapsedRealtime();
      }
      this.streamCount += 1;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultBandwidthMeter
 * JD-Core Version:    0.7.0.1
 */