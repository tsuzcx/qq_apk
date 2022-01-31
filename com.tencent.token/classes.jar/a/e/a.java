package a.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
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
  
  public void readFrom(JceInputStream paramJceInputStream)
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
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 1);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 2);
    }
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 3);
    }
    if (this.e != null) {
      paramJceOutputStream.write(this.e, 4);
    }
    if (1 != this.f) {
      paramJceOutputStream.write(this.f, 5);
    }
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 6);
    }
    if (this.h != 0) {
      paramJceOutputStream.write(this.h, 7);
    }
    if (this.i != null) {
      paramJceOutputStream.write(this.i, 8);
    }
    if (this.j != 0) {
      paramJceOutputStream.write(this.j, 9);
    }
    if (this.k != 0) {
      paramJceOutputStream.write(this.k, 10);
    }
    if (this.l) {
      paramJceOutputStream.write(this.l, 11);
    }
    if (this.m != null) {
      paramJceOutputStream.write(this.m, 12);
    }
    if (this.n != null) {
      paramJceOutputStream.write(this.n, 13);
    }
    if (this.o != 0) {
      paramJceOutputStream.write(this.o, 14);
    }
    if (this.p != null) {
      paramJceOutputStream.write(this.p, 15);
    }
    if (this.q != 0) {
      paramJceOutputStream.write(this.q, 16);
    }
    if (this.r != 0) {
      paramJceOutputStream.write(this.r, 17);
    }
    if (this.s != null) {
      paramJceOutputStream.write(this.s, 18);
    }
    if (this.t != null) {
      paramJceOutputStream.write(this.t, 19);
    }
    if (this.u != 0) {
      paramJceOutputStream.write(this.u, 20);
    }
    if (this.v != null) {
      paramJceOutputStream.write(this.v, 21);
    }
    if (this.w != 0L) {
      paramJceOutputStream.write(this.w, 22);
    }
    if (this.x != 0L) {
      paramJceOutputStream.write(this.x, 23);
    }
    if (this.y != 0L) {
      paramJceOutputStream.write(this.y, 24);
    }
    if (this.z != null) {
      paramJceOutputStream.write(this.z, 25);
    }
    if (this.A != null) {
      paramJceOutputStream.write(this.A, 26);
    }
    if (this.B != null) {
      paramJceOutputStream.write(this.B, 27);
    }
    if (this.C != null) {
      paramJceOutputStream.write(this.C, 28);
    }
    if (this.D != null) {
      paramJceOutputStream.write(this.D, 29);
    }
    if (this.E != null) {
      paramJceOutputStream.write(this.E, 30);
    }
    if (this.F != null) {
      paramJceOutputStream.write(this.F, 31);
    }
    if (this.G != null) {
      paramJceOutputStream.write(this.G, 32);
    }
    if (this.H != 0) {
      paramJceOutputStream.write(this.H, 33);
    }
    if (this.I != 0) {
      paramJceOutputStream.write(this.I, 34);
    }
    if (this.J) {
      paramJceOutputStream.write(this.J, 35);
    }
    if (this.K != null) {
      paramJceOutputStream.write(this.K, 36);
    }
    if (this.L != null) {
      paramJceOutputStream.write(this.L, 37);
    }
    if (this.M != null) {
      paramJceOutputStream.write(this.M, 38);
    }
    if (this.N) {
      paramJceOutputStream.write(this.N, 39);
    }
    if (this.O) {
      paramJceOutputStream.write(this.O, 40);
    }
    if (this.P != null) {
      paramJceOutputStream.write(this.P, 41);
    }
    if (this.Q != 1) {
      paramJceOutputStream.write(this.Q, 42);
    }
    if (this.R != null) {
      paramJceOutputStream.write(this.R, 43);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     a.e.a
 * JD-Core Version:    0.7.0.1
 */