package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class r
  extends JceStruct
{
  static t t = new t();
  static q u = new q();
  static ArrayList<p> v = new ArrayList();
  static u w;
  static ArrayList<s> x;
  public t a = null;
  public q b = null;
  public String c = "";
  public ArrayList<p> d = null;
  public float e = 0.0F;
  public long f = 0L;
  public String g = "";
  public String h = "";
  public String i = "";
  public u j = null;
  public String k = "";
  public String l = "";
  public boolean m = false;
  public boolean n = false;
  public int o = 0;
  public int p = 0;
  public String q = "";
  public String r = "";
  public ArrayList<s> s = null;
  
  static
  {
    Object localObject = new p();
    v.add(localObject);
    w = new u();
    x = new ArrayList();
    localObject = new s();
    x.add(localObject);
  }
  
  public final JceStruct newInit()
  {
    return new r();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((t)paramJceInputStream.read(t, 0, true));
    this.b = ((q)paramJceInputStream.read(u, 1, false));
    this.c = paramJceInputStream.readString(2, false);
    this.d = ((ArrayList)paramJceInputStream.read(v, 3, false));
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.readString(7, false);
    this.i = paramJceInputStream.readString(8, false);
    this.j = ((u)paramJceInputStream.read(w, 9, false));
    this.k = paramJceInputStream.readString(10, false);
    this.l = paramJceInputStream.readString(11, false);
    this.m = paramJceInputStream.read(this.m, 12, false);
    this.n = paramJceInputStream.read(this.n, 13, false);
    this.o = paramJceInputStream.read(this.o, 14, false);
    this.p = paramJceInputStream.read(this.p, 15, false);
    this.q = paramJceInputStream.readString(16, false);
    this.r = paramJceInputStream.readString(22, false);
    this.s = ((ArrayList)paramJceInputStream.read(x, 23, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    Object localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    float f1 = this.e;
    if (f1 != 0.0F) {
      paramJceOutputStream.write(f1, 4);
    }
    long l1 = this.f;
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
    localObject = this.i;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.k;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    localObject = this.l;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 11);
    }
    paramJceOutputStream.write(this.m, 12);
    paramJceOutputStream.write(this.n, 13);
    int i1 = this.o;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 14);
    }
    i1 = this.p;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 15);
    }
    localObject = this.q;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 16);
    }
    localObject = this.r;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 22);
    }
    localObject = this.s;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 23);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.r
 * JD-Core Version:    0.7.0.1
 */