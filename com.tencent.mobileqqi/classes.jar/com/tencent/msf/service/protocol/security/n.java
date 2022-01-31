package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class n
  extends JceStruct
{
  static byte[] h;
  static byte[] i;
  static byte[] j;
  public byte[] a = null;
  public String b = "";
  public String c = "";
  public byte d = 0;
  public byte e = 0;
  public byte[] f = null;
  public byte[] g = null;
  
  public n() {}
  
  public n(byte[] paramArrayOfByte1, String paramString1, String paramString2, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.a = paramArrayOfByte1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramByte1;
    this.e = paramByte2;
    this.f = paramArrayOfByte2;
    this.g = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (h == null)
    {
      h = (byte[])new byte[1];
      ((byte[])h)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(h, 0, true));
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
    if (i == null)
    {
      i = (byte[])new byte[1];
      ((byte[])i)[0] = 0;
    }
    this.f = ((byte[])paramJceInputStream.read(i, 5, false));
    if (j == null)
    {
      j = (byte[])new byte[1];
      ((byte[])j)[0] = 0;
    }
    this.g = ((byte[])paramJceInputStream.read(j, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.n
 * JD-Core Version:    0.7.0.1
 */