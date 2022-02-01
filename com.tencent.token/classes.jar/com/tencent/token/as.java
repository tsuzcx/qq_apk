package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class as
  extends JceStruct
{
  static byte[] b;
  public byte[] a = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (b == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      b = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(b, 0, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    byte[] arrayOfByte = this.a;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.as
 * JD-Core Version:    0.7.0.1
 */