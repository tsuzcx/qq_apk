package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class aj
  extends JceStruct
{
  static ab f;
  static ArrayList g;
  public int a = 0;
  public int b = 0;
  public int c = 1;
  public ab d = null;
  public ArrayList e = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    if (f == null) {
      f = new ab();
    }
    this.d = ((ab)paramJceInputStream.read(f, 3, false));
    if (g == null)
    {
      g = new ArrayList();
      ai localai = new ai();
      g.add(localai);
    }
    this.e = ((ArrayList)paramJceInputStream.read(g, 4, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.a;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.b;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.c;
    if (i != 1) {
      paramJceOutputStream.write(i, 2);
    }
    Object localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aj
 * JD-Core Version:    0.7.0.1
 */