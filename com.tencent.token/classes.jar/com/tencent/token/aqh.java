package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aqh
  extends JceStruct
{
  public String a = "";
  public String b = "";
  public int c = 0;
  public int d = 0;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.readString(1, true);
    this.c = paramJceInputStream.read(this.c, 2, true);
    this.d = paramJceInputStream.read(this.d, 3, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqh
 * JD-Core Version:    0.7.0.1
 */