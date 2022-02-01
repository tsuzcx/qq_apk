package com.tencent.feedback.eup;

import com.tencent.feedback.common.PlugInInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class e
  implements Serializable
{
  private long A = -1L;
  private long B = -1L;
  private long C = -1L;
  private long D = -1L;
  private String E;
  private byte[] F;
  private Map<String, PlugInInfo> G;
  private String H;
  private boolean I;
  private String J;
  private String K = "";
  private String L = "";
  private String M = "unknown";
  private String N = "";
  private String O = "";
  private String P = "";
  private final Map<String, String> Q = new HashMap();
  private long R = -1L;
  public int a = -1;
  public int b = -1;
  public Map<String, String> c = null;
  public Map<String, String> d = null;
  private long e = -1L;
  private byte f = 0;
  private boolean g = false;
  private boolean h = false;
  private int i = 0;
  private String j = "";
  private String k;
  private String l;
  private String m;
  private String n;
  private long o;
  private String p;
  private int q;
  private byte[] r;
  private String s;
  private String t;
  private String u;
  private String v;
  private long w = -1L;
  private long x = -1L;
  private long y = -1L;
  private long z = -1L;
  
  public e()
  {
    try
    {
      this.H = UUID.randomUUID().toString();
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((!com.tencent.feedback.common.e.a(localThrowable)) && (!com.tencent.feedback.common.e.a(localThrowable))) {
        localThrowable.printStackTrace();
      }
      this.H = "unknown";
    }
  }
  
  public final String A()
  {
    return this.L;
  }
  
  public final String B()
  {
    return this.M;
  }
  
  public final Map<String, String> C()
  {
    return this.Q;
  }
  
  public final String D()
  {
    return this.N;
  }
  
  public final boolean E()
  {
    return this.h;
  }
  
  public final long F()
  {
    return this.w;
  }
  
  public final long G()
  {
    return this.x;
  }
  
  public final long H()
  {
    return this.y;
  }
  
  public final long I()
  {
    return this.z;
  }
  
  public final long J()
  {
    return this.A;
  }
  
  public final long K()
  {
    return this.B;
  }
  
  public final long L()
  {
    return this.C;
  }
  
  public final long M()
  {
    return this.D;
  }
  
  public final String N()
  {
    return this.O;
  }
  
  public final String O()
  {
    return this.P;
  }
  
  public final byte P()
  {
    return this.f;
  }
  
  public final long Q()
  {
    return this.R;
  }
  
  public final int R()
  {
    return this.a;
  }
  
  public final int S()
  {
    return this.b;
  }
  
  public final Map<String, String> T()
  {
    return this.c;
  }
  
  public final Map<String, String> U()
  {
    return this.d;
  }
  
  public final long a()
  {
    return this.e;
  }
  
  public final void a(byte paramByte)
  {
    this.f = paramByte;
  }
  
  public final void a(float paramFloat) {}
  
  public final void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.k = paramString;
  }
  
  public final void a(Map<String, PlugInInfo> paramMap)
  {
    this.G = paramMap;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.g = true;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.r = paramArrayOfByte;
  }
  
  public final void b(int paramInt)
  {
    this.q = paramInt;
  }
  
  public final void b(long paramLong)
  {
    this.o = paramLong;
  }
  
  public final void b(String paramString)
  {
    this.l = paramString;
  }
  
  public final void b(Map<String, String> paramMap)
  {
    this.c = paramMap;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.I = true;
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    this.F = paramArrayOfByte;
  }
  
  public final boolean b()
  {
    return this.f == 0;
  }
  
  public final void c(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void c(long paramLong)
  {
    this.w = paramLong;
  }
  
  public final void c(String paramString)
  {
    this.m = paramString;
  }
  
  public final void c(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.h = true;
  }
  
  public final boolean c()
  {
    return this.g;
  }
  
  public final void d(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void d(long paramLong)
  {
    this.x = paramLong;
  }
  
  public final void d(String paramString)
  {
    this.n = paramString;
  }
  
  public final boolean d()
  {
    return this.f == 2;
  }
  
  public final String e()
  {
    return this.k;
  }
  
  public final void e(long paramLong)
  {
    this.y = paramLong;
  }
  
  public final void e(String paramString)
  {
    this.j = paramString;
  }
  
  public final String f()
  {
    return this.l;
  }
  
  public final void f(long paramLong)
  {
    this.z = paramLong;
  }
  
  public final void f(String paramString)
  {
    this.p = paramString;
  }
  
  public final String g()
  {
    return this.m;
  }
  
  public final void g(long paramLong)
  {
    this.A = paramLong;
  }
  
  public final void g(String paramString)
  {
    this.s = paramString;
  }
  
  public final String h()
  {
    return this.n;
  }
  
  public final void h(long paramLong)
  {
    this.B = paramLong;
  }
  
  public final void h(String paramString)
  {
    this.t = paramString;
  }
  
  public final long i()
  {
    return this.o;
  }
  
  public final void i(long paramLong)
  {
    this.C = paramLong;
  }
  
  public final void i(String paramString)
  {
    this.u = paramString;
  }
  
  public final int j()
  {
    return this.i;
  }
  
  public final void j(long paramLong)
  {
    this.D = paramLong;
  }
  
  public final void j(String paramString)
  {
    this.v = paramString;
  }
  
  public final String k()
  {
    return this.j;
  }
  
  public final void k(long paramLong)
  {
    this.R = paramLong;
  }
  
  public final void k(String paramString)
  {
    this.E = paramString;
  }
  
  public final String l()
  {
    return this.p;
  }
  
  public final void l(String paramString)
  {
    this.H = paramString;
  }
  
  public final int m()
  {
    return this.q;
  }
  
  public final void m(String paramString)
  {
    this.J = paramString;
  }
  
  public final void n(String paramString)
  {
    this.K = paramString;
  }
  
  public final byte[] n()
  {
    return this.r;
  }
  
  public final String o()
  {
    return this.s;
  }
  
  public final void o(String paramString)
  {
    this.L = paramString;
  }
  
  public final String p()
  {
    return this.t;
  }
  
  public final void p(String paramString)
  {
    this.M = paramString;
  }
  
  public final String q()
  {
    return this.u;
  }
  
  public final void q(String paramString)
  {
    this.N = paramString;
  }
  
  public final String r()
  {
    return this.v;
  }
  
  public final void r(String paramString)
  {
    this.O = paramString;
  }
  
  public final String s()
  {
    return this.E;
  }
  
  public final void s(String paramString)
  {
    this.P = paramString;
  }
  
  public final byte[] t()
  {
    return this.F;
  }
  
  public final Map<String, PlugInInfo> u()
  {
    return this.G;
  }
  
  public final String v()
  {
    return this.H;
  }
  
  public final boolean w()
  {
    return this.I;
  }
  
  public final boolean x()
  {
    return this.f == 3;
  }
  
  public final String y()
  {
    return this.J;
  }
  
  public final String z()
  {
    return this.K;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.e
 * JD-Core Version:    0.7.0.1
 */