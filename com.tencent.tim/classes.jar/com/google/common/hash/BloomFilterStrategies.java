package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.Nullable;

 enum BloomFilterStrategies
  implements BloomFilter.Strategy
{
  MURMUR128_MITZ_32,  MURMUR128_MITZ_64;
  
  private BloomFilterStrategies() {}
  
  static final class BitArray
  {
    long bitCount;
    final long[] data;
    
    BitArray(long paramLong)
    {
      this(new long[Ints.checkedCast(LongMath.divide(paramLong, 64L, RoundingMode.CEILING))]);
    }
    
    BitArray(long[] paramArrayOfLong)
    {
      if (paramArrayOfLong.length > 0) {}
      long l;
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "data length is zero!");
        this.data = paramArrayOfLong;
        l = 0L;
        int j = paramArrayOfLong.length;
        while (i < j)
        {
          l += Long.bitCount(paramArrayOfLong[i]);
          i += 1;
        }
      }
      this.bitCount = l;
    }
    
    long bitCount()
    {
      return this.bitCount;
    }
    
    long bitSize()
    {
      return this.data.length * 64L;
    }
    
    BitArray copy()
    {
      return new BitArray((long[])this.data.clone());
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof BitArray))
      {
        paramObject = (BitArray)paramObject;
        return Arrays.equals(this.data, paramObject.data);
      }
      return false;
    }
    
    boolean get(long paramLong)
    {
      return (this.data[((int)(paramLong >>> 6))] & 1L << (int)paramLong) != 0L;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.data);
    }
    
    void putAll(BitArray paramBitArray)
    {
      int i = 0;
      if (this.data.length == paramBitArray.data.length) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "BitArrays must be of equal length (%s != %s)", this.data.length, paramBitArray.data.length);
        this.bitCount = 0L;
        while (i < this.data.length)
        {
          long[] arrayOfLong = this.data;
          arrayOfLong[i] |= paramBitArray.data[i];
          this.bitCount += Long.bitCount(this.data[i]);
          i += 1;
        }
      }
    }
    
    boolean set(long paramLong)
    {
      if (!get(paramLong))
      {
        long[] arrayOfLong = this.data;
        int i = (int)(paramLong >>> 6);
        arrayOfLong[i] |= 1L << (int)paramLong;
        this.bitCount += 1L;
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.BloomFilterStrategies
 * JD-Core Version:    0.7.0.1
 */