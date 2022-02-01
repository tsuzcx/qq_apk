package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class m
  extends JceStruct
{
  public String a = "";
  public String b = "";
  public String c = "";
  
  public final JceStruct newInit()
  {
    return new m();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.readString(2, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.a;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.b;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.c;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.m
 * JD-Core Version:    0.7.0.1
 */