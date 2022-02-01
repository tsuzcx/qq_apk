package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class aa
  extends JceStruct
{
  static ArrayList d;
  public int a = 0;
  public int b = 0;
  public ArrayList c = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, true);
    this.b = paramJceInputStream.read(this.b, 1, false);
    if (d == null)
    {
      d = new ArrayList();
      d.add(Integer.valueOf(0));
    }
    this.c = ((ArrayList)paramJceInputStream.read(d, 2, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    int i = this.b;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    ArrayList localArrayList = this.c;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aa
 * JD-Core Version:    0.7.0.1
 */