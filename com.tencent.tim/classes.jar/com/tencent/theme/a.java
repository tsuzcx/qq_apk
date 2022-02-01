package com.tencent.theme;

import java.io.IOException;
import java.nio.ByteBuffer;

class a
{
  static final void a(ByteBuffer paramByteBuffer, int paramInt)
    throws IOException
  {
    int i = paramByteBuffer.getInt();
    if (i != paramInt) {
      throw new IOException("Expected chunk of type 0x" + Integer.toHexString(paramInt) + ", read 0x" + Integer.toHexString(i) + ".");
    }
  }
  
  static final void b(ByteBuffer paramByteBuffer, int paramInt)
  {
    paramByteBuffer.position(paramByteBuffer.position() + paramInt);
  }
  
  static final int[] c(ByteBuffer paramByteBuffer, int paramInt)
    throws IOException
  {
    int[] arrayOfInt = new int[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfInt[i] = paramByteBuffer.getInt();
      i += 1;
    }
    return arrayOfInt;
  }
  
  static final byte[] d(ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.theme.a
 * JD-Core Version:    0.7.0.1
 */