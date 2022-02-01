package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class aow
  extends JceStruct
{
  public String a = "";
  public int b = 0;
  public String c = "";
  
  public final JceStruct newInit()
  {
    return new aow();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.readString(2, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.a;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    int i = this.b;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    str = this.c;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aow
 * JD-Core Version:    0.7.0.1
 */