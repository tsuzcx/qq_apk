package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class aoo
  extends JceStruct
{
  static aok f = new aok();
  static aol g = new aol();
  static aol h = new aol();
  static ArrayList<aop> i = new ArrayList();
  public String a = "";
  public aok b = null;
  public aol c = null;
  public aol d = null;
  public ArrayList<aop> e = null;
  
  static
  {
    aop localaop = new aop();
    i.add(localaop);
  }
  
  public final JceStruct newInit()
  {
    return new aoo();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = ((aok)paramJceInputStream.read(f, 1, false));
    this.c = ((aol)paramJceInputStream.read(g, 2, false));
    this.d = ((aol)paramJceInputStream.read(h, 3, false));
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
 * Qualified Name:     com.tencent.token.aoo
 * JD-Core Version:    0.7.0.1
 */