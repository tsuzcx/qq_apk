package com.tencent.msf.service.protocol.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static ArrayList f;
  static byte[] g;
  public short a = 0;
  public ArrayList b = null;
  public byte[] c = null;
  public long d = 0L;
  public long e = 0L;
  
  public b() {}
  
  public b(short paramShort, ArrayList paramArrayList, byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    this.a = paramShort;
    this.b = paramArrayList;
    this.c = paramArrayOfByte;
    this.d = paramLong1;
    this.e = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    if (f == null)
    {
      f = new ArrayList();
      a locala = new a();
      f.add(locala);
    }
    this.b = ((ArrayList)paramJceInputStream.read(f, 1, false));
    if (g == null)
    {
      g = (byte[])new byte[1];
      ((byte[])g)[0] = 0;
    }
    this.c = ((byte[])paramJceInputStream.read(g, 2, false));
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
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
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.b.b
 * JD-Core Version:    0.7.0.1
 */