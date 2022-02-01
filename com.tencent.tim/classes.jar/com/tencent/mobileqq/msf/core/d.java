package com.tencent.mobileqq.msf.core;

import android.text.TextUtils;
import com.tencent.msf.service.protocol.serverconfig.i;
import com.tencent.msf.service.protocol.serverconfig.k;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
{
  public static final String a = "none";
  public static final String b = "http";
  public static final String c = "socket";
  public static final String d = "quic";
  public static final String e = "00000";
  private static final String l = "EndpointKey";
  private static final Pattern m = Pattern.compile("([a-zA-Z]+)://([a-zA-Z0-9.]+|\\[[a-zA-Z0-9:]+\\])(:([0-9]+))?(#([0-9_]*))?(:([0-9]+))?(:([0-9]+))?(:([0-9]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?");
  private static final Pattern n = Pattern.compile("[a-fA-F0-9:][a-fA-F0-9.:]+");
  public byte f = 1;
  public byte g = 0;
  public boolean h = false;
  public String i = "";
  public String j = "";
  public String k = "";
  private String o = "socket";
  private String p;
  private boolean q = false;
  private int r = 0;
  private int s;
  private int t = 20000;
  private boolean u = false;
  private AtomicInteger v = new AtomicInteger();
  private long w = 0L;
  private boolean x = false;
  
  public static d a(i parami, String paramString, int paramInt)
  {
    d locald = new d();
    a(locald, parami.e, parami.a, paramInt, parami.b, parami.d, parami.f, parami.g, parami.h, parami.i, paramString);
    return locald;
  }
  
  public static d a(k paramk, String paramString, int paramInt)
  {
    d locald = new d();
    a(locald, paramk.e, paramk.a, paramInt, paramk.b, paramk.d, paramk.f, paramk.g, paramk.h, paramk.i, paramString);
    return locald;
  }
  
  public static d a(String paramString)
  {
    boolean bool = false;
    Object localObject = paramString.toLowerCase();
    paramString = new d();
    localObject = m.matcher((CharSequence)localObject);
    if (((Matcher)localObject).find())
    {
      if (((Matcher)localObject).group(1) != null)
      {
        paramString.o = ((Matcher)localObject).group(1);
        if (TextUtils.equals("https", paramString.o)) {
          paramString.o = "http";
        }
      }
      if (((Matcher)localObject).group(2) != null)
      {
        paramString.p = ((Matcher)localObject).group(2);
        if ((!paramString.p.startsWith("[")) || (!paramString.p.endsWith("]"))) {
          break label321;
        }
        paramString.p = paramString.p.substring(1, paramString.p.length() - 1);
        paramString.r = 2;
        paramString.q = false;
      }
      if (((Matcher)localObject).group(4) == null) {
        break label418;
      }
    }
    label418:
    for (paramString.s = Integer.parseInt(((Matcher)localObject).group(4));; paramString.s = 80)
    {
      for (;;)
      {
        if (((Matcher)localObject).group(6) != null) {
          paramString.i = ((Matcher)localObject).group(6);
        }
        if (((Matcher)localObject).group(8) != null) {
          paramString.f = Byte.parseByte(((Matcher)localObject).group(8));
        }
        if (((Matcher)localObject).group(10) != null) {
          paramString.g = Byte.parseByte(((Matcher)localObject).group(10));
        }
        if (((Matcher)localObject).group(12) != null) {
          paramString.t = (Integer.parseInt(((Matcher)localObject).group(12)) * 1000);
        }
        if (((Matcher)localObject).group(14) != null) {
          paramString.u = Boolean.parseBoolean(((Matcher)localObject).group(14));
        }
        if (((Matcher)localObject).group(16) != null) {
          paramString.j = ((Matcher)localObject).group(16);
        }
        if (((Matcher)localObject).group(18) != null) {
          paramString.k = ((Matcher)localObject).group(18);
        }
        paramString.a(paramString.i.equals("00000"));
        return paramString;
        label321:
        if (("msfwifiv6.3g.qq.com".equals(paramString.p)) || ("msfxgv6.3g.qq.com".equals(paramString.p)))
        {
          paramString.r = 2;
          paramString.q = true;
          break;
        }
        if (!n.matcher(paramString.p).matches()) {
          bool = true;
        }
        paramString.q = bool;
        paramString.r = 1;
        if (paramString.q) {
          break;
        }
        try
        {
          if (!(InetAddress.getByName(paramString.p) instanceof Inet6Address)) {
            break;
          }
          paramString.r = 2;
        }
        catch (UnknownHostException localUnknownHostException) {}
      }
      break;
    }
  }
  
  private static void a(d paramd, byte paramByte1, String paramString1, int paramInt1, int paramInt2, byte paramByte2, int paramInt3, byte paramByte3, String paramString2, String paramString3, String paramString4)
  {
    boolean bool;
    if ((paramByte1 == 2) || (paramByte1 == 3))
    {
      paramd.o = "http";
      paramd.p = paramString1;
      paramd.r = paramInt1;
      if (n.matcher(paramString1).matches()) {
        break label148;
      }
      bool = true;
      label42:
      paramd.q = bool;
      paramd.s = paramInt2;
      paramd.f = 0;
      paramd.g = paramByte2;
      if (paramInt3 <= 20) {
        break label154;
      }
      paramd.t = 20000;
    }
    for (;;)
    {
      if (paramByte3 == 1) {
        paramd.u = true;
      }
      paramd.j = paramString2;
      paramd.k = paramString3;
      paramd.i = "";
      if (!"Wifi".equals(paramString4)) {
        break label183;
      }
      paramd.i = "00000";
      paramd.a(true);
      return;
      if ((paramByte1 != 0) && (paramByte1 != 1)) {
        break;
      }
      paramd.o = "socket";
      break;
      label148:
      bool = false;
      break label42;
      label154:
      if (paramInt3 < 5) {
        paramd.t = 5000;
      } else {
        paramd.t = (paramInt3 * 1000);
      }
    }
    label183:
    paramd.a(false);
  }
  
  public String a()
  {
    if ((2 == this.r) && (!this.q)) {}
    for (String str = "[" + this.p + "]";; str = this.p) {
      return str + ":" + this.s;
    }
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public boolean a(com.tencent.qphone.base.a parama)
  {
    boolean bool = false;
    long l1 = System.currentTimeMillis();
    if ((parama == com.tencent.qphone.base.a.d) || (parama == com.tencent.qphone.base.a.c)) {
      if ((this.w == 0L) || (l1 - this.w > 600000L))
      {
        this.w = l1;
        this.v.incrementAndGet();
      }
    }
    for (;;)
    {
      if (this.v.get() > 19)
      {
        this.v.set(0);
        bool = true;
      }
      return bool;
      this.v.addAndGet(com.tencent.mobileqq.msf.core.a.a.aS());
      continue;
      if (parama == com.tencent.qphone.base.a.e) {
        this.v.addAndGet(com.tencent.mobileqq.msf.core.a.a.aT());
      } else if (parama == com.tencent.qphone.base.a.B) {
        this.v.addAndGet(com.tencent.mobileqq.msf.core.a.a.aU());
      } else if (parama == com.tencent.qphone.base.a.p) {
        this.v.addAndGet(com.tencent.mobileqq.msf.core.a.a.aV());
      } else if (parama == com.tencent.qphone.base.a.j) {
        this.v.addAndGet(com.tencent.mobileqq.msf.core.a.a.aW());
      } else if (parama == com.tencent.qphone.base.a.i) {
        this.v.addAndGet(com.tencent.mobileqq.msf.core.a.a.aX());
      }
    }
  }
  
  public String b()
  {
    return this.o;
  }
  
  public void b(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void b(String paramString)
  {
    this.o = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public String c()
  {
    return this.p;
  }
  
  public void c(String paramString)
  {
    this.p = paramString;
  }
  
  public int d()
  {
    return this.r;
  }
  
  public boolean e()
  {
    return this.q;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof d)) && (((d)paramObject).toString().equals(toString()));
  }
  
  public int f()
  {
    return this.s;
  }
  
  public int g()
  {
    return this.t;
  }
  
  public void h()
  {
    this.w = System.currentTimeMillis();
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
  
  public boolean i()
  {
    return this.x;
  }
  
  public boolean j()
  {
    return this.u;
  }
  
  public boolean k()
  {
    return (!TextUtils.isEmpty(this.p)) && (!"null".equals(this.p));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.o).append("://");
    if ((2 == this.r) && (!this.q)) {}
    for (String str = "[" + this.p + "]";; str = this.p) {
      return str + ":" + this.s + "#" + this.i + ":" + this.f + ":" + this.g + ":" + this.t / 1000 + ":" + this.u + ":" + this.j + ":" + this.k + ":" + this.r + ":" + this.q;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d
 * JD-Core Version:    0.7.0.1
 */