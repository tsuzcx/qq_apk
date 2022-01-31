package com.tencent.analysis.a;

import java.nio.ByteBuffer;

 enum e
{
  e(int paramInt, f paramf)
  {
    super(???, 47, 403, paramf, (byte)0);
  }
  
  protected final String a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.getShort();
    return paramByteBuffer.getShort();
  }
  
  public final byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    short s = Short.valueOf(paramString).shortValue();
    paramString = new byte[6];
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramString);
    localByteBuffer.putShort(a());
    localByteBuffer.putShort((short)2);
    localByteBuffer.putShort(s);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a.e
 * JD-Core Version:    0.7.0.1
 */