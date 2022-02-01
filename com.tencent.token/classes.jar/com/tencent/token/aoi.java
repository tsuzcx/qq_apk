package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aoi
  extends JceStruct
{
  public int a = 2;
  public int b = 0;
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public int g = 0;
  public long h = 0L;
  public int i = 0;
  public String j = "";
  
  public final JceStruct newInit()
  {
    return new aoi();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = paramJceInputStream.read(this.g, 6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = paramJceInputStream.read(this.i, 8, false);
    this.j = paramJceInputStream.readString(9, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    String str = this.c;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.d;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.e;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    int k = this.f;
    if (k != 0) {
      paramJceOutputStream.write(k, 5);
    }
    k = this.g;
    if (k != 0) {
      paramJceOutputStream.write(k, 6);
    }
    long l = this.h;
    if (l != 0L) {
      paramJceOutputStream.write(l, 7);
    }
    k = this.i;
    if (k != 0) {
      paramJceOutputStream.write(k, 8);
    }
    str = this.j;
    if (str != null) {
      paramJceOutputStream.write(str, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoi
 * JD-Core Version:    0.7.0.1
 */