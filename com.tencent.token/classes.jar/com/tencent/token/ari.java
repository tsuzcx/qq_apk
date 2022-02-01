package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class ari
  extends JceStruct
{
  static are f = new are();
  static arf g = new arf();
  static arf h = new arf();
  static ArrayList<arj> i = new ArrayList();
  public String a = "";
  public are b = null;
  public arf c = null;
  public arf d = null;
  public ArrayList<arj> e = null;
  
  static
  {
    arj localarj = new arj();
    i.add(localarj);
  }
  
  public final JceStruct newInit()
  {
    return new ari();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = ((are)paramJceInputStream.read(f, 1, false));
    this.c = ((arf)paramJceInputStream.read(g, 2, false));
    this.d = ((arf)paramJceInputStream.read(h, 3, false));
    this.e = ((ArrayList)paramJceInputStream.read(i, 4, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    Object localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.d;
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
 * Qualified Name:     com.tencent.token.ari
 * JD-Core Version:    0.7.0.1
 */