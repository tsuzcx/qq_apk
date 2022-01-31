package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class f
  extends JceStruct
{
  static byte[] w;
  static byte[] x;
  public long a = 0L;
  public long b = 0L;
  public byte c = 0;
  public String d = "";
  public int e = 11;
  public byte f = 0;
  public byte g = 0;
  public byte h = 0;
  public byte i = 0;
  public byte j = 0;
  public long k = 0L;
  public long l = 0L;
  public byte m = 0;
  public String n = "";
  public byte o = 0;
  public byte[] p = null;
  public byte[] q = null;
  public int r = 2052;
  public byte s = 0;
  public String t = "";
  public String u = "";
  public String v = "";
  
  public f() {}
  
  public f(long paramLong1, long paramLong2, byte paramByte1, String paramString1, int paramInt1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, long paramLong3, long paramLong4, byte paramByte7, String paramString2, byte paramByte8, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, byte paramByte9, String paramString3, String paramString4, String paramString5)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramByte1;
    this.d = paramString1;
    this.e = paramInt1;
    this.f = paramByte2;
    this.g = paramByte3;
    this.h = paramByte4;
    this.i = paramByte5;
    this.j = paramByte6;
    this.k = paramLong3;
    this.l = paramLong4;
    this.m = paramByte7;
    this.n = paramString2;
    this.o = paramByte8;
    this.p = paramArrayOfByte1;
    this.q = paramArrayOfByte2;
    this.r = paramInt2;
    this.s = paramByte9;
    this.t = paramString3;
    this.u = paramString4;
    this.v = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.readString(3, true);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.read(this.m, 12, false);
    this.n = paramJceInputStream.readString(13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    if (w == null)
    {
      w = (byte[])new byte[1];
      ((byte[])w)[0] = 0;
    }
    this.p = ((byte[])paramJceInputStream.read(w, 15, false));
    if (x == null)
    {
      x = (byte[])new byte[1];
      ((byte[])x)[0] = 0;
    }
    this.q = ((byte[])paramJceInputStream.read(x, 16, false));
    this.r = paramJceInputStream.read(this.r, 17, false);
    this.s = paramJceInputStream.read(this.s, 18, false);
    this.t = paramJceInputStream.readString(19, false);
    this.u = paramJceInputStream.readString(20, false);
    this.v = paramJceInputStream.readString(21, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
    paramJceOutputStream.write(this.f, 5);
    paramJceOutputStream.write(this.g, 6);
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    paramJceOutputStream.write(this.j, 9);
    paramJceOutputStream.write(this.k, 10);
    paramJceOutputStream.write(this.l, 11);
    paramJceOutputStream.write(this.m, 12);
    if (this.n != null) {
      paramJceOutputStream.write(this.n, 13);
    }
    paramJceOutputStream.write(this.o, 14);
    if (this.p != null) {
      paramJceOutputStream.write(this.p, 15);
    }
    if (this.q != null) {
      paramJceOutputStream.write(this.q, 16);
    }
    paramJceOutputStream.write(this.r, 17);
    paramJceOutputStream.write(this.s, 18);
    if (this.t != null) {
      paramJceOutputStream.write(this.t, 19);
    }
    if (this.u != null) {
      paramJceOutputStream.write(this.u, 20);
    }
    if (this.v != null) {
      paramJceOutputStream.write(this.v, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.f
 * JD-Core Version:    0.7.0.1
 */