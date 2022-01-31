package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class p
  extends JceStruct
{
  static byte[] f;
  static byte[] g;
  static byte[] h;
  public byte[] a = null;
  public String b = "";
  public String c = "";
  public byte[] d = null;
  public byte[] e = null;
  
  public p() {}
  
  public p(byte[] paramArrayOfByte1, String paramString1, String paramString2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.a = paramArrayOfByte1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramArrayOfByte2;
    this.e = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (f == null)
    {
      f = (byte[])new byte[1];
      ((byte[])f)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(f, 0, true));
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.readString(2, true);
    if (g == null)
    {
      g = (byte[])new byte[1];
      ((byte[])g)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(g, 3, true));
    if (h == null)
    {
      h = (byte[])new byte[1];
      ((byte[])h)[0] = 0;
    }
    this.e = ((byte[])paramJceInputStream.read(h, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.p
 * JD-Core Version:    0.7.0.1
 */