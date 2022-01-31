package com.tencent.msf.service.protocol.push;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class c
  extends JceStruct
{
  static ArrayList d;
  public byte a = 0;
  public int b = 0;
  public ArrayList c = null;
  
  public c() {}
  
  public c(byte paramByte, int paramInt, ArrayList paramArrayList)
  {
    this.a = paramByte;
    this.b = paramInt;
    this.c = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    if (d == null)
    {
      d = new ArrayList();
      b localb = new b();
      d.add(localb);
    }
    this.c = ((ArrayList)paramJceInputStream.read(d, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.push.c
 * JD-Core Version:    0.7.0.1
 */