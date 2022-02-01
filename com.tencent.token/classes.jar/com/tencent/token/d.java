package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends JceStruct
{
  static Map<String, String> j = new HashMap();
  static ArrayList<a> k;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public int f = 0;
  public Map<String, String> g = null;
  public ArrayList<a> h = null;
  public String i = "";
  
  static
  {
    j.put("", "");
    k = new ArrayList();
    a locala = new a();
    k.add(locala);
  }
  
  public final JceStruct newInit()
  {
    return new d();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, false);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.readString(2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.read(this.f, 5, false);
    this.g = ((Map)paramJceInputStream.read(j, 6, false));
    this.h = ((ArrayList)paramJceInputStream.read(k, 7, false));
    this.i = paramJceInputStream.readString(8, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.a;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.c;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    int m = this.f;
    if (m != 0) {
      paramJceOutputStream.write(m, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    localObject = this.h;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.i;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.d
 * JD-Core Version:    0.7.0.1
 */