package com.tencent.mobileqq.msf.core;

import com.tencent.msf.service.protocol.h.i;
import com.tencent.qphone.base.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static final int a = 0;
  public static final int b = 1;
  public static final String c = "00000";
  public static final String d = "http";
  public static final String e = "socket";
  public byte f = 1;
  public byte g = 0;
  public String h = "";
  public AtomicInteger i = new AtomicInteger();
  long j = 0L;
  public boolean k = false;
  private String l = "socket";
  private String m;
  private int n;
  private int o = 20000;
  
  public static d a(i parami, int paramInt)
  {
    d locald = new d();
    if ((parami.e == 2) || (parami.e == 3))
    {
      locald.l = "http";
      locald.m = parami.a;
      locald.n = parami.b;
      locald.h = "";
      locald.f = 0;
      locald.g = parami.d;
      if (parami.f <= 20) {
        break label122;
      }
      locald.o = 20000;
    }
    for (;;)
    {
      if (paramInt != 0) {
        break label155;
      }
      locald.h = "00000";
      locald.a(true);
      return locald;
      if ((parami.e != 0) && (parami.e != 1)) {
        break;
      }
      locald.l = "socket";
      break;
      label122:
      if (parami.f < 5) {
        locald.o = 5000;
      } else {
        locald.o = (parami.f * 1000);
      }
    }
    label155:
    locald.a(false);
    return locald;
  }
  
  public static d a(String paramString)
  {
    Object localObject = paramString.toLowerCase();
    paramString = new d();
    localObject = Pattern.compile("([a-zA-Z]+)://([a-zA-Z0-9.]+)(:([0-9]+))?(#([0-9_]*))?(:([0-9]+))?(:([0-9]+))?(:([0-9]+))?").matcher((CharSequence)localObject);
    if (((Matcher)localObject).matches())
    {
      if (((Matcher)localObject).group(1) != null) {
        paramString.l = ((Matcher)localObject).group(1);
      }
      if (((Matcher)localObject).group(2) != null) {
        paramString.m = ((Matcher)localObject).group(2);
      }
      if (((Matcher)localObject).group(4) == null) {
        break label188;
      }
    }
    label188:
    for (paramString.n = Integer.parseInt(((Matcher)localObject).group(4));; paramString.n = 80)
    {
      if (((Matcher)localObject).group(6) != null) {
        paramString.h = ((Matcher)localObject).group(6);
      }
      if (((Matcher)localObject).group(8) != null) {
        paramString.f = Byte.parseByte(((Matcher)localObject).group(8));
      }
      if (((Matcher)localObject).group(10) != null) {
        paramString.g = Byte.parseByte(((Matcher)localObject).group(10));
      }
      if (((Matcher)localObject).group(12) != null) {
        paramString.o = (Integer.parseInt(((Matcher)localObject).group(12)) * 1000);
      }
      paramString.a(paramString.h.equals("00000"));
      return paramString;
    }
  }
  
  public String a()
  {
    return this.m + ":" + this.n;
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean a(a parama)
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    if ((parama == a.d) || (parama == a.c)) {
      if ((this.j == 0L) || (l1 - this.j > 600000L))
      {
        this.j = l1;
        this.i.incrementAndGet();
      }
    }
    for (;;)
    {
      if (this.i.get() > 19)
      {
        this.i.set(0);
        bool = true;
      }
      return bool;
      this.i.addAndGet(10);
      continue;
      if (parama == a.e) {
        this.i.addAndGet(10);
      } else if (parama == a.p) {
        this.i.addAndGet(20);
      } else if ((parama == a.j) || (parama == a.i)) {
        this.i.addAndGet(20);
      }
    }
  }
  
  public String b()
  {
    return this.l;
  }
  
  public void b(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void b(String paramString)
  {
    this.l = paramString;
  }
  
  public String c()
  {
    return this.m;
  }
  
  public void c(String paramString)
  {
    this.m = paramString;
  }
  
  public int d()
  {
    return this.n;
  }
  
  public int e()
  {
    return this.o;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof d)) && (((d)paramObject).toString().equals(toString()));
  }
  
  public void f()
  {
    this.j = System.currentTimeMillis();
  }
  
  public boolean g()
  {
    return this.k;
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public String toString()
  {
    return this.l + "://" + this.m + ":" + this.n + "#" + this.h + ":" + this.f + ":" + this.g + ":" + this.o / 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d
 * JD-Core Version:    0.7.0.1
 */