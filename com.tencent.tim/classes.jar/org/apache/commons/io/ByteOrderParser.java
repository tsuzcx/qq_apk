package org.apache.commons.io;

import java.nio.ByteOrder;

public final class ByteOrderParser
{
  public static ByteOrder parseByteOrder(String paramString)
  {
    if (ByteOrder.BIG_ENDIAN.toString().equals(paramString)) {
      return ByteOrder.BIG_ENDIAN;
    }
    if (ByteOrder.LITTLE_ENDIAN.toString().equals(paramString)) {
      return ByteOrder.LITTLE_ENDIAN;
    }
    throw new IllegalArgumentException("Unsupported byte order setting: " + paramString + ", expeced one of " + ByteOrder.LITTLE_ENDIAN + ", " + ByteOrder.BIG_ENDIAN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.ByteOrderParser
 * JD-Core Version:    0.7.0.1
 */