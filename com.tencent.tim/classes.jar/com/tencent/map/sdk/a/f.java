package com.tencent.map.sdk.a;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends n
{
  static byte[] k;
  static Map<String, String> l;
  public short a = 0;
  public byte b = 0;
  public int c = 0;
  public int d = 0;
  public String e = null;
  public String f = null;
  public byte[] g;
  public int h = 0;
  public Map<String, String> i;
  public Map<String, String> j;
  
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
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new i(paramStringBuilder, paramInt);
    paramStringBuilder.a(this.a, "iVersion");
    paramStringBuilder.a(this.b, "cPacketType");
    paramStringBuilder.a(this.c, "iMessageType");
    paramStringBuilder.a(this.d, "iRequestId");
    paramStringBuilder.a(this.e, "sServantName");
    paramStringBuilder.a(this.f, "sFuncName");
    paramStringBuilder.a(this.g, "sBuffer");
    paramStringBuilder.a(this.h, "iTimeout");
    paramStringBuilder.a(this.i, "context");
    paramStringBuilder.a(this.j, "status");
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (f)paramObject;
    return (o.a(1, paramObject.a)) && (o.a(1, paramObject.b)) && (o.a(1, paramObject.c)) && (o.a(1, paramObject.d)) && (o.a(Integer.valueOf(1), paramObject.e)) && (o.a(Integer.valueOf(1), paramObject.f)) && (o.a(Integer.valueOf(1), paramObject.g)) && (o.a(1, paramObject.h)) && (o.a(Integer.valueOf(1), paramObject.i)) && (o.a(Integer.valueOf(1), paramObject.j));
  }
  
  public final void readFrom(k paramk)
  {
    try
    {
      this.a = paramk.a(this.a, 1, true);
      this.b = paramk.a(this.b, 2, true);
      this.c = paramk.a(this.c, 3, true);
      this.d = paramk.a(this.d, 4, true);
      this.e = paramk.b(5, true);
      this.f = paramk.b(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.g = ((byte[])paramk.c(7, true));
      this.h = paramk.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)paramk.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new HashMap();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)paramk.a(l, 10, true));
      return;
    }
    catch (Exception paramk)
    {
      paramk.printStackTrace();
      System.out.println("RequestPacket decode error " + g.a(this.g));
      throw new RuntimeException(paramk);
    }
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.a, 1);
    paraml.a(this.b, 2);
    paraml.a(this.c, 3);
    paraml.a(this.d, 4);
    paraml.a(this.e, 5);
    paraml.a(this.f, 6);
    paraml.a(this.g, 7);
    paraml.a(this.h, 8);
    paraml.a(this.i, 9);
    paraml.a(this.j, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.f
 * JD-Core Version:    0.7.0.1
 */