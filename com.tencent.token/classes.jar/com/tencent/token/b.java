package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class b
  extends JceStruct
{
  static ArrayList<String> d = new ArrayList();
  public ArrayList<String> a = null;
  public int b = 0;
  public String c = "";
  
  static
  {
    d.add("");
  }
  
  public final JceStruct newInit()
  {
    return new b();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = ((ArrayList)paramJceInputStream.read(d, 0, false));
    this.b = paramJceInputStream.read(this.b, 1, false);
    this.c = paramJceInputStream.readString(2, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    int i = this.b;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.b
 * JD-Core Version:    0.7.0.1
 */