package com.tencent.msf.service.protocol.push.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class d
  extends JceStruct
{
  static ArrayList A = new ArrayList();
  static byte[] B;
  static byte[] C;
  static byte[] D;
  static ArrayList E;
  static ArrayList F;
  public short a = 0;
  public ArrayList b = null;
  public long c = 0L;
  public long d = 0L;
  public byte[] e = null;
  public long f = 0L;
  public byte[] g = null;
  public long h = 0L;
  public long i = 0L;
  public long j = 0L;
  public long k = 0L;
  public long l = 0L;
  public long m = 0L;
  public long n = 0L;
  public short o = 0;
  public byte[] p = null;
  public String q = "";
  public short r = 0;
  public ArrayList s = null;
  public String t = "";
  public String u = "";
  public ArrayList v = null;
  public long w = 0L;
  public long x = 0L;
  public short y = 0;
  public short z = 0;
  
  static
  {
    Object localObject = new a();
    A.add(localObject);
    B = (byte[])new byte[1];
    ((byte[])B)[0] = 0;
    C = (byte[])new byte[1];
    ((byte[])C)[0] = 0;
    D = (byte[])new byte[1];
    ((byte[])D)[0] = 0;
    E = new ArrayList();
    localObject = new e();
    E.add(localObject);
    F = new ArrayList();
    localObject = new c();
    F.add(localObject);
  }
  
  public d() {}
  
  public d(short paramShort1, ArrayList paramArrayList1, long paramLong1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, byte[] paramArrayOfByte2, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, short paramShort2, byte[] paramArrayOfByte3, String paramString1, short paramShort3, ArrayList paramArrayList2, String paramString2, String paramString3, ArrayList paramArrayList3, long paramLong11, long paramLong12, short paramShort4, short paramShort5)
  {
    this.a = paramShort1;
    this.b = paramArrayList1;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramArrayOfByte1;
    this.f = paramLong3;
    this.g = paramArrayOfByte2;
    this.h = paramLong4;
    this.i = paramLong5;
    this.j = paramLong6;
    this.k = paramLong7;
    this.l = paramLong8;
    this.m = paramLong9;
    this.n = paramLong10;
    this.o = paramShort2;
    this.p = paramArrayOfByte3;
    this.q = paramString1;
    this.r = paramShort3;
    this.s = paramArrayList2;
    this.t = paramString2;
    this.u = paramString3;
    this.v = paramArrayList3;
    this.w = paramLong11;
    this.x = paramLong12;
    this.y = paramShort4;
    this.z = paramShort5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = ((ArrayList)paramJceInputStream.read(A, 1, false));
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = ((byte[])paramJceInputStream.read(B, 4, false));
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = ((byte[])paramJceInputStream.read(C, 6, false));
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.read(this.m, 12, false);
    this.n = paramJceInputStream.read(this.n, 13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    this.p = ((byte[])paramJceInputStream.read(D, 15, false));
    this.q = paramJceInputStream.readString(16, false);
    this.r = paramJceInputStream.read(this.r, 17, false);
    this.s = ((ArrayList)paramJceInputStream.read(E, 18, false));
    this.t = paramJceInputStream.readString(19, false);
    this.u = paramJceInputStream.readString(20, false);
    this.v = ((ArrayList)paramJceInputStream.read(F, 21, false));
    this.w = paramJceInputStream.read(this.w, 22, false);
    this.x = paramJceInputStream.read(this.x, 23, false);
    this.y = paramJceInputStream.read(this.y, 24, false);
    this.z = paramJceInputStream.read(this.z, 25, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    paramJceOutputStream.write(this.f, 5);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    paramJceOutputStream.write(this.h, 7);
    paramJceOutputStream.write(this.i, 8);
    paramJceOutputStream.write(this.j, 9);
    paramJceOutputStream.write(this.k, 10);
    paramJceOutputStream.write(this.l, 11);
    paramJceOutputStream.write(this.m, 12);
    paramJceOutputStream.write(this.n, 13);
    paramJceOutputStream.write(this.o, 14);
    if (this.p != null) {
      paramJceOutputStream.write(this.p, 15);
    }
    if (this.q != null) {
      paramJceOutputStream.write(this.q, 16);
    }
    paramJceOutputStream.write(this.r, 17);
    if (this.s != null) {
      paramJceOutputStream.write(this.s, 18);
    }
    if (this.t != null) {
      paramJceOutputStream.write(this.t, 19);
    }
    if (this.u != null) {
      paramJceOutputStream.write(this.u, 20);
    }
    if (this.v != null) {
      paramJceOutputStream.write(this.v, 21);
    }
    paramJceOutputStream.write(this.w, 22);
    paramJceOutputStream.write(this.x, 23);
    paramJceOutputStream.write(this.y, 24);
    paramJceOutputStream.write(this.z, 25);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.a.d
 * JD-Core Version:    0.7.0.1
 */