package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class o
  extends JceStruct
{
  static byte[] e;
  static byte[] f;
  public byte[] a = null;
  public String b = "";
  public String c = "";
  public byte[] d = null;
  
  public o() {}
  
  public o(byte[] paramArrayOfByte1, String paramString1, String paramString2, byte[] paramArrayOfByte2)
  {
    this.a = paramArrayOfByte1;
    this.b = paramString1;
    this.c = paramString2;
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
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.readString(2, true);
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
 * Qualified Name:     com.tencent.msf.service.protocol.security.o
 * JD-Core Version:    0.7.0.1
 */