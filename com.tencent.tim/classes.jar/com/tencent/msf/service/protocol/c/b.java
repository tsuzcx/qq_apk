package com.tencent.msf.service.protocol.c;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static ArrayList d;
  public long a = 0L;
  public ArrayList b = null;
  public int c = 0;
  
  public b() {}
  
  public b(long paramLong, ArrayList paramArrayList, int paramInt)
  {
    this.a = paramLong;
    this.b = paramArrayList;
    this.c = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    if (d == null)
    {
      d = new ArrayList();
      a locala = new a();
      d.add(locala);
    }
    this.b = ((ArrayList)paramJceInputStream.read(d, 1, true));
    this.c = paramJceInputStream.read(this.c, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.c.b
 * JD-Core Version:    0.7.0.1
 */