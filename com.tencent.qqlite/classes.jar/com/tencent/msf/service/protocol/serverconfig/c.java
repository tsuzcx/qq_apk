package com.tencent.msf.service.protocol.serverconfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  public long a = 0L;
  public long b = 0L;
  public byte c = 1;
  public String d = "46000";
  public int e = 0;
  public long f = 0L;
  public String g = "";
  public long h = 0L;
  
  public c() {}
  
  public c(long paramLong1, long paramLong2, byte paramByte, String paramString1, int paramInt, long paramLong3, String paramString2, long paramLong4)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramByte;
    this.d = paramString1;
    this.e = paramInt;
    this.f = paramLong3;
    this.g = paramString2;
    this.h = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 1, true);
    this.b = paramJceInputStream.read(this.b, 2, true);
    this.c = paramJceInputStream.read(this.c, 3, true);
    this.d = paramJceInputStream.readString(4, true);
    this.e = paramJceInputStream.read(this.e, 5, true);
    this.f = paramJceInputStream.read(this.f, 6, true);
    this.g = paramJceInputStream.readString(7, true);
    this.h = paramJceInputStream.read(this.h, 8, false);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.serverconfig.c
 * JD-Core Version:    0.7.0.1
 */