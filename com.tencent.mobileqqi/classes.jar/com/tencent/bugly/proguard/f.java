package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends k
{
  private static byte[] k;
  private static Map<String, String> l;
  public short a = 0;
  public int b = 0;
  public String c = null;
  public String d = null;
  public byte[] e;
  private byte f = 0;
  private int g = 0;
  private int h = 0;
  private Map<String, String> i;
  private Map<String, String> j;
  
  static
  {
    if (!f.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      m = bool;
      k = null;
      l = null;
      return;
    }
  }
  
  public final void a(i parami)
  {
    try
    {
      this.a = parami.a(this.a, 1, true);
      this.f = parami.a(this.f, 2, true);
      this.g = parami.a(this.g, 3, true);
      this.b = parami.a(this.b, 4, true);
      this.c = parami.b(5, true);
      this.d = parami.b(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      Object localObject = k;
      this.e = ((byte[])parami.c(7, true));
      this.h = parami.a(this.h, 8, true);
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.i = ((Map)parami.a(l, 9, true));
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.j = ((Map)parami.a(l, 10, true));
      return;
    }
    catch (Exception parami)
    {
      parami.printStackTrace();
      System.out.println("RequestPacket decode error " + e.a(this.e));
      throw new RuntimeException(parami);
    }
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 1);
    paramj.a(this.f, 2);
    paramj.a(this.g, 3);
    paramj.a(this.b, 4);
    paramj.a(this.c, 5);
    paramj.a(this.d, 6);
    paramj.a(this.e, 7);
    paramj.a(this.h, 8);
    paramj.a(this.i, 9);
    paramj.a(this.j, 10);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new h(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "iVersion");
    paramStringBuilder.a(this.f, "cPacketType");
    paramStringBuilder.a(this.g, "iMessageType");
    paramStringBuilder.a(this.b, "iRequestId");
    paramStringBuilder.a(this.c, "sServantName");
    paramStringBuilder.a(this.d, "sFuncName");
    paramStringBuilder.a(this.e, "sBuffer");
    paramStringBuilder.a(this.h, "iTimeout");
    paramStringBuilder.a(this.i, "context");
    paramStringBuilder.a(this.j, "status");
  }
  
  public final Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (m) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (f)paramObject;
    return (l.a(1, paramObject.a)) && (l.a(1, paramObject.f)) && (l.a(1, paramObject.g)) && (l.a(1, paramObject.b)) && (l.a(Integer.valueOf(1), paramObject.c)) && (l.a(Integer.valueOf(1), paramObject.d)) && (l.a(Integer.valueOf(1), paramObject.e)) && (l.a(1, paramObject.h)) && (l.a(Integer.valueOf(1), paramObject.i)) && (l.a(Integer.valueOf(1), paramObject.j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.f
 * JD-Core Version:    0.7.0.1
 */