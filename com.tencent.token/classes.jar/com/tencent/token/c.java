package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class c
  extends JceStruct
{
  static ArrayList<b> c = new ArrayList();
  public String a = "";
  public ArrayList<b> b = null;
  
  static
  {
    b localb = new b();
    c.add(localb);
  }
  
  public final JceStruct newInit()
  {
    return new c();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = ((ArrayList)paramJceInputStream.read(c, 1, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.c
 * JD-Core Version:    0.7.0.1
 */