package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class h
  extends JceStruct
{
  static ArrayList<Integer> c = new ArrayList();
  public int a = 0;
  public ArrayList<Integer> b = null;
  
  static
  {
    c.add(Integer.valueOf(0));
  }
  
  public final JceStruct newInit()
  {
    return new h();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = ((ArrayList)paramJceInputStream.read(c, 1, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.a;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.h
 * JD-Core Version:    0.7.0.1
 */