package com.tencent.token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class aka
{
  static final ajz[] a;
  static final Map<alc, Integer> b;
  
  static
  {
    Object localObject = new ajz(ajz.f, "");
    int i = 0;
    a = new ajz[] { localObject, new ajz(ajz.c, "GET"), new ajz(ajz.c, "POST"), new ajz(ajz.d, "/"), new ajz(ajz.d, "/index.html"), new ajz(ajz.e, "http"), new ajz(ajz.e, "https"), new ajz(ajz.b, "200"), new ajz(ajz.b, "204"), new ajz(ajz.b, "206"), new ajz(ajz.b, "304"), new ajz(ajz.b, "400"), new ajz(ajz.b, "404"), new ajz(ajz.b, "500"), new ajz("accept-charset", ""), new ajz("accept-encoding", "gzip, deflate"), new ajz("accept-language", ""), new ajz("accept-ranges", ""), new ajz("accept", ""), new ajz("access-control-allow-origin", ""), new ajz("age", ""), new ajz("allow", ""), new ajz("authorization", ""), new ajz("cache-control", ""), new ajz("content-disposition", ""), new ajz("content-encoding", ""), new ajz("content-language", ""), new ajz("content-length", ""), new ajz("content-location", ""), new ajz("content-range", ""), new ajz("content-type", ""), new ajz("cookie", ""), new ajz("date", ""), new ajz("etag", ""), new ajz("expect", ""), new ajz("expires", ""), new ajz("from", ""), new ajz("host", ""), new ajz("if-match", ""), new ajz("if-modified-since", ""), new ajz("if-none-match", ""), new ajz("if-range", ""), new ajz("if-unmodified-since", ""), new ajz("last-modified", ""), new ajz("link", ""), new ajz("location", ""), new ajz("max-forwards", ""), new ajz("proxy-authenticate", ""), new ajz("proxy-authorization", ""), new ajz("range", ""), new ajz("referer", ""), new ajz("refresh", ""), new ajz("retry-after", ""), new ajz("server", ""), new ajz("set-cookie", ""), new ajz("strict-transport-security", ""), new ajz("transfer-encoding", ""), new ajz("user-agent", ""), new ajz("vary", ""), new ajz("via", ""), new ajz("www-authenticate", "") };
    localObject = new LinkedHashMap(a.length);
    for (;;)
    {
      ajz[] arrayOfajz = a;
      if (i >= arrayOfajz.length) {
        break;
      }
      if (!((Map)localObject).containsKey(arrayOfajz[i].g)) {
        ((Map)localObject).put(a[i].g, Integer.valueOf(i));
      }
      i += 1;
    }
    b = Collections.unmodifiableMap((Map)localObject);
  }
  
  static alc a(alc paramalc)
  {
    int j = paramalc.g();
    int i = 0;
    while (i < j)
    {
      int k = paramalc.a(i);
      if ((k >= 65) && (k <= 90))
      {
        StringBuilder localStringBuilder = new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramalc.a());
        throw new IOException(localStringBuilder.toString());
      }
      i += 1;
    }
    return paramalc;
  }
  
  static final class a
  {
    ajz[] a = new ajz[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<ajz> e = new ArrayList();
    private final alb f;
    private final int g = 4096;
    private int h = 4096;
    
    a(alp paramalp)
    {
      this(paramalp, (byte)0);
    }
    
    private a(alp paramalp, byte paramByte)
    {
      this.f = ali.a(paramalp);
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
        ajz[] arrayOfajz = this.a;
        i = this.b;
        System.arraycopy(arrayOfajz, i + 1, arrayOfajz, i + 1 + paramInt, this.c);
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
    
    private void a(ajz paramajz)
    {
      this.e.add(paramajz);
      int i = paramajz.i;
      int j = this.h;
      if (i > j)
      {
        d();
        return;
      }
      a(this.d + i - j);
      j = this.c;
      ajz[] arrayOfajz1 = this.a;
      if (j + 1 > arrayOfajz1.length)
      {
        ajz[] arrayOfajz2 = new ajz[arrayOfajz1.length * 2];
        System.arraycopy(arrayOfajz1, 0, arrayOfajz2, arrayOfajz1.length, arrayOfajz1.length);
        this.b = (this.a.length - 1);
        this.a = arrayOfajz2;
      }
      j = this.b;
      this.b = (j - 1);
      this.a[j] = paramajz;
      this.c += 1;
      this.d += i;
    }
    
    private int b(int paramInt)
    {
      return this.b + 1 + paramInt;
    }
    
    private alc c(int paramInt)
    {
      if (d(paramInt)) {
        return aka.a[paramInt].g;
      }
      int i = b(paramInt - aka.a.length);
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
      return (paramInt >= 0) && (paramInt <= aka.a.length - 1);
    }
    
    private int e()
    {
      return this.f.f() & 0xFF;
    }
    
    private alc f()
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
        return alc.a(akh.a().a(this.f.f(j)));
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
              localObject = aka.a[i];
              this.e.add(localObject);
            }
            else
            {
              int j = b(i - aka.a.length);
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
            a(new ajz(aka.a(f()), f()));
          }
          else if ((i & 0x40) == 64)
          {
            a(new ajz(c(a(i, 63) - 1), f()));
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
            alc localalc;
            if ((i != 16) && (i != 0))
            {
              localObject = c(a(i, 15) - 1);
              localalc = f();
              this.e.add(new ajz((alc)localObject, localalc));
            }
            else
            {
              localObject = aka.a(f());
              localalc = f();
              this.e.add(new ajz((alc)localObject, localalc));
            }
          }
        }
        else
        {
          throw new IOException("index == 0");
        }
      }
    }
    
    public final List<ajz> b()
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
    ajz[] c = new ajz[8];
    int d = this.c.length - 1;
    int e = 0;
    int f = 0;
    private final akz g;
    private final boolean h = true;
    private int i = 2147483647;
    private boolean j;
    
    b(akz paramakz)
    {
      this(paramakz, (byte)0);
    }
    
    private b(akz paramakz, byte paramByte)
    {
      this.g = paramakz;
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
    
    private void a(ajz paramajz)
    {
      int k = paramajz.i;
      int m = this.b;
      if (k > m)
      {
        a();
        return;
      }
      b(this.f + k - m);
      m = this.e;
      ajz[] arrayOfajz1 = this.c;
      if (m + 1 > arrayOfajz1.length)
      {
        ajz[] arrayOfajz2 = new ajz[arrayOfajz1.length * 2];
        System.arraycopy(arrayOfajz1, 0, arrayOfajz2, arrayOfajz1.length, arrayOfajz1.length);
        this.d = (this.c.length - 1);
        this.c = arrayOfajz2;
      }
      m = this.d;
      this.d = (m - 1);
      this.c[m] = paramajz;
      this.e += 1;
      this.f += k;
    }
    
    private void a(alc paramalc)
    {
      if (this.h)
      {
        akh.a();
        if (akh.a(paramalc) < paramalc.g())
        {
          akz localakz = new akz();
          akh.a();
          akh.a(paramalc, localakz);
          paramalc = localakz.l();
          a(paramalc.g(), 127, 128);
          this.g.a(paramalc);
          return;
        }
      }
      a(paramalc.g(), 127, 0);
      this.g.a(paramalc);
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
        ajz[] arrayOfajz = this.c;
        k = this.d;
        System.arraycopy(arrayOfajz, k + 1, arrayOfajz, k + 1 + paramInt, this.e);
        arrayOfajz = this.c;
        k = this.d;
        Arrays.fill(arrayOfajz, k + 1, k + 1 + paramInt, null);
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
    
    final void a(List<ajz> paramList)
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
        ajz localajz = (ajz)paramList.get(n);
        alc localalc1 = localajz.g.f();
        alc localalc2 = localajz.h;
        Object localObject = (Integer)aka.b.get(localalc1);
        int m;
        if (localObject != null)
        {
          m = ((Integer)localObject).intValue() + 1;
          if ((m > 1) && (m < 8))
          {
            if (aix.a(aka.a[(m - 1)].h, localalc2))
            {
              k = m;
              break label198;
            }
            if (aix.a(aka.a[m].h, localalc2))
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
            if (aix.a(this.c[i1].g, localalc1))
            {
              if (aix.a(this.c[i1].h, localalc2))
              {
                m = this.d;
                i2 = aka.a.length + (i1 - m);
                i3 = k;
                break;
              }
              i2 = k;
              if (k == -1) {
                i2 = i1 - this.d + aka.a.length;
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
          a(localalc1);
          a(localalc2);
          a(localajz);
        }
        else
        {
          localObject = ajz.a;
          if ((localalc1.a(0, (alc)localObject, 0, ((alc)localObject).g())) && (!ajz.f.equals(localalc1)))
          {
            a(i3, 15, 0);
            a(localalc2);
          }
          else
          {
            a(i3, 63, 64);
            a(localalc2);
            a(localajz);
          }
        }
        n += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aka
 * JD-Core Version:    0.7.0.1
 */