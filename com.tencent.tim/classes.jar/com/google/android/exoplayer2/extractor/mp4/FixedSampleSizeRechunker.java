package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Util;

final class FixedSampleSizeRechunker
{
  private static final int MAX_SAMPLE_SIZE = 8192;
  
  public static Results rechunk(int paramInt, long[] paramArrayOfLong, int[] paramArrayOfInt, long paramLong)
  {
    int i2 = 8192 / paramInt;
    int k = paramArrayOfInt.length;
    int j = 0;
    for (int i = 0; j < k; i = m + i)
    {
      m = Util.ceilDivide(paramArrayOfInt[j], i2);
      j += 1;
    }
    long[] arrayOfLong1 = new long[i];
    int[] arrayOfInt1 = new int[i];
    long[] arrayOfLong2 = new long[i];
    int[] arrayOfInt2 = new int[i];
    int m = 0;
    j = 0;
    k = 0;
    i = 0;
    while (m < paramArrayOfInt.length)
    {
      int n = paramArrayOfInt[m];
      long l = paramArrayOfLong[m];
      int i1 = k;
      k = j;
      j = i1;
      while (n > 0)
      {
        i1 = Math.min(i2, n);
        arrayOfLong1[i] = l;
        arrayOfInt1[i] = (paramInt * i1);
        k = Math.max(k, arrayOfInt1[i]);
        arrayOfLong2[i] = (j * paramLong);
        arrayOfInt2[i] = 1;
        l += arrayOfInt1[i];
        i += 1;
        n -= i1;
        j += i1;
      }
      m += 1;
      n = k;
      k = j;
      j = n;
    }
    return new Results(arrayOfLong1, arrayOfInt1, j, arrayOfLong2, arrayOfInt2, k * paramLong, null);
  }
  
  public static final class Results
  {
    public final long duration;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timestamps;
    
    private Results(long[] paramArrayOfLong1, int[] paramArrayOfInt1, int paramInt, long[] paramArrayOfLong2, int[] paramArrayOfInt2, long paramLong)
    {
      this.offsets = paramArrayOfLong1;
      this.sizes = paramArrayOfInt1;
      this.maximumSize = paramInt;
      this.timestamps = paramArrayOfLong2;
      this.flags = paramArrayOfInt2;
      this.duration = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker
 * JD-Core Version:    0.7.0.1
 */