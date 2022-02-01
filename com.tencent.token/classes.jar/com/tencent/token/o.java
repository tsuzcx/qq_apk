package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class o
  extends JceStruct
{
  static ArrayList<r> c = new ArrayList();
  public int a = 0;
  public ArrayList<r> b = null;
  
  static
  {
    r localr = new r();
    c.add(localr);
  }
  
  public final JceStruct newInit()
  {
    return new o();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = ((ArrayList)paramJceInputStream.read(c, 1, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.o
 * JD-Core Version:    0.7.0.1
 */