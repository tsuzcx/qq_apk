package com.tencent.analysis.a;

import java.nio.ByteBuffer;

 enum d
{
  d(int paramInt, f paramf)
  {
    super(???, 46, 402, paramf, (byte)0);
  }
  
  protected final String a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.getShort();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramByteBuffer.getShort());
    return localStringBuilder.toString();
  }
  
  public final byte[] a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      short s = Short.valueOf(paramString).shortValue();
      paramString = new byte[6];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramString);
      localByteBuffer.putShort(a());
      localByteBuffer.putShort((short)2);
      localByteBuffer.putShort(s);
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a.d
 * JD-Core Version:    0.7.0.1
 */