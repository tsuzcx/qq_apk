package com.tencent.msf.service.protocol.security;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class i
  extends JceStruct
{
  static byte[] d;
  public byte[] a = null;
  public String b = "";
  public String c = "";
  
  public i() {}
  
  public i(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this.a = paramArrayOfByte;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (d == null)
    {
      d = (byte[])new byte[1];
      ((byte[])d)[0] = 0;
    }
    this.a = ((byte[])paramJceInputStream.read(d, 1, true));
    this.b = paramJceInputStream.readString(2, true);
    this.c = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.security.i
 * JD-Core Version:    0.7.0.1
 */