package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class q
  extends JceStruct
{
  static ArrayList<n> A;
  static byte[] w;
  static byte[] x;
  static m y;
  static ArrayList<v> z;
  public String a = "";
  public long b = 0L;
  public String c = "";
  public long d = 0L;
  public String e = "";
  public long f = 0L;
  public String g = "";
  public String h = "";
  public int i = 0;
  public String j = "";
  public int k = 0;
  public int l = 0;
  public byte[] m = null;
  public byte[] n = null;
  public m o = null;
  public boolean p = false;
  public ArrayList<v> q = null;
  public String r = "";
  public ArrayList<n> s = null;
  public int t = 0;
  public int u = 0;
  public String v = "";
  
  static
  {
    Object localObject = (byte[])new byte[1];
    w = (byte[])localObject;
    ((byte[])localObject)[0] = 0;
    localObject = (byte[])new byte[1];
    x = (byte[])localObject;
    ((byte[])localObject)[0] = 0;
    y = new m();
    z = new ArrayList();
    localObject = new v();
    z.add(localObject);
    A = new ArrayList();
    localObject = new n();
    A.add(localObject);
  }
  
  public final JceStruct newInit()
  {
    return new q();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.readString(7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.readString(9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = ((byte[])paramJceInputStream.read(w, 12, false));
    this.n = ((byte[])paramJceInputStream.read(x, 13, false));
    this.o = ((m)paramJceInputStream.read(y, 14, false));
    this.p = paramJceInputStream.read(this.p, 15, false);
    this.q = ((ArrayList)paramJceInputStream.read(z, 16, false));
    this.r = paramJceInputStream.readString(17, false);
    this.s = ((ArrayList)paramJceInputStream.read(A, 18, false));
    this.t = paramJceInputStream.read(this.t, 19, false);
    this.u = paramJceInputStream.read(this.u, 20, false);
    this.v = paramJceInputStream.readString(21, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    long l1 = this.b;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    l1 = this.d;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    l1 = this.f;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    int i1 = this.i;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
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
      paramJceOutputStream.write((byte[])localObject, 12);
    }
    localObject = this.n;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 13);
    }
    localObject = this.o;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 14);
    }
    paramJceOutputStream.write(this.p, 15);
    localObject = this.q;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 16);
    }
    localObject = this.r;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 17);
    }
    localObject = this.s;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 18);
    }
    i1 = this.t;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 19);
    }
    i1 = this.u;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 20);
    }
    localObject = this.v;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.q
 * JD-Core Version:    0.7.0.1
 */