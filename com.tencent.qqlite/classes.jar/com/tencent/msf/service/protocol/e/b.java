package com.tencent.msf.service.protocol.e;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b
  extends JceStruct
{
  static ArrayList f;
  public ArrayList a = null;
  public int b = 0;
  public byte c = 1;
  public String d = "46000";
  public int e = 0;
  
  public b() {}
  
  public b(ArrayList paramArrayList, int paramInt1, byte paramByte, String paramString, int paramInt2)
  {
    this.a = paramArrayList;
    this.b = paramInt1;
    this.c = paramByte;
    this.d = paramString;
    this.e = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (f == null)
    {
      f = new ArrayList();
      f.add("");
    }
    this.a = ((ArrayList)paramJceInputStream.read(f, 1, true));
    this.b = paramJceInputStream.read(this.b, 2, true);
    this.c = paramJceInputStream.read(this.c, 3, false);
    this.d = paramJceInputStream.readString(4, false);
    this.e = paramJceInputStream.read(this.e, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 1);
    paramJceOutputStream.write(this.b, 2);
    paramJceOutputStream.write(this.c, 3);
    if (this.d != null) {
      paramJceOutputStream.write(this.d, 4);
    }
    paramJceOutputStream.write(this.e, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.e.b
 * JD-Core Version:    0.7.0.1
 */