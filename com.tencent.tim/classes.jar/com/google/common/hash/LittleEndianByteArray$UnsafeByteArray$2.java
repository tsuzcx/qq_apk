package com.google.common.hash;

import sun.misc.Unsafe;

 enum LittleEndianByteArray$UnsafeByteArray$2
{
  LittleEndianByteArray$UnsafeByteArray$2()
  {
    super(str, i, null);
  }
  
  public long getLongLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return Long.reverseBytes(LittleEndianByteArray.UnsafeByteArray.access$200().getLong(paramArrayOfByte, paramInt + LittleEndianByteArray.UnsafeByteArray.access$100()));
  }
  
  public void putLongLittleEndian(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramLong = Long.reverseBytes(paramLong);
    LittleEndianByteArray.UnsafeByteArray.access$200().putLong(paramArrayOfByte, paramInt + LittleEndianByteArray.UnsafeByteArray.access$100(), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.2
 * JD-Core Version:    0.7.0.1
 */