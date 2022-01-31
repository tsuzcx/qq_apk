package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class h
  extends JceStruct
{
  static ArrayList i;
  static ArrayList j;
  static ArrayList k;
  static ArrayList l;
  public ArrayList a = null;
  public ArrayList b = null;
  public int c = 0;
  public byte d = 0;
  public byte e = 0;
  public int f = 1;
  public ArrayList g = null;
  public ArrayList h = null;
  
  public h() {}
  
  public h(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    this.a = paramArrayList1;
    this.b = paramArrayList2;
    this.c = paramInt1;
    this.d = paramByte1;
    this.e = paramByte2;
    this.f = paramInt2;
    this.g = paramArrayList3;
    this.h = paramArrayList4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    i locali;
    if (i == null)
    {
      i = new ArrayList();
      locali = new i();
      i.add(locali);
    }
    this.a = ((ArrayList)paramJceInputStream.read(i, 1, true));
    if (j == null)
    {
      j = new ArrayList();
      locali = new i();
      j.add(locali);
    }
    this.b = ((ArrayList)paramJceInputStream.read(j, 3, true));
    this.c = paramJceInputStream.read(this.c, 4, true);
    this.d = paramJceInputStream.read(this.d, 5, false);
    this.e = paramJceInputStream.read(this.e, 6, false);
    this.f = paramJceInputStream.read(this.f, 7, false);
    if (k == null)
    {
      k = new ArrayList();
      locali = new i();
      k.add(locali);
    }
    this.g = ((ArrayList)paramJceInputStream.read(k, 8, false));
    if (l == null)
    {
      l = new ArrayList();
      locali = new i();
      l.add(locali);
    }
    this.h = ((ArrayList)paramJceInputStream.read(l, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 3);
    paramJceOutputStream.write(this.c, 4);
    paramJceOutputStream.write(this.d, 5);
    paramJceOutputStream.write(this.e, 6);
    paramJceOutputStream.write(this.f, 7);
    if (this.g != null) {
      paramJceOutputStream.write(this.g, 8);
    }
    if (this.h != null) {
      paramJceOutputStream.write(this.h, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.h
 * JD-Core Version:    0.7.0.1
 */