package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class y
  extends JceStruct
{
  static ArrayList f;
  static ArrayList g;
  static ArrayList h;
  public int a = 0;
  public int b = 0;
  public ArrayList c = null;
  public ArrayList d = null;
  public ArrayList e = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, true);
    if (f == null)
    {
      f = new ArrayList();
      f.add("");
    }
    this.c = ((ArrayList)paramJceInputStream.read(f, 2, true));
    if (g == null)
    {
      g = new ArrayList();
      g.add("");
    }
    this.d = ((ArrayList)paramJceInputStream.read(g, 3, true));
    if (h == null)
    {
      h = new ArrayList();
      h.add("");
    }
    this.e = ((ArrayList)paramJceInputStream.read(h, 4, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    paramJceOutputStream.write(this.b, 1);
    paramJceOutputStream.write(this.c, 2);
    paramJceOutputStream.write(this.d, 3);
    paramJceOutputStream.write(this.e, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.y
 * JD-Core Version:    0.7.0.1
 */