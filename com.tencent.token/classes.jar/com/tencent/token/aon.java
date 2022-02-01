package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class aon
  extends JceStruct
{
  static aoj f = new aoj();
  static aok g = new aok();
  static aok h = new aok();
  static ArrayList<aoo> i = new ArrayList();
  public String a = "";
  public aoj b = null;
  public aok c = null;
  public aok d = null;
  public ArrayList<aoo> e = null;
  
  static
  {
    aoo localaoo = new aoo();
    i.add(localaoo);
  }
  
  public final JceStruct newInit()
  {
    return new aon();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = ((aoj)paramJceInputStream.read(f, 1, false));
    this.c = ((aok)paramJceInputStream.read(g, 2, false));
    this.d = ((aok)paramJceInputStream.read(h, 3, false));
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
 * Qualified Name:     com.tencent.token.aon
 * JD-Core Version:    0.7.0.1
 */