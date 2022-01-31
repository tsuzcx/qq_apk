package com.tencent.feedback.proguard;

import com.tencent.feedback.common.service.a;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends j
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
  
  public final void a(h paramh)
  {
    try
    {
      this.a = paramh.a(this.a, 1, true);
      this.f = paramh.a(this.f, 2, true);
      this.g = paramh.a(this.g, 3, true);
      this.b = paramh.a(this.b, 4, true);
      this.c = paramh.b(5, true);
      this.d = paramh.b(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      Object localObject = k;
      this.e = ((byte[])paramh.c(7, true));
      this.h = paramh.a(this.h, 8, true);
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.i = ((Map)paramh.a(l, 9, true));
      if (l == null)
      {
        localObject = new HashMap();
        l = (Map)localObject;
        ((Map)localObject).put("", "");
      }
      this.j = ((Map)paramh.a(l, 10, true));
      return;
    }
    catch (Exception paramh)
    {
      paramh.printStackTrace();
      System.out.println("RequestPacket decode error " + e.a(this.e));
      throw new RuntimeException(paramh);
    }
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 1);
    parami.a(this.f, 2);
    parami.a(this.g, 3);
    parami.a(this.b, 4);
    parami.a(this.c, 5);
    parami.a(this.d, 6);
    parami.a(this.e, 7);
    parami.a(this.h, 8);
    parami.a(this.i, 9);
    parami.a(this.j, 10);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new a(paramStringBuilder, paramInt);
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
    return (k.a(1, paramObject.a)) && (k.a(1, paramObject.f)) && (k.a(1, paramObject.g)) && (k.a(1, paramObject.b)) && (k.a(Integer.valueOf(1), paramObject.c)) && (k.a(Integer.valueOf(1), paramObject.d)) && (k.a(Integer.valueOf(1), paramObject.e)) && (k.a(1, paramObject.h)) && (k.a(Integer.valueOf(1), paramObject.i)) && (k.a(Integer.valueOf(1), paramObject.j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.f
 * JD-Core Version:    0.7.0.1
 */