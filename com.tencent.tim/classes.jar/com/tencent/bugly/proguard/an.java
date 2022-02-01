package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

public final class an
  extends k
{
  private static byte[] i;
  private static Map<String, String> j;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public long d = 0L;
  public String e = "";
  private String f = "";
  private String g = "";
  private Map<String, String> h = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    i = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
    j = new HashMap();
    j.put("", "");
  }
  
  public final void a(i parami)
  {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.a(this.b, 1, true);
    byte[] arrayOfByte = i;
    this.c = ((byte[])parami.c(2, false));
    this.f = parami.b(3, false);
    this.d = parami.a(this.d, 4, false);
    this.g = parami.b(5, false);
    this.e = parami.b(6, false);
    this.h = ((Map)parami.a(j, 7, false));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    if (this.c != null) {
      paramj.a(this.c, 2);
    }
    if (this.f != null) {
      paramj.a(this.f, 3);
    }
    paramj.a(this.d, 4);
    if (this.g != null) {
      paramj.a(this.g, 5);
    }
    if (this.e != null) {
      paramj.a(this.e, 6);
    }
    if (this.h != null) {
      paramj.a(this.h, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.an
 * JD-Core Version:    0.7.0.1
 */