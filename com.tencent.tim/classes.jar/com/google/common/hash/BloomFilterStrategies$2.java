package com.google.common.hash;

import com.google.common.primitives.Longs;

 enum BloomFilterStrategies$2
{
  BloomFilterStrategies$2()
  {
    super(str, i, null);
  }
  
  private long lowerEight(byte[] paramArrayOfByte)
  {
    return Longs.fromBytes(paramArrayOfByte[7], paramArrayOfByte[6], paramArrayOfByte[5], paramArrayOfByte[4], paramArrayOfByte[3], paramArrayOfByte[2], paramArrayOfByte[1], paramArrayOfByte[0]);
  }
  
  private long upperEight(byte[] paramArrayOfByte)
  {
    return Longs.fromBytes(paramArrayOfByte[15], paramArrayOfByte[14], paramArrayOfByte[13], paramArrayOfByte[12], paramArrayOfByte[11], paramArrayOfByte[10], paramArrayOfByte[9], paramArrayOfByte[8]);
  }
  
  public <T> boolean mightContain(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray)
  {
    long l2 = paramBitArray.bitSize();
    paramT = Hashing.murmur3_128().hashObject(paramT, paramFunnel).getBytesInternal();
    long l1 = lowerEight(paramT);
    long l3 = upperEight(paramT);
    int i = 0;
    while (i < paramInt)
    {
      if (!paramBitArray.get((0xFFFFFFFF & l1) % l2)) {
        return false;
      }
      l1 += l3;
      i += 1;
    }
    return true;
  }
  
  public <T> boolean put(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray)
  {
    int i = 0;
    long l2 = paramBitArray.bitSize();
    paramT = Hashing.murmur3_128().hashObject(paramT, paramFunnel).getBytesInternal();
    long l1 = lowerEight(paramT);
    long l3 = upperEight(paramT);
    boolean bool = false;
    while (i < paramInt)
    {
      bool |= paramBitArray.set((0xFFFFFFFF & l1) % l2);
      l1 += l3;
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.BloomFilterStrategies.2
 * JD-Core Version:    0.7.0.1
 */