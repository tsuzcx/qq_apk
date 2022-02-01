package com.tencent.turingfd.sdk.qps;

import com.tencent.token.aer;
import com.tencent.token.afb;
import com.tencent.token.afd;
import com.tencent.token.afj;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class Leo
  extends Orion
{
  public static byte[] a = null;
  public static Map<String, String> b = null;
  public short d = 0;
  public byte e = 0;
  public int f = 0;
  public int g = 0;
  public String h = null;
  public String i = null;
  public byte[] j;
  public int k = 0;
  public Map<String, String> l;
  public Map<String, String> m;
  
  public final void a(afb paramafb)
  {
    try
    {
      this.d = paramafb.a(this.d, 1, true);
      this.e = paramafb.a(this.e, 2, true);
      this.f = paramafb.a(this.f, 3, true);
      this.g = paramafb.a(this.g, 4, true);
      this.h = paramafb.a(5, true);
      this.i = paramafb.a(6, true);
      if (a == null) {
        a = new byte[] { 0 };
      }
      this.j = paramafb.b(7, true);
      this.k = paramafb.a(this.k, 8, true);
      HashMap localHashMap;
      if (b == null)
      {
        localHashMap = new HashMap();
        b = localHashMap;
        localHashMap.put("", "");
      }
      this.l = ((Map)paramafb.a(b, 9, true));
      if (b == null)
      {
        localHashMap = new HashMap();
        b = localHashMap;
        localHashMap.put("", "");
      }
      this.m = ((Map)paramafb.a(b, 10, true));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder("RequestPacket decode error ");
      paramafb = this.j;
      if ((paramafb != null) && (paramafb.length != 0))
      {
        char[] arrayOfChar1 = new char[paramafb.length * 2];
        int n = 0;
        while (n < paramafb.length)
        {
          int i1 = paramafb[n];
          int i2 = n * 2;
          char[] arrayOfChar2 = aer.a;
          arrayOfChar1[(i2 + 1)] = arrayOfChar2[(i1 & 0xF)];
          arrayOfChar1[(i2 + 0)] = arrayOfChar2[((byte)(i1 >>> 4) & 0xF)];
          n += 1;
        }
        paramafb = new String(arrayOfChar1);
      }
      else
      {
        paramafb = null;
      }
      localStringBuilder.append(paramafb);
      localPrintStream.println(localStringBuilder.toString());
      throw new RuntimeException(localException);
    }
  }
  
  public final void a(afd paramafd)
  {
    paramafd.a(this.d, 1);
    paramafd.a(this.e, 2);
    paramafd.a(this.f, 3);
    paramafd.a(this.g, 4);
    paramafd.a(this.h, 5);
    paramafd.a(this.i, 6);
    paramafd.a(this.j, 7);
    paramafd.a(this.k, 8);
    paramafd.a(this.l, 9);
    paramafd.a(this.m, 10);
  }
  
  public final Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    if (c) {
      return null;
    }
    throw new AssertionError();
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (Leo)paramObject;
    return (afj.a(1, paramObject.d)) && (afj.a(1, paramObject.e)) && (afj.a(1, paramObject.f)) && (afj.a(1, paramObject.g)) && (Integer.valueOf(1).equals(paramObject.h)) && (Integer.valueOf(1).equals(paramObject.i)) && (Integer.valueOf(1).equals(paramObject.j)) && (afj.a(1, paramObject.k)) && (Integer.valueOf(1).equals(paramObject.l)) && (Integer.valueOf(1).equals(paramObject.m));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.qps.Leo
 * JD-Core Version:    0.7.0.1
 */