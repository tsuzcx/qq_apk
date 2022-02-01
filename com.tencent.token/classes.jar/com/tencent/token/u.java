package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class u
  extends JceStruct
{
  public long a = 0L;
  public String b = "";
  
  public final JceStruct newInit()
  {
    return new u();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.readString(1, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    long l = this.a;
    if (l != 0L) {
      paramJceOutputStream.write(l, 0);
    }
    String str = this.b;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.u
 * JD-Core Version:    0.7.0.1
 */