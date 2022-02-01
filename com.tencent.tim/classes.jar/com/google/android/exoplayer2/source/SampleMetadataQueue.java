package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class SampleMetadataQueue
{
  private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
  private int absoluteFirstIndex;
  private int capacity = 1000;
  private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[this.capacity];
  private int[] flags = new int[this.capacity];
  private Format[] formats = new Format[this.capacity];
  private long largestDiscardedTimestampUs = -9223372036854775808L;
  private long largestQueuedTimestampUs = -9223372036854775808L;
  private int length;
  private long[] offsets = new long[this.capacity];
  private int readPosition;
  private int relativeFirstIndex;
  private int[] sizes = new int[this.capacity];
  private int[] sourceIds = new int[this.capacity];
  private long[] timesUs = new long[this.capacity];
  private Format upstreamFormat;
  private boolean upstreamFormatRequired = true;
  private boolean upstreamKeyframeRequired = true;
  private int upstreamSourceId;
  
  private long discardSamples(int paramInt)
  {
    this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(paramInt));
    this.length -= paramInt;
    this.absoluteFirstIndex += paramInt;
    this.relativeFirstIndex += paramInt;
    if (this.relativeFirstIndex >= this.capacity) {
      this.relativeFirstIndex -= this.capacity;
    }
    this.readPosition -= paramInt;
    if (this.readPosition < 0) {
      this.readPosition = 0;
    }
    if (this.length == 0)
    {
      if (this.relativeFirstIndex == 0) {}
      for (paramInt = this.capacity;; paramInt = this.relativeFirstIndex)
      {
        paramInt -= 1;
        long l = this.offsets[paramInt];
        return this.sizes[paramInt] + l;
      }
    }
    return this.offsets[this.relativeFirstIndex];
  }
  
  private int findSampleBefore(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int j = -1;
    int k = 0;
    int i = paramInt1;
    paramInt1 = k;
    while ((paramInt1 < paramInt2) && (this.timesUs[i] <= paramLong))
    {
      if ((!paramBoolean) || ((this.flags[i] & 0x1) != 0)) {
        j = paramInt1;
      }
      k = i + 1;
      i = k;
      if (k == this.capacity) {
        i = 0;
      }
      paramInt1 += 1;
    }
    return j;
  }
  
  private long getLargestTimestamp(int paramInt)
  {
    long l1 = -9223372036854775808L;
    long l2;
    if (paramInt == 0)
    {
      l2 = l1;
      return l2;
    }
    int i = getRelativeIndex(paramInt - 1);
    int j = 0;
    for (;;)
    {
      l2 = l1;
      if (j >= paramInt) {
        break;
      }
      l1 = Math.max(l1, this.timesUs[i]);
      if ((this.flags[i] & 0x1) != 0) {
        return l1;
      }
      int k = i - 1;
      i = k;
      if (k == -1) {
        i = this.capacity - 1;
      }
      j += 1;
    }
  }
  
  private int getRelativeIndex(int paramInt)
  {
    paramInt = this.relativeFirstIndex + paramInt;
    if (paramInt < this.capacity) {
      return paramInt;
    }
    return paramInt - this.capacity;
  }
  
  /* Error */
  public int advanceTo(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: aload_0
    //   7: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   10: invokespecial 95	com/google/android/exoplayer2/source/SampleMetadataQueue:getRelativeIndex	(I)I
    //   13: istore 7
    //   15: iload 6
    //   17: istore 5
    //   19: aload_0
    //   20: invokevirtual 101	com/google/android/exoplayer2/source/SampleMetadataQueue:hasNextSample	()Z
    //   23: ifeq +41 -> 64
    //   26: iload 6
    //   28: istore 5
    //   30: lload_1
    //   31: aload_0
    //   32: getfield 47	com/google/android/exoplayer2/source/SampleMetadataQueue:timesUs	[J
    //   35: iload 7
    //   37: laload
    //   38: lcmp
    //   39: iflt +25 -> 64
    //   42: aload_0
    //   43: getfield 65	com/google/android/exoplayer2/source/SampleMetadataQueue:largestQueuedTimestampUs	J
    //   46: lstore 8
    //   48: lload_1
    //   49: lload 8
    //   51: lcmp
    //   52: ifle +17 -> 69
    //   55: iload 4
    //   57: ifne +12 -> 69
    //   60: iload 6
    //   62: istore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: iload 5
    //   68: ireturn
    //   69: aload_0
    //   70: iload 7
    //   72: aload_0
    //   73: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   76: aload_0
    //   77: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   80: isub
    //   81: lload_1
    //   82: iload_3
    //   83: invokespecial 103	com/google/android/exoplayer2/source/SampleMetadataQueue:findSampleBefore	(IIJZ)I
    //   86: istore 7
    //   88: iload 6
    //   90: istore 5
    //   92: iload 7
    //   94: iconst_m1
    //   95: if_icmpeq -31 -> 64
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   103: iload 7
    //   105: iadd
    //   106: putfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   109: iload 7
    //   111: istore 5
    //   113: goto -49 -> 64
    //   116: astore 10
    //   118: aload_0
    //   119: monitorexit
    //   120: aload 10
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	SampleMetadataQueue
    //   0	123	1	paramLong	long
    //   0	123	3	paramBoolean1	boolean
    //   0	123	4	paramBoolean2	boolean
    //   17	95	5	i	int
    //   1	88	6	j	int
    //   13	97	7	k	int
    //   46	4	8	l	long
    //   116	5	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	15	116	finally
    //   19	26	116	finally
    //   30	48	116	finally
    //   69	88	116	finally
    //   98	109	116	finally
  }
  
  public int advanceToEnd()
  {
    try
    {
      int i = this.length;
      int j = this.readPosition;
      this.readPosition = this.length;
      return i - j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean attemptSplice(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   9: ifne +27 -> 36
    //   12: aload_0
    //   13: getfield 63	com/google/android/exoplayer2/source/SampleMetadataQueue:largestDiscardedTimestampUs	J
    //   16: lstore 7
    //   18: lload_1
    //   19: lload 7
    //   21: lcmp
    //   22: ifle +8 -> 30
    //   25: aload_0
    //   26: monitorexit
    //   27: iload 9
    //   29: ireturn
    //   30: iconst_0
    //   31: istore 9
    //   33: goto -8 -> 25
    //   36: aload_0
    //   37: getfield 63	com/google/android/exoplayer2/source/SampleMetadataQueue:largestDiscardedTimestampUs	J
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   45: invokespecial 75	com/google/android/exoplayer2/source/SampleMetadataQueue:getLargestTimestamp	(I)J
    //   48: invokestatic 81	java/lang/Math:max	(JJ)J
    //   51: lload_1
    //   52: lcmp
    //   53: iflt +9 -> 62
    //   56: iconst_0
    //   57: istore 9
    //   59: goto -34 -> 25
    //   62: aload_0
    //   63: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   66: istore 4
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   73: iconst_1
    //   74: isub
    //   75: invokespecial 95	com/google/android/exoplayer2/source/SampleMetadataQueue:getRelativeIndex	(I)I
    //   78: istore_3
    //   79: iload 4
    //   81: aload_0
    //   82: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   85: if_icmple +52 -> 137
    //   88: aload_0
    //   89: getfield 47	com/google/android/exoplayer2/source/SampleMetadataQueue:timesUs	[J
    //   92: iload_3
    //   93: laload
    //   94: lload_1
    //   95: lcmp
    //   96: iflt +41 -> 137
    //   99: iload 4
    //   101: iconst_1
    //   102: isub
    //   103: istore 5
    //   105: iload_3
    //   106: iconst_1
    //   107: isub
    //   108: istore 6
    //   110: iload 6
    //   112: istore_3
    //   113: iload 5
    //   115: istore 4
    //   117: iload 6
    //   119: iconst_m1
    //   120: if_icmpne -41 -> 79
    //   123: aload_0
    //   124: getfield 41	com/google/android/exoplayer2/source/SampleMetadataQueue:capacity	I
    //   127: iconst_1
    //   128: isub
    //   129: istore_3
    //   130: iload 5
    //   132: istore 4
    //   134: goto -55 -> 79
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 85	com/google/android/exoplayer2/source/SampleMetadataQueue:absoluteFirstIndex	I
    //   142: iload 4
    //   144: iadd
    //   145: invokevirtual 110	com/google/android/exoplayer2/source/SampleMetadataQueue:discardUpstreamSamples	(I)J
    //   148: pop2
    //   149: goto -124 -> 25
    //   152: astore 10
    //   154: aload_0
    //   155: monitorexit
    //   156: aload 10
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	SampleMetadataQueue
    //   0	159	1	paramLong	long
    //   78	52	3	i	int
    //   66	79	4	j	int
    //   103	28	5	k	int
    //   108	13	6	m	int
    //   16	4	7	l	long
    //   1	57	9	bool	boolean
    //   152	5	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	18	152	finally
    //   36	56	152	finally
    //   62	79	152	finally
    //   79	99	152	finally
    //   123	130	152	finally
    //   137	149	152	finally
  }
  
  public void commitSample(long paramLong1, int paramInt1, long paramLong2, int paramInt2, TrackOutput.CryptoData paramCryptoData)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.upstreamKeyframeRequired;
        if (bool)
        {
          if ((paramInt1 & 0x1) == 0) {
            return;
          }
          this.upstreamKeyframeRequired = false;
        }
        if (!this.upstreamFormatRequired)
        {
          bool = true;
          Assertions.checkState(bool);
          commitSampleTimestamp(paramLong1);
          int i = getRelativeIndex(this.length);
          this.timesUs[i] = paramLong1;
          this.offsets[i] = paramLong2;
          this.sizes[i] = paramInt2;
          this.flags[i] = paramInt1;
          this.cryptoDatas[i] = paramCryptoData;
          this.formats[i] = this.upstreamFormat;
          this.sourceIds[i] = this.upstreamSourceId;
          this.length += 1;
          if (this.length == this.capacity)
          {
            paramInt1 = this.capacity + 1000;
            paramCryptoData = new int[paramInt1];
            long[] arrayOfLong1 = new long[paramInt1];
            long[] arrayOfLong2 = new long[paramInt1];
            int[] arrayOfInt1 = new int[paramInt1];
            int[] arrayOfInt2 = new int[paramInt1];
            TrackOutput.CryptoData[] arrayOfCryptoData = new TrackOutput.CryptoData[paramInt1];
            Format[] arrayOfFormat = new Format[paramInt1];
            paramInt2 = this.capacity - this.relativeFirstIndex;
            System.arraycopy(this.offsets, this.relativeFirstIndex, arrayOfLong1, 0, paramInt2);
            System.arraycopy(this.timesUs, this.relativeFirstIndex, arrayOfLong2, 0, paramInt2);
            System.arraycopy(this.flags, this.relativeFirstIndex, arrayOfInt1, 0, paramInt2);
            System.arraycopy(this.sizes, this.relativeFirstIndex, arrayOfInt2, 0, paramInt2);
            System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, arrayOfCryptoData, 0, paramInt2);
            System.arraycopy(this.formats, this.relativeFirstIndex, arrayOfFormat, 0, paramInt2);
            System.arraycopy(this.sourceIds, this.relativeFirstIndex, paramCryptoData, 0, paramInt2);
            i = this.relativeFirstIndex;
            System.arraycopy(this.offsets, 0, arrayOfLong1, paramInt2, i);
            System.arraycopy(this.timesUs, 0, arrayOfLong2, paramInt2, i);
            System.arraycopy(this.flags, 0, arrayOfInt1, paramInt2, i);
            System.arraycopy(this.sizes, 0, arrayOfInt2, paramInt2, i);
            System.arraycopy(this.cryptoDatas, 0, arrayOfCryptoData, paramInt2, i);
            System.arraycopy(this.formats, 0, arrayOfFormat, paramInt2, i);
            System.arraycopy(this.sourceIds, 0, paramCryptoData, paramInt2, i);
            this.offsets = arrayOfLong1;
            this.timesUs = arrayOfLong2;
            this.flags = arrayOfInt1;
            this.sizes = arrayOfInt2;
            this.cryptoDatas = arrayOfCryptoData;
            this.formats = arrayOfFormat;
            this.sourceIds = paramCryptoData;
            this.relativeFirstIndex = 0;
            this.length = this.capacity;
            this.capacity = paramInt1;
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public void commitSampleTimestamp(long paramLong)
  {
    try
    {
      this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public long discardTo(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   6: ifeq +21 -> 27
    //   9: aload_0
    //   10: getfield 47	com/google/android/exoplayer2/source/SampleMetadataQueue:timesUs	[J
    //   13: aload_0
    //   14: getfield 87	com/google/android/exoplayer2/source/SampleMetadataQueue:relativeFirstIndex	I
    //   17: laload
    //   18: lstore 6
    //   20: lload_1
    //   21: lload 6
    //   23: lcmp
    //   24: ifge +11 -> 35
    //   27: ldc2_w 135
    //   30: lstore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: lload_1
    //   34: lreturn
    //   35: iload 4
    //   37: ifeq +49 -> 86
    //   40: aload_0
    //   41: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   44: aload_0
    //   45: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   48: if_icmpeq +38 -> 86
    //   51: aload_0
    //   52: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   55: iconst_1
    //   56: iadd
    //   57: istore 5
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 87	com/google/android/exoplayer2/source/SampleMetadataQueue:relativeFirstIndex	I
    //   64: iload 5
    //   66: lload_1
    //   67: iload_3
    //   68: invokespecial 103	com/google/android/exoplayer2/source/SampleMetadataQueue:findSampleBefore	(IIJZ)I
    //   71: istore 5
    //   73: iload 5
    //   75: iconst_m1
    //   76: if_icmpne +19 -> 95
    //   79: ldc2_w 135
    //   82: lstore_1
    //   83: goto -52 -> 31
    //   86: aload_0
    //   87: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   90: istore 5
    //   92: goto -33 -> 59
    //   95: aload_0
    //   96: iload 5
    //   98: invokespecial 138	com/google/android/exoplayer2/source/SampleMetadataQueue:discardSamples	(I)J
    //   101: lstore_1
    //   102: goto -71 -> 31
    //   105: astore 8
    //   107: aload_0
    //   108: monitorexit
    //   109: aload 8
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	SampleMetadataQueue
    //   0	112	1	paramLong	long
    //   0	112	3	paramBoolean1	boolean
    //   0	112	4	paramBoolean2	boolean
    //   57	40	5	i	int
    //   18	4	6	l	long
    //   105	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	105	finally
    //   40	59	105	finally
    //   59	73	105	finally
    //   86	92	105	finally
    //   95	102	105	finally
  }
  
  /* Error */
  public long discardToEnd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +11 -> 19
    //   11: ldc2_w 135
    //   14: lstore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_2
    //   18: lreturn
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   24: invokespecial 138	com/google/android/exoplayer2/source/SampleMetadataQueue:discardSamples	(I)J
    //   27: lstore_2
    //   28: goto -13 -> 15
    //   31: astore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	SampleMetadataQueue
    //   6	2	1	i	int
    //   14	14	2	l	long
    //   31	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   19	28	31	finally
  }
  
  /* Error */
  public long discardToRead()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +11 -> 19
    //   11: ldc2_w 135
    //   14: lstore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_2
    //   18: lreturn
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   24: invokespecial 138	com/google/android/exoplayer2/source/SampleMetadataQueue:discardSamples	(I)J
    //   27: lstore_2
    //   28: goto -13 -> 15
    //   31: astore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	SampleMetadataQueue
    //   6	2	1	i	int
    //   14	14	2	l	long
    //   31	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	31	finally
    //   19	28	31	finally
  }
  
  public long discardUpstreamSamples(int paramInt)
  {
    paramInt = getWriteIndex() - paramInt;
    if ((paramInt >= 0) && (paramInt <= this.length - this.readPosition)) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      this.length -= paramInt;
      this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.length));
      if (this.length != 0) {
        break;
      }
      return 0L;
    }
    paramInt = getRelativeIndex(this.length - 1);
    long l = this.offsets[paramInt];
    return this.sizes[paramInt] + l;
  }
  
  public boolean format(Format paramFormat)
  {
    boolean bool = false;
    if (paramFormat == null) {}
    for (;;)
    {
      try
      {
        this.upstreamFormatRequired = true;
        return bool;
      }
      finally {}
      this.upstreamFormatRequired = false;
      if (!Util.areEqual(paramFormat, this.upstreamFormat))
      {
        this.upstreamFormat = paramFormat;
        bool = true;
      }
    }
  }
  
  public int getFirstIndex()
  {
    return this.absoluteFirstIndex;
  }
  
  /* Error */
  public long getFirstTimestampUs()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +11 -> 19
    //   11: ldc2_w 60
    //   14: lstore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_2
    //   18: lreturn
    //   19: aload_0
    //   20: getfield 47	com/google/android/exoplayer2/source/SampleMetadataQueue:timesUs	[J
    //   23: aload_0
    //   24: getfield 87	com/google/android/exoplayer2/source/SampleMetadataQueue:relativeFirstIndex	I
    //   27: laload
    //   28: lstore_2
    //   29: goto -14 -> 15
    //   32: astore 4
    //   34: aload_0
    //   35: monitorexit
    //   36: aload 4
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	SampleMetadataQueue
    //   6	2	1	i	int
    //   14	15	2	l	long
    //   32	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	32	finally
    //   19	29	32	finally
  }
  
  public long getLargestQueuedTimestampUs()
  {
    try
    {
      long l = this.largestQueuedTimestampUs;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getReadIndex()
  {
    return this.absoluteFirstIndex + this.readPosition;
  }
  
  /* Error */
  public Format getUpstreamFormat()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 67	com/google/android/exoplayer2/source/SampleMetadataQueue:upstreamFormatRequired	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 124	com/google/android/exoplayer2/source/SampleMetadataQueue:upstreamFormat	Lcom/google/android/exoplayer2/Format;
    //   21: astore_2
    //   22: goto -9 -> 13
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	SampleMetadataQueue
    //   6	2	1	bool	boolean
    //   12	10	2	localFormat	Format
    //   25	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public int getWriteIndex()
  {
    return this.absoluteFirstIndex + this.length;
  }
  
  /* Error */
  public boolean hasNextSample()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   11: istore_2
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpeq +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	SampleMetadataQueue
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   18	7	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  public int peekSourceId()
  {
    int i = getRelativeIndex(this.readPosition);
    if (hasNextSample()) {
      return this.sourceIds[i];
    }
    return this.upstreamSourceId;
  }
  
  public int read(FormatHolder paramFormatHolder, DecoderInputBuffer paramDecoderInputBuffer, boolean paramBoolean1, boolean paramBoolean2, Format paramFormat, SampleExtrasHolder paramSampleExtrasHolder)
  {
    int i = -4;
    for (;;)
    {
      try
      {
        if (!hasNextSample())
        {
          if (paramBoolean2)
          {
            paramDecoderInputBuffer.setFlags(4);
            return i;
          }
          if ((this.upstreamFormat != null) && ((paramBoolean1) || (this.upstreamFormat != paramFormat)))
          {
            paramFormatHolder.format = this.upstreamFormat;
            i = -5;
            continue;
          }
        }
        else
        {
          int j = getRelativeIndex(this.readPosition);
          if ((paramBoolean1) || (this.formats[j] != paramFormat))
          {
            paramFormatHolder.format = this.formats[j];
            i = -5;
            continue;
          }
          if (paramDecoderInputBuffer.isFlagsOnly())
          {
            i = -3;
            continue;
          }
          paramDecoderInputBuffer.timeUs = this.timesUs[j];
          paramDecoderInputBuffer.setFlags(this.flags[j]);
          paramSampleExtrasHolder.size = this.sizes[j];
          paramSampleExtrasHolder.offset = this.offsets[j];
          paramSampleExtrasHolder.cryptoData = this.cryptoDatas[j];
          this.readPosition += 1;
          continue;
        }
        i = -3;
      }
      finally {}
    }
  }
  
  public void reset(boolean paramBoolean)
  {
    this.length = 0;
    this.absoluteFirstIndex = 0;
    this.relativeFirstIndex = 0;
    this.readPosition = 0;
    this.upstreamKeyframeRequired = true;
    this.largestDiscardedTimestampUs = -9223372036854775808L;
    this.largestQueuedTimestampUs = -9223372036854775808L;
    if (paramBoolean)
    {
      this.upstreamFormat = null;
      this.upstreamFormatRequired = true;
    }
  }
  
  public void rewind()
  {
    try
    {
      this.readPosition = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean setReadPosition(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	com/google/android/exoplayer2/source/SampleMetadataQueue:absoluteFirstIndex	I
    //   6: iload_1
    //   7: if_icmpgt +32 -> 39
    //   10: iload_1
    //   11: aload_0
    //   12: getfield 85	com/google/android/exoplayer2/source/SampleMetadataQueue:absoluteFirstIndex	I
    //   15: aload_0
    //   16: getfield 83	com/google/android/exoplayer2/source/SampleMetadataQueue:length	I
    //   19: iadd
    //   20: if_icmpgt +19 -> 39
    //   23: aload_0
    //   24: iload_1
    //   25: aload_0
    //   26: getfield 85	com/google/android/exoplayer2/source/SampleMetadataQueue:absoluteFirstIndex	I
    //   29: isub
    //   30: putfield 89	com/google/android/exoplayer2/source/SampleMetadataQueue:readPosition	I
    //   33: iconst_1
    //   34: istore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: iconst_0
    //   40: istore_2
    //   41: goto -6 -> 35
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	SampleMetadataQueue
    //   0	49	1	paramInt	int
    //   34	7	2	bool	boolean
    //   44	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	44	finally
  }
  
  public void sourceId(int paramInt)
  {
    this.upstreamSourceId = paramInt;
  }
  
  public static final class SampleExtrasHolder
  {
    public TrackOutput.CryptoData cryptoData;
    public long offset;
    public int size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.SampleMetadataQueue
 * JD-Core Version:    0.7.0.1
 */