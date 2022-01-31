package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class d
  extends JceStruct
{
  static ArrayList n;
  static ArrayList o;
  static ArrayList p;
  static ArrayList q;
  public int a = 0;
  public ArrayList b = null;
  public ArrayList c = null;
  public int d = 0;
  public int e = 86400;
  public byte f = 0;
  public byte g = 0;
  public int h = 1;
  public int i = 5;
  public long j = 0L;
  public int k = 0;
  public ArrayList l = null;
  public ArrayList m = null;
  
  public d() {}
  
  public d(int paramInt1, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt2, int paramInt3, byte paramByte1, byte paramByte2, int paramInt4, int paramInt5, long paramLong, int paramInt6, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    this.a = paramInt1;
    this.b = paramArrayList1;
    this.c = paramArrayList2;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramByte1;
    this.g = paramByte2;
    this.h = paramInt4;
    this.i = paramInt5;
    this.j = paramLong;
    this.k = paramInt6;
    this.l = paramArrayList3;
    this.m = paramArrayList4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    i locali;
    if (n == null)
    {
      n = new ArrayList();
      locali = new i();
      n.add(locali);
    }
    this.b = ((ArrayList)paramJceInputStream.read(n, 2, true));
    if (o == null)
    {
      o = new ArrayList();
      locali = new i();
      o.add(locali);
    }
    this.c = ((ArrayList)paramJceInputStream.read(o, 3, true));
    this.d = paramJceInputStream.read(this.d, 4, true);
    this.e = paramJceInputStream.read(this.e, 5, true);
    this.f = paramJceInputStream.read(this.f, 6, false);
    this.g = paramJceInputStream.read(this.g, 7, false);
    this.h = paramJceInputStream.read(this.h, 8, false);
    this.i = paramJceInputStream.read(this.i, 9, false);
    this.j = paramJceInputStream.read(this.j, 10, false);
    this.k = paramJceInputStream.read(this.k, 11, false);
    if (p == null)
    {
      p = new ArrayList();
      locali = new i();
      p.add(locali);
    }
    this.l = ((ArrayList)paramJceInputStream.read(p, 12, false));
    if (q == null)
    {
      q = new ArrayList();
      locali = new i();
      q.add(locali);
    }
    this.m = ((ArrayList)paramJceInputStream.read(q, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
    paramJceOutputStream.write(this.f, 6);
    paramJceOutputStream.write(this.g, 7);
    paramJceOutputStream.write(this.h, 8);
    paramJceOutputStream.write(this.i, 9);
    paramJceOutputStream.write(this.j, 10);
    paramJceOutputStream.write(this.k, 11);
    if (this.l != null) {
      paramJceOutputStream.write(this.l, 12);
    }
    if (this.m != null) {
      paramJceOutputStream.write(this.m, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.d
 * JD-Core Version:    0.7.0.1
 */