package com.tencent.msf.service.protocol.h;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a
  extends JceStruct
{
  static j g;
  static j h;
  public int a = 0;
  public j b = null;
  public j c = null;
  public byte d = 0;
  public int e = 0;
  public long f;
  
  public a() {}
  
  public a(int paramInt1, j paramj1, j paramj2, byte paramByte, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramj1;
    this.c = paramj2;
    this.d = paramByte;
    this.e = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    if (g == null) {
      g = new j();
    }
    this.b = ((j)paramJceInputStream.read(g, 2, false));
    if (h == null) {
      h = new j();
    }
    this.c = ((j)paramJceInputStream.read(h, 3, false));
    this.d = paramJceInputStream.read(this.d, 4, false);
    this.e = paramJceInputStream.read(this.e, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    if (this.b != null) {
      paramJceOutputStream.write(this.b, 2);
    }
    if (this.c != null) {
      paramJceOutputStream.write(this.c, 3);
    }
    paramJceOutputStream.write(this.d, 4);
    paramJceOutputStream.write(this.e, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.h.a
 * JD-Core Version:    0.7.0.1
 */