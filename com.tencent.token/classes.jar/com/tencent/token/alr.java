package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class alr
  extends JceStruct
{
  static ArrayList<String> A;
  static ano B;
  static ArrayList<ano> C;
  static ArrayList<amz> x = new ArrayList();
  static ArrayList<String> y;
  static ArrayList<String> z;
  public int a = 0;
  public String b = "";
  public boolean c = false;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public ArrayList<amz> h = null;
  public int i = 0;
  public int j = 0;
  public ArrayList<String> k = null;
  public int l = 0;
  public String m = "";
  public String n = "";
  public int o = 0;
  public String p = "";
  public int q = 0;
  public ArrayList<String> r = null;
  public int s = 0;
  public ArrayList<String> t = null;
  public int u = 0;
  public ano v = null;
  public ArrayList<ano> w = null;
  
  static
  {
    Object localObject = new amz();
    x.add(localObject);
    y = new ArrayList();
    y.add("");
    z = new ArrayList();
    z.add("");
    A = new ArrayList();
    A.add("");
    B = new ano();
    C = new ArrayList();
    localObject = new ano();
    C.add(localObject);
  }
  
  public final JceStruct newInit()
  {
    return new alr();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = ((ArrayList)paramJceInputStream.read(x, 7, false));
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.read(this.j, 9, false);
    this.k = ((ArrayList)paramJceInputStream.read(y, 10, false));
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = paramJceInputStream.readString(12, false);
    this.n = paramJceInputStream.readString(13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    this.p = paramJceInputStream.readString(15, false);
    this.q = paramJceInputStream.read(this.q, 16, false);
    this.r = ((ArrayList)paramJceInputStream.read(z, 17, false));
    this.s = paramJceInputStream.read(this.s, 18, false);
    this.t = ((ArrayList)paramJceInputStream.read(A, 19, false));
    this.u = paramJceInputStream.read(this.u, 20, false);
    this.v = ((ano)paramJceInputStream.read(B, 21, false));
    this.w = ((ArrayList)paramJceInputStream.read(C, 22, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    Object localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.c, 2);
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    int i1 = this.i;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 8);
    }
    paramJceOutputStream.write(this.j, 9);
    localObject = this.k;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
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
      paramJceOutputStream.write((String)localObject, 13);
    }
    paramJceOutputStream.write(this.o, 14);
    localObject = this.p;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 15);
    }
    i1 = this.q;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 16);
    }
    localObject = this.r;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 17);
    }
    i1 = this.s;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 18);
    }
    localObject = this.t;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 19);
    }
    i1 = this.u;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 20);
    }
    localObject = this.v;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 21);
    }
    localObject = this.w;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 22);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alr
 * JD-Core Version:    0.7.0.1
 */