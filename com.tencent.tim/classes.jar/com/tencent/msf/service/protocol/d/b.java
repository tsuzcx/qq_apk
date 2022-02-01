package com.tencent.msf.service.protocol.d;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static ArrayList b;
  public ArrayList a = null;
  
  public b() {}
  
  public b(ArrayList paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (b == null)
    {
      b = new ArrayList();
      a locala = new a();
      b.add(locala);
    }
    this.a = ((ArrayList)paramJceInputStream.read(b, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.d.b
 * JD-Core Version:    0.7.0.1
 */