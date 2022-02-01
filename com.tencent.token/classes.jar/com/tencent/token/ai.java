package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ai
  extends JceStruct
{
  static byte[] f;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public byte[] d = null;
  public long e = 0L;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    if (f == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      f = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.d = ((byte[])paramJceInputStream.read(f, 3, false));
    this.e = paramJceInputStream.read(this.e, 4, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    int i = this.b;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.c;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    byte[] arrayOfByte = this.d;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 3);
    }
    long l = this.e;
    if (l != 0L) {
      paramJceOutputStream.write(l, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ai
 * JD-Core Version:    0.7.0.1
 */