package com.tencent.commonsdk.pool;

import java.util.Comparator;

final class ByteArrayPool$1
  implements Comparator<byte[]>
{
  public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return paramArrayOfByte1.length - paramArrayOfByte2.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.commonsdk.pool.ByteArrayPool.1
 * JD-Core Version:    0.7.0.1
 */