package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class aoc
  extends JceStruct
{
  static ArrayList<ano> f = new ArrayList();
  public int a = 0;
  public int b = 0;
  public ArrayList<ano> c = null;
  public String d = "";
  public int e = 0;
  
  static
  {
    ano localano = new ano();
    f.add(localano);
  }
  
  public final JceStruct newInit()
  {
    return new aoc();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.read(this.a, 0, false);
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = ((ArrayList)paramJceInputStream.read(f, 2, false));
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.read(this.e, 4, false);
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
    Object localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    i = this.e;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoc
 * JD-Core Version:    0.7.0.1
 */