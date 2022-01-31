package com.tencent.mm.sdk.platformtools;

import java.nio.ByteBuffer;

class MBuf
{
  private ByteBuffer al = null;
  
  public ByteBuffer getBuffer()
  {
    return this.al;
  }
  
  public int getLen()
  {
    return this.al.capacity();
  }
  
  public int getOffset()
  {
    return this.al.position();
  }
  
  public void setBuffer(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    this.al = ByteBuffer.allocateDirect(i);
    this.al.position(0);
    this.al.put(paramArrayOfByte, 0, i);
    this.al.position(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MBuf
 * JD-Core Version:    0.7.0.1
 */