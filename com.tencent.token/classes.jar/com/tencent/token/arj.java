package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class arj
  extends JceStruct
{
  static byte[] o;
  static byte[] p;
  static byte[] q;
  static Map<String, String> r;
  public int a = 0;
  public byte[] b = null;
  public int c = 0;
  public String d = "";
  public boolean e = false;
  public byte[] f = null;
  public byte[] g = null;
  public int h = 0;
  public int i = 0;
  public long j = 0L;
  public int k = 0;
  public int l = 0;
  public String m = "";
  public Map<String, String> n = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    o = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    p = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    arrayOfByte = (byte[])new byte[1];
    q = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    r = new HashMap();
    r.put("", "");
  }
  
  public final JceStruct newInit()
  {
    return new arj();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = ((byte[])paramJceInputStream.read(o, 1, true));
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = ((byte[])paramJceInputStream.read(p, 5, false));
    this.g = ((byte[])paramJceInputStream.read(q, 6, false));
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.readString(12, false);
    this.n = ((Map)paramJceInputStream.read(r, 13, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    Object localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    boolean bool = this.e;
    if (bool) {
      paramJceOutputStream.write(bool, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 6);
    }
    int i1 = this.h;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 7);
    }
    i1 = this.i;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 8);
    }
    long l1 = this.j;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 9);
    }
    i1 = this.k;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 10);
    }
    i1 = this.l;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 11);
    }
    localObject = this.m;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.n;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.arj
 * JD-Core Version:    0.7.0.1
 */