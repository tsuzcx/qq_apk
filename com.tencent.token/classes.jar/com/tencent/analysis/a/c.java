package com.tencent.analysis.a;

import java.nio.ByteBuffer;

 enum c
{
  c(int paramInt, f paramf)
  {
    super(???, 44, 400, paramf, (byte)0);
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
      int i = Byte.valueOf(paramString).byteValue();
      paramString = new byte[6];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramString);
      localByteBuffer.putShort(a());
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)i);
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.a.c
 * JD-Core Version:    0.7.0.1
 */