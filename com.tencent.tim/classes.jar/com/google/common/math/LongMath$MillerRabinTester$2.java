package com.google.common.math;

import com.google.common.primitives.UnsignedLongs;

 enum LongMath$MillerRabinTester$2
{
  LongMath$MillerRabinTester$2()
  {
    super(str, i, null);
  }
  
  private long plusMod(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 >= paramLong3 - paramLong2) {
      return paramLong1 + paramLong2 - paramLong3;
    }
    return paramLong1 + paramLong2;
  }
  
  private long times2ToThe32Mod(long paramLong1, long paramLong2)
  {
    int i = 32;
    int j;
    long l;
    do
    {
      j = Math.min(i, Long.numberOfLeadingZeros(paramLong1));
      l = UnsignedLongs.remainder(paramLong1 << j, paramLong2);
      j = i - j;
      i = j;
      paramLong1 = l;
    } while (j > 0);
    return l;
  }
  
  long mulMod(long paramLong1, long paramLong2, long paramLong3)
  {
    long l4 = paramLong1 >>> 32;
    long l1 = paramLong2 >>> 32;
    long l2 = 0xFFFFFFFF & paramLong1;
    long l3 = 0xFFFFFFFF & paramLong2;
    paramLong2 = l4 * l3 + times2ToThe32Mod(l4 * l1, paramLong3);
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = UnsignedLongs.remainder(paramLong2, paramLong3);
    }
    return plusMod(times2ToThe32Mod(paramLong1 + l1 * l2, paramLong3), UnsignedLongs.remainder(l2 * l3, paramLong3), paramLong3);
  }
  
  long squareMod(long paramLong1, long paramLong2)
  {
    long l1 = paramLong1 >>> 32;
    long l2 = paramLong1 & 0xFFFFFFFF;
    long l3 = times2ToThe32Mod(l1 * l1, paramLong2);
    l1 = l1 * l2 * 2L;
    paramLong1 = l1;
    if (l1 < 0L) {
      paramLong1 = UnsignedLongs.remainder(l1, paramLong2);
    }
    return plusMod(times2ToThe32Mod(paramLong1 + l3, paramLong2), UnsignedLongs.remainder(l2 * l2, paramLong2), paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.math.LongMath.MillerRabinTester.2
 * JD-Core Version:    0.7.0.1
 */