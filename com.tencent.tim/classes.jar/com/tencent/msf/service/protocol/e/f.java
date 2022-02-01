package com.tencent.msf.service.protocol.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class f
  extends JceStruct
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public String d = "";
  public int e = 0;
  public String f = "";
  public int g = 0;
  
  public f() {}
  
  public f(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, String paramString2, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramString1;
    this.e = paramInt4;
    this.f = paramString2;
    this.g = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    this.b = paramJceInputStream.read(this.b, 2, false);
    this.c = paramJceInputStream.read(this.c, 3, false);
    this.d = paramJceInputStream.readString(4, false);
    this.e = paramJceInputStream.read(this.e, 5, false);
    this.f = paramJceInputStream.readString(6, false);
    this.g = paramJceInputStream.read(this.g, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 4);
    }
    paramJceOutputStream.write(this.e, 5);
    if (this.f != null) {
      paramJceOutputStream.write(this.f, 6);
    }
    paramJceOutputStream.write(this.g, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.e.f
 * JD-Core Version:    0.7.0.1
 */