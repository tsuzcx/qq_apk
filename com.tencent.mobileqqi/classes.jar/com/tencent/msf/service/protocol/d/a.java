package com.tencent.msf.service.protocol.d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  static byte[] e;
  static byte[] f;
  public byte[] a = null;
  public int b = 0;
  public int c = 0;
  public byte[] d = null;
  
  public a() {}
  
  public a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    this.a = paramArrayOfByte1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (e == null)
    {
      e = (byte[])new byte[1];
      ((byte[])e)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(e, 0, true));
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    if (f == null)
    {
      f = (byte[])new byte[1];
      ((byte[])f)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(f, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.d.a
 * JD-Core Version:    0.7.0.1
 */