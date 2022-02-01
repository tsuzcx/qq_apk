package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ah
  extends JceStruct
{
  static ag c;
  public ag a = null;
  public String b = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (c == null) {
      c = new ag();
    }
    this.a = ((ag)paramJceInputStream.read(c, 0, true));
    this.b = paramJceInputStream.readString(1, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ah
 * JD-Core Version:    0.7.0.1
 */