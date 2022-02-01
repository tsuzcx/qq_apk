package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aom
  extends JceStruct
{
  static byte[] g;
  public int a = 0;
  public byte[] b = null;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    g = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public final JceStruct newInit()
  {
    return new aom();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = ((byte[])paramJceInputStream.read(g, 1, true));
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.read(this.d, 3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    int i = this.d;
    if (i != 0) {
      paramJceOutputStream.write(i, 3);
    }
    i = this.e;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
    i = this.f;
    if (i != 0) {
      paramJceOutputStream.write(i, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aom
 * JD-Core Version:    0.7.0.1
 */