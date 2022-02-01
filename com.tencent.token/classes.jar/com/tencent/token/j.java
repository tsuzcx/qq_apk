package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class j
  extends JceStruct
{
  static ArrayList<k> d = new ArrayList();
  static ArrayList<k> e;
  public int a = 0;
  public ArrayList<k> b = null;
  public ArrayList<k> c = null;
  
  static
  {
    k localk = new k();
    d.add(localk);
    e = new ArrayList();
    localk = new k();
    e.add(localk);
  }
  
  public final JceStruct newInit()
  {
    return new j();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = ((ArrayList)paramJceInputStream.read(d, 1, false));
    this.c = ((ArrayList)paramJceInputStream.read(e, 2, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    localArrayList = this.c;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.j
 * JD-Core Version:    0.7.0.1
 */