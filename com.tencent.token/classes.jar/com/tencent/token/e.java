package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends JceStruct
{
  static d q = new d();
  static Map<Integer, String> r = new HashMap();
  static ArrayList<String> s;
  static ArrayList<e> t;
  static ArrayList<String> u;
  static ArrayList<b> v;
  static c w = new c();
  public d a = null;
  public String b = "";
  public long c = 0L;
  public Map<Integer, String> d = null;
  public int e = 0;
  public ArrayList<String> f = null;
  public boolean g = true;
  public int h = 0;
  public int i = 0;
  public ArrayList<e> j = null;
  public int k = 0;
  public int l = 0;
  public ArrayList<String> m = null;
  public boolean n = true;
  public ArrayList<b> o = null;
  public c p = null;
  
  static
  {
    r.put(Integer.valueOf(0), "");
    s = new ArrayList();
    s.add("");
    t = new ArrayList();
    Object localObject = new e();
    t.add(localObject);
    u = new ArrayList();
    u.add("");
    v = new ArrayList();
    localObject = new b();
    v.add(localObject);
  }
  
  public final JceStruct newInit()
  {
    return new e();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((d)paramJceInputStream.read(q, 0, false));
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = ((Map)paramJceInputStream.read(r, 3, false));
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = ((ArrayList)paramJceInputStream.read(s, 5, false));
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = ((ArrayList)paramJceInputStream.read(t, 9, false));
    this.k = paramJceInputStream.read(this.k, 10, false);
    this.l = paramJceInputStream.read(this.l, 11, false);
    this.m = ((ArrayList)paramJceInputStream.read(u, 12, false));
    this.n = paramJceInputStream.read(this.n, 13, false);
    this.o = ((ArrayList)paramJceInputStream.read(v, 14, false));
    this.p = ((c)paramJceInputStream.read(w, 15, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    long l1 = this.c;
    if (l1 != 0L) {
      paramJceOutputStream.write(l1, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    int i1 = this.e;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 5);
    }
    paramJceOutputStream.write(this.g, 6);
    i1 = this.h;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 7);
    }
    i1 = this.i;
    if (i1 != 0) {
      paramJceOutputStream.write(i1, 8);
    }
    localObject = this.j;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
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
      paramJceOutputStream.write((Collection)localObject, 12);
    }
    paramJceOutputStream.write(this.n, 13);
    localObject = this.o;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 14);
    }
    localObject = this.p;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.e
 * JD-Core Version:    0.7.0.1
 */