package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class au
  extends JceStruct
{
  public String A = "";
  public String B = "";
  public String C = "";
  public String D = "";
  public String E = "";
  public String F = "";
  public String G = "";
  public int H = 0;
  public int I = 0;
  public boolean J = false;
  public String K = "";
  public String L = "";
  public String M = "";
  public boolean N = false;
  public boolean O = false;
  public String P = "";
  public int Q = 1;
  public String R = "";
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 1;
  public String g = "";
  public int h = 0;
  public String i = "";
  public int j = 0;
  public int k = 0;
  public boolean l = false;
  public String m = "";
  public String n = "";
  public int o = 0;
  public String p = "";
  public short q = 0;
  public int r = 0;
  public String s = "";
  public String t = "";
  public int u = 0;
  public String v = "";
  public long w = 0L;
  public long x = 0L;
  public long y = 0L;
  public String z = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.readString(8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.readString(12, false);
    this.n = paramJceInputStream.readString(13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    this.p = paramJceInputStream.readString(15, false);
    this.q = paramJceInputStream.read(this.q, 16, false);
    this.r = paramJceInputStream.read(this.r, 17, false);
    this.s = paramJceInputStream.readString(18, false);
    this.t = paramJceInputStream.readString(19, false);
    this.u = paramJceInputStream.read(this.u, 20, false);
    this.v = paramJceInputStream.readString(21, false);
    this.w = paramJceInputStream.read(this.w, 22, false);
    this.x = paramJceInputStream.read(this.x, 23, false);
    this.y = paramJceInputStream.read(this.y, 24, false);
    this.z = paramJceInputStream.readString(25, false);
    this.A = paramJceInputStream.readString(26, false);
    this.B = paramJceInputStream.readString(27, false);
    this.C = paramJceInputStream.readString(28, false);
    this.D = paramJceInputStream.readString(29, false);
    this.E = paramJceInputStream.readString(30, false);
    this.F = paramJceInputStream.readString(31, false);
    this.G = paramJceInputStream.readString(32, false);
    this.H = paramJceInputStream.read(this.H, 33, false);
    this.I = paramJceInputStream.read(this.I, 34, false);
    this.J = paramJceInputStream.read(this.J, 35, false);
    this.K = paramJceInputStream.readString(36, false);
    this.L = paramJceInputStream.readString(37, false);
    this.M = paramJceInputStream.readString(38, false);
    this.N = paramJceInputStream.read(this.N, 39, false);
    this.O = paramJceInputStream.read(this.O, 40, false);
    this.P = paramJceInputStream.readString(41, false);
    this.Q = paramJceInputStream.read(this.Q, 42, false);
    this.R = paramJceInputStream.readString(43, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    String str = this.b;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.c;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.d;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.e;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    int i1 = this.f;
    if (1 != i1) {
      paramJceOutputStream.write(i1, 5);
    }
    str = this.g;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    i1 = this.h;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 7);
    }
    str = this.i;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
    i1 = this.j;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 9);
    }
    i1 = this.k;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 10);
    }
    boolean bool = this.l;
    if (bool) {
      paramJceOutputStream.write(bool, 11);
    }
    str = this.m;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    str = this.n;
    if (str != null) {
      paramJceOutputStream.write(str, 13);
    }
    i1 = this.o;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 14);
    }
    str = this.p;
    if (str != null) {
      paramJceOutputStream.write(str, 15);
    }
    short s1 = this.q;
    if (s1 != 0) {
      paramJceOutputStream.write(s1, 16);
    }
    i1 = this.r;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 17);
    }
    str = this.s;
    if (str != null) {
      paramJceOutputStream.write(str, 18);
    }
    str = this.t;
    if (str != null) {
      paramJceOutputStream.write(str, 19);
    }
    i1 = this.u;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 20);
    }
    str = this.v;
    if (str != null) {
      paramJceOutputStream.write(str, 21);
    }
    long l1 = this.w;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 22);
    }
    l1 = this.x;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 23);
    }
    l1 = this.y;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 24);
    }
    str = this.z;
    if (str != null) {
      paramJceOutputStream.write(str, 25);
    }
    str = this.A;
    if (str != null) {
      paramJceOutputStream.write(str, 26);
    }
    str = this.B;
    if (str != null) {
      paramJceOutputStream.write(str, 27);
    }
    str = this.C;
    if (str != null) {
      paramJceOutputStream.write(str, 28);
    }
    str = this.D;
    if (str != null) {
      paramJceOutputStream.write(str, 29);
    }
    str = this.E;
    if (str != null) {
      paramJceOutputStream.write(str, 30);
    }
    str = this.F;
    if (str != null) {
      paramJceOutputStream.write(str, 31);
    }
    str = this.G;
    if (str != null) {
      paramJceOutputStream.write(str, 32);
    }
    i1 = this.H;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 33);
    }
    i1 = this.I;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 34);
    }
    bool = this.J;
    if (bool) {
      paramJceOutputStream.write(bool, 35);
    }
    str = this.K;
    if (str != null) {
      paramJceOutputStream.write(str, 36);
    }
    str = this.L;
    if (str != null) {
      paramJceOutputStream.write(str, 37);
    }
    str = this.M;
    if (str != null) {
      paramJceOutputStream.write(str, 38);
    }
    bool = this.N;
    if (bool) {
      paramJceOutputStream.write(bool, 39);
    }
    bool = this.O;
    if (bool) {
      paramJceOutputStream.write(bool, 40);
    }
    str = this.P;
    if (str != null) {
      paramJceOutputStream.write(str, 41);
    }
    i1 = this.Q;
    if (i1 != 1) {
      paramJceOutputStream.write(i1, 42);
    }
    str = this.R;
    if (str != null) {
      paramJceOutputStream.write(str, 43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.au
 * JD-Core Version:    0.7.0.1
 */