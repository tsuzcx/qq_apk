package com.google.common.hash;

 enum BloomFilterStrategies$1
{
  BloomFilterStrategies$1()
  {
    super(str, i, null);
  }
  
  public <T> boolean mightContain(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray)
  {
    long l1 = paramBitArray.bitSize();
    long l2 = Hashing.murmur3_128().hashObject(paramT, paramFunnel).asLong();
    int m = (int)l2;
    int n = (int)(l2 >>> 32);
    int i = 1;
    while (i <= paramInt)
    {
      int k = i * n + m;
      int j = k;
      if (k < 0) {
        j = k ^ 0xFFFFFFFF;
      }
      if (!paramBitArray.get(j % l1)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public <T> boolean put(T paramT, Funnel<? super T> paramFunnel, int paramInt, BloomFilterStrategies.BitArray paramBitArray)
  {
    long l1 = paramBitArray.bitSize();
    long l2 = Hashing.murmur3_128().hashObject(paramT, paramFunnel).asLong();
    int m = (int)l2;
    int n = (int)(l2 >>> 32);
    boolean bool = false;
    int i = 1;
    while (i <= paramInt)
    {
      int k = i * n + m;
      int j = k;
      if (k < 0) {
        j = k ^ 0xFFFFFFFF;
      }
      bool |= paramBitArray.set(j % l1);
      i += 1;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.BloomFilterStrategies.1
 * JD-Core Version:    0.7.0.1
 */