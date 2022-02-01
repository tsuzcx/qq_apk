package com.google.common.hash;

import com.google.common.primitives.Longs;

 enum LittleEndianByteArray$JavaLittleEndianBytes$1
{
  LittleEndianByteArray$JavaLittleEndianBytes$1()
  {
    super(str, i, null);
  }
  
  public long getLongLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return Longs.fromBytes(paramArrayOfByte[(paramInt + 7)], paramArrayOfByte[(paramInt + 6)], paramArrayOfByte[(paramInt + 5)], paramArrayOfByte[(paramInt + 4)], paramArrayOfByte[(paramInt + 3)], paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 1)], paramArrayOfByte[paramInt]);
  }
  
  public void putLongLittleEndian(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    long l = 255L;
    int i = 0;
    while (i < 8)
    {
      paramArrayOfByte[(paramInt + i)] = ((byte)(int)((paramLong & l) >> i * 8));
      l <<= 8;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.1
 * JD-Core Version:    0.7.0.1
 */