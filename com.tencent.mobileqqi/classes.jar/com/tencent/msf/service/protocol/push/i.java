package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class i
  extends JceStruct
{
  public long a = 0L;
  public byte b = 0;
  public String c = "";
  
  public i() {}
  
  public i(long paramLong, byte paramByte, String paramString)
  {
    this.a = paramLong;
    this.b = paramByte;
    this.c = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    this.c = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.i
 * JD-Core Version:    0.7.0.1
 */