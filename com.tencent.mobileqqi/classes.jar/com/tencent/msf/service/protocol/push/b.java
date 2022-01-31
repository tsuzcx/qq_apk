package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  public long a = 0L;
  public int b = 0;
  public int c = 0;
  public String d = "";
  
  public b() {}
  
  public b(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.b
 * JD-Core Version:    0.7.0.1
 */