package com.tencent.token;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class t
  extends JceStruct
{
  static Map<String, String> j = new HashMap();
  public String a = "";
  public String b = "";
  public int c = 0;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public long h = 0L;
  public Map<String, String> i = null;
  
  static
  {
    j.put("", "");
  }
  
  public final JceStruct newInit()
  {
    return new t();
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.a = paramJceInputStream.readString(0, true);
    this.b = paramJceInputStream.readString(1, false);
    this.c = paramJceInputStream.read(this.c, 2, false);
    this.d = paramJceInputStream.readString(3, false);
    this.e = paramJceInputStream.readString(4, false);
    this.f = paramJceInputStream.readString(5, false);
    this.g = paramJceInputStream.readString(6, false);
    this.h = paramJceInputStream.read(this.h, 7, false);
    this.i = ((Map)paramJceInputStream.read(j, 8, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.a, 0);
    Object localObject = this.b;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    int k = this.c;
    if (k != 0) {
      paramJceOutputStream.write(k, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.e;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.f;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.g;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    long l = this.h;
    if (l != 0L) {
      paramJceOutputStream.write(l, 7);
    }
    localObject = this.i;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.t
 * JD-Core Version:    0.7.0.1
 */