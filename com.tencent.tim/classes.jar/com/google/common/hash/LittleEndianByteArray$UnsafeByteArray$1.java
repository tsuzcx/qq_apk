package com.google.common.hash;

import sun.misc.Unsafe;

 enum LittleEndianByteArray$UnsafeByteArray$1
{
  LittleEndianByteArray$UnsafeByteArray$1()
  {
    super(str, i, null);
  }
  
  public long getLongLittleEndian(byte[] paramArrayOfByte, int paramInt)
  {
    return LittleEndianByteArray.UnsafeByteArray.access$200().getLong(paramArrayOfByte, paramInt + LittleEndianByteArray.UnsafeByteArray.access$100());
  }
  
  public void putLongLittleEndian(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    LittleEndianByteArray.UnsafeByteArray.access$200().putLong(paramArrayOfByte, paramInt + LittleEndianByteArray.UnsafeByteArray.access$100(), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.1
 * JD-Core Version:    0.7.0.1
 */