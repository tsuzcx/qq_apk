package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class aqk
  extends JceStruct
{
  static aqg f = new aqg();
  static aqh g = new aqh();
  static aqh h = new aqh();
  static ArrayList<aql> i = new ArrayList();
  public String a = "";
  public aqg b = null;
  public aqh c = null;
  public aqh d = null;
  public ArrayList<aql> e = null;
  
  static
  {
    aql localaql = new aql();
    i.add(localaql);
  }
  
  public final JceStruct newInit()
  {
    return new aqk();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = ((aqg)paramJceInputStream.read(f, 1, false));
    this.c = ((aqh)paramJceInputStream.read(g, 2, false));
    this.d = ((aqh)paramJceInputStream.read(h, 3, false));
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
 * Qualified Name:     com.tencent.token.aqk
 * JD-Core Version:    0.7.0.1
 */