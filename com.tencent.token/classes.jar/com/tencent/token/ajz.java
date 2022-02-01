package com.tencent.token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class ajz
{
  static final ajy[] a;
  static final Map<alb, Integer> b;
  
  static
  {
    Object localObject = new ajy(ajy.f, "");
    int i = 0;
    a = new ajy[] { localObject, new ajy(ajy.c, "GET"), new ajy(ajy.c, "POST"), new ajy(ajy.d, "/"), new ajy(ajy.d, "/index.html"), new ajy(ajy.e, "http"), new ajy(ajy.e, "https"), new ajy(ajy.b, "200"), new ajy(ajy.b, "204"), new ajy(ajy.b, "206"), new ajy(ajy.b, "304"), new ajy(ajy.b, "400"), new ajy(ajy.b, "404"), new ajy(ajy.b, "500"), new ajy("accept-charset", ""), new ajy("accept-encoding", "gzip, deflate"), new ajy("accept-language", ""), new ajy("accept-ranges", ""), new ajy("accept", ""), new ajy("access-control-allow-origin", ""), new ajy("age", ""), new ajy("allow", ""), new ajy("authorization", ""), new ajy("cache-control", ""), new ajy("content-disposition", ""), new ajy("content-encoding", ""), new ajy("content-language", ""), new ajy("content-length", ""), new ajy("content-location", ""), new ajy("content-range", ""), new ajy("content-type", ""), new ajy("cookie", ""), new ajy("date", ""), new ajy("etag", ""), new ajy("expect", ""), new ajy("expires", ""), new ajy("from", ""), new ajy("host", ""), new ajy("if-match", ""), new ajy("if-modified-since", ""), new ajy("if-none-match", ""), new ajy("if-range", ""), new ajy("if-unmodified-since", ""), new ajy("last-modified", ""), new ajy("link", ""), new ajy("location", ""), new ajy("max-forwards", ""), new ajy("proxy-authenticate", ""), new ajy("proxy-authorization", ""), new ajy("range", ""), new ajy("referer", ""), new ajy("refresh", ""), new ajy("retry-after", ""), new ajy("server", ""), new ajy("set-cookie", ""), new ajy("strict-transport-security", ""), new ajy("transfer-encoding", ""), new ajy("user-agent", ""), new ajy("vary", ""), new ajy("via", ""), new ajy("www-authenticate", "") };
    localObject = new LinkedHashMap(a.length);
    for (;;)
    {
      ajy[] arrayOfajy = a;
      if (i >= arrayOfajy.length) {
        break;
      }
      if (!((Map)localObject).containsKey(arrayOfajy[i].g)) {
        ((Map)localObject).put(a[i].g, Integer.valueOf(i));
      }
      i += 1;
    }
    b = Collections.unmodifiableMap((Map)localObject);
  }
  
  static alb a(alb paramalb)
  {
    int j = paramalb.g();
    int i = 0;
    while (i < j)
    {
      int k = paramalb.a(i);
      if ((k >= 65) && (k <= 90))
      {
        StringBuilder localStringBuilder = new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramalb.a());
        throw new IOException(localStringBuilder.toString());
      }
      i += 1;
    }
    return paramalb;
  }
  
  static final class a
  {
    ajy[] a = new ajy[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<ajy> e = new ArrayList();
    private final ala f;
    private final int g = 4096;
    private int h = 4096;
    
    a(alo paramalo)
    {
      this(paramalo, (byte)0);
    }
    
    private a(alo paramalo, byte paramByte)
    {
      this.f = alh.a(paramalo);
    }
    
    private int a(int paramInt)
    {
      int i = 0;
      int k = 0;
      if (paramInt > 0)
      {
        i = this.a.length - 1;
        int j = paramInt;
        paramInt = k;
        while ((i >= this.b) && (j > 0))
        {
          j -= this.a[i].i;
          this.d -= this.a[i].i;
          this.c -= 1;
          paramInt += 1;
          i -= 1;
        }
        ajy[] arrayOfajy = this.a;
        i = this.b;
        System.arraycopy(arrayOfajy, i + 1, arrayOfajy, i + 1 + paramInt, this.c);
        this.b += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private int a(int paramInt1, int paramInt2)
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = e();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return paramInt2 + (i << paramInt1);
    }
    
    private void a(ajy paramajy)
    {
      this.e.add(paramajy);
      int i = paramajy.i;
      int j = this.h;
      if (i > j)
      {
        d();
        return;
      }
      a(this.d + i - j);
      j = this.c;
      ajy[] arrayOfajy1 = this.a;
      if (j + 1 > arrayOfajy1.length)
      {
        ajy[] arrayOfajy2 = new ajy[arrayOfajy1.length * 2];
        System.arraycopy(arrayOfajy1, 0, arrayOfajy2, arrayOfajy1.length, arrayOfajy1.length);
        this.b = (this.a.length - 1);
        this.a = arrayOfajy2;
      }
      j = this.b;
      this.b = (j - 1);
      this.a[j] = paramajy;
      this.c += 1;
      this.d += i;
    }
    
    private int b(int paramInt)
    {
      return this.b + 1 + paramInt;
    }
    
    private alb c(int paramInt)
    {
      if (d(paramInt)) {
        return ajz.a[paramInt].g;
      }
      int i = b(paramInt - ajz.a.length);
      if (i >= 0)
      {
        localObject = this.a;
        if (i < localObject.length) {
          return localObject[i].g;
        }
      }
      Object localObject = new StringBuilder("Header index too large ");
      ((StringBuilder)localObject).append(paramInt + 1);
      throw new IOException(((StringBuilder)localObject).toString());
    }
    
    private void c()
    {
      int i = this.h;
      int j = this.d;
      if (i < j)
      {
        if (i == 0)
        {
          d();
          return;
        }
        a(j - i);
      }
    }
    
    private void d()
    {
      Arrays.fill(this.a, null);
      this.b = (this.a.length - 1);
      this.c = 0;
      this.d = 0;
    }
    
    private static boolean d(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= ajz.a.length - 1);
    }
    
    private int e()
    {
      return this.f.f() & 0xFF;
    }
    
    private alb f()
    {
      int j = e();
      int i;
      if ((j & 0x80) == 128) {
        i = 1;
      } else {
        i = 0;
      }
      j = a(j, 127);
      if (i != 0) {
        return alb.a(akg.a().a(this.f.f(j)));
      }
      return this.f.c(j);
    }
    
    final void a()
    {
      while (!this.f.c())
      {
        int i = this.f.f() & 0xFF;
        if (i != 128)
        {
          Object localObject;
          if ((i & 0x80) == 128)
          {
            i = a(i, 127) - 1;
            if (d(i))
            {
              localObject = ajz.a[i];
              this.e.add(localObject);
            }
            else
            {
              int j = b(i - ajz.a.length);
              if (j >= 0)
              {
                localObject = this.a;
                if (j < localObject.length)
                {
                  this.e.add(localObject[j]);
                  continue;
                }
              }
              localObject = new StringBuilder("Header index too large ");
              ((StringBuilder)localObject).append(i + 1);
              throw new IOException(((StringBuilder)localObject).toString());
            }
          }
          else if (i == 64)
          {
            a(new ajy(ajz.a(f()), f()));
          }
          else if ((i & 0x40) == 64)
          {
            a(new ajy(c(a(i, 63) - 1), f()));
          }
          else if ((i & 0x20) == 32)
          {
            this.h = a(i, 31);
            i = this.h;
            if ((i >= 0) && (i <= this.g))
            {
              c();
            }
            else
            {
              localObject = new StringBuilder("Invalid dynamic table size update ");
              ((StringBuilder)localObject).append(this.h);
              throw new IOException(((StringBuilder)localObject).toString());
            }
          }
          else
          {
            alb localalb;
            if ((i != 16) && (i != 0))
            {
              localObject = c(a(i, 15) - 1);
              localalb = f();
              this.e.add(new ajy((alb)localObject, localalb));
            }
            else
            {
              localObject = ajz.a(f());
              localalb = f();
              this.e.add(new ajy((alb)localObject, localalb));
            }
          }
        }
        else
        {
          throw new IOException("index == 0");
        }
      }
    }
    
    public final List<ajy> b()
    {
      ArrayList localArrayList = new ArrayList(this.e);
      this.e.clear();
      return localArrayList;
    }
  }
  
  static final class b
  {
    int a = 4096;
    int b = 4096;
    ajy[] c = new ajy[8];
    int d = this.c.length - 1;
    int e = 0;
    int f = 0;
    private final aky g;
    private final boolean h = true;
    private int i = 2147483647;
    private boolean j;
    
    b(aky paramaky)
    {
      this(paramaky, (byte)0);
    }
    
    private b(aky paramaky, byte paramByte)
    {
      this.g = paramaky;
    }
    
    private void a()
    {
      Arrays.fill(this.c, null);
      this.d = (this.c.length - 1);
      this.e = 0;
      this.f = 0;
    }
    
    private void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.g.b(paramInt1 | paramInt3);
        return;
      }
      this.g.b(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.g.b(0x80 | paramInt1 & 0x7F);
        paramInt1 >>>= 7;
      }
      this.g.b(paramInt1);
    }
    
    private void a(ajy paramajy)
    {
      int k = paramajy.i;
      int m = this.b;
      if (k > m)
      {
        a();
        return;
      }
      b(this.f + k - m);
      m = this.e;
      ajy[] arrayOfajy1 = this.c;
      if (m + 1 > arrayOfajy1.length)
      {
        ajy[] arrayOfajy2 = new ajy[arrayOfajy1.length * 2];
        System.arraycopy(arrayOfajy1, 0, arrayOfajy2, arrayOfajy1.length, arrayOfajy1.length);
        this.d = (this.c.length - 1);
        this.c = arrayOfajy2;
      }
      m = this.d;
      this.d = (m - 1);
      this.c[m] = paramajy;
      this.e += 1;
      this.f += k;
    }
    
    private void a(alb paramalb)
    {
      if (this.h)
      {
        akg.a();
        if (akg.a(paramalb) < paramalb.g())
        {
          aky localaky = new aky();
          akg.a();
          akg.a(paramalb, localaky);
          paramalb = localaky.l();
          a(paramalb.g(), 127, 128);
          this.g.a(paramalb);
          return;
        }
      }
      a(paramalb.g(), 127, 0);
      this.g.a(paramalb);
    }
    
    private int b(int paramInt)
    {
      int k = 0;
      int n = 0;
      if (paramInt > 0)
      {
        k = this.c.length - 1;
        int m = paramInt;
        paramInt = n;
        while ((k >= this.d) && (m > 0))
        {
          m -= this.c[k].i;
          this.f -= this.c[k].i;
          this.e -= 1;
          paramInt += 1;
          k -= 1;
        }
        ajy[] arrayOfajy = this.c;
        k = this.d;
        System.arraycopy(arrayOfajy, k + 1, arrayOfajy, k + 1 + paramInt, this.e);
        arrayOfajy = this.c;
        k = this.d;
        Arrays.fill(arrayOfajy, k + 1, k + 1 + paramInt, null);
        this.d += paramInt;
        k = paramInt;
      }
      return k;
    }
    
    final void a(int paramInt)
    {
      this.a = paramInt;
      paramInt = Math.min(paramInt, 16384);
      int k = this.b;
      if (k == paramInt) {
        return;
      }
      if (paramInt < k) {
        this.i = Math.min(this.i, paramInt);
      }
      this.j = true;
      this.b = paramInt;
      paramInt = this.b;
      k = this.f;
      if (paramInt < k)
      {
        if (paramInt == 0)
        {
          a();
          return;
        }
        b(k - paramInt);
      }
    }
    
    final void a(List<ajy> paramList)
    {
      int k;
      if (this.j)
      {
        k = this.i;
        if (k < this.b) {
          a(k, 31, 32);
        }
        this.j = false;
        this.i = 2147483647;
        a(this.b, 31, 32);
      }
      int i4 = paramList.size();
      int n = 0;
      while (n < i4)
      {
        ajy localajy = (ajy)paramList.get(n);
        alb localalb1 = localajy.g.f();
        alb localalb2 = localajy.h;
        Object localObject = (Integer)ajz.b.get(localalb1);
        int m;
        if (localObject != null)
        {
          m = ((Integer)localObject).intValue() + 1;
          if ((m > 1) && (m < 8))
          {
            if (aiw.a(ajz.a[(m - 1)].h, localalb2))
            {
              k = m;
              break label198;
            }
            if (aiw.a(ajz.a[m].h, localalb2))
            {
              k = m;
              m += 1;
              break label198;
            }
          }
          k = m;
          m = -1;
        }
        else
        {
          m = -1;
          k = -1;
        }
        label198:
        int i2 = m;
        int i3 = k;
        if (m == -1)
        {
          int i1 = this.d + 1;
          int i5 = this.c.length;
          for (;;)
          {
            i2 = m;
            i3 = k;
            if (i1 >= i5) {
              break;
            }
            i2 = k;
            if (aiw.a(this.c[i1].g, localalb1))
            {
              if (aiw.a(this.c[i1].h, localalb2))
              {
                m = this.d;
                i2 = ajz.a.length + (i1 - m);
                i3 = k;
                break;
              }
              i2 = k;
              if (k == -1) {
                i2 = i1 - this.d + ajz.a.length;
              }
            }
            i1 += 1;
            k = i2;
          }
        }
        if (i2 != -1)
        {
          a(i2, 127, 128);
        }
        else if (i3 == -1)
        {
          this.g.b(64);
          a(localalb1);
          a(localalb2);
          a(localajy);
        }
        else
        {
          localObject = ajy.a;
          if ((localalb1.a(0, (alb)localObject, 0, ((alb)localObject).g())) && (!ajy.f.equals(localalb1)))
          {
            a(i3, 15, 0);
            a(localalb2);
          }
          else
          {
            a(i3, 63, 64);
            a(localalb2);
            a(localajy);
          }
        }
        n += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajz
 * JD-Core Version:    0.7.0.1
 */