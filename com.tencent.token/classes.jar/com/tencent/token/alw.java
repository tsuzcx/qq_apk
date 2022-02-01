package com.tencent.token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class alw
{
  static final alv[] a;
  static final Map<amy, Integer> b;
  
  static
  {
    Object localObject = new alv(alv.f, "");
    int i = 0;
    a = new alv[] { localObject, new alv(alv.c, "GET"), new alv(alv.c, "POST"), new alv(alv.d, "/"), new alv(alv.d, "/index.html"), new alv(alv.e, "http"), new alv(alv.e, "https"), new alv(alv.b, "200"), new alv(alv.b, "204"), new alv(alv.b, "206"), new alv(alv.b, "304"), new alv(alv.b, "400"), new alv(alv.b, "404"), new alv(alv.b, "500"), new alv("accept-charset", ""), new alv("accept-encoding", "gzip, deflate"), new alv("accept-language", ""), new alv("accept-ranges", ""), new alv("accept", ""), new alv("access-control-allow-origin", ""), new alv("age", ""), new alv("allow", ""), new alv("authorization", ""), new alv("cache-control", ""), new alv("content-disposition", ""), new alv("content-encoding", ""), new alv("content-language", ""), new alv("content-length", ""), new alv("content-location", ""), new alv("content-range", ""), new alv("content-type", ""), new alv("cookie", ""), new alv("date", ""), new alv("etag", ""), new alv("expect", ""), new alv("expires", ""), new alv("from", ""), new alv("host", ""), new alv("if-match", ""), new alv("if-modified-since", ""), new alv("if-none-match", ""), new alv("if-range", ""), new alv("if-unmodified-since", ""), new alv("last-modified", ""), new alv("link", ""), new alv("location", ""), new alv("max-forwards", ""), new alv("proxy-authenticate", ""), new alv("proxy-authorization", ""), new alv("range", ""), new alv("referer", ""), new alv("refresh", ""), new alv("retry-after", ""), new alv("server", ""), new alv("set-cookie", ""), new alv("strict-transport-security", ""), new alv("transfer-encoding", ""), new alv("user-agent", ""), new alv("vary", ""), new alv("via", ""), new alv("www-authenticate", "") };
    localObject = new LinkedHashMap(a.length);
    for (;;)
    {
      alv[] arrayOfalv = a;
      if (i >= arrayOfalv.length) {
        break;
      }
      if (!((Map)localObject).containsKey(arrayOfalv[i].g)) {
        ((Map)localObject).put(a[i].g, Integer.valueOf(i));
      }
      i += 1;
    }
    b = Collections.unmodifiableMap((Map)localObject);
  }
  
  static amy a(amy paramamy)
  {
    int j = paramamy.g();
    int i = 0;
    while (i < j)
    {
      int k = paramamy.a(i);
      if ((k >= 65) && (k <= 90))
      {
        StringBuilder localStringBuilder = new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramamy.a());
        throw new IOException(localStringBuilder.toString());
      }
      i += 1;
    }
    return paramamy;
  }
  
  static final class a
  {
    alv[] a = new alv[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<alv> e = new ArrayList();
    private final amx f;
    private final int g = 4096;
    private int h = 4096;
    
    a(anl paramanl)
    {
      this(paramanl, (byte)0);
    }
    
    private a(anl paramanl, byte paramByte)
    {
      this.f = ane.a(paramanl);
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
        alv[] arrayOfalv = this.a;
        i = this.b;
        System.arraycopy(arrayOfalv, i + 1, arrayOfalv, i + 1 + paramInt, this.c);
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
    
    private void a(alv paramalv)
    {
      this.e.add(paramalv);
      int i = paramalv.i;
      int j = this.h;
      if (i > j)
      {
        d();
        return;
      }
      a(this.d + i - j);
      j = this.c;
      alv[] arrayOfalv1 = this.a;
      if (j + 1 > arrayOfalv1.length)
      {
        alv[] arrayOfalv2 = new alv[arrayOfalv1.length * 2];
        System.arraycopy(arrayOfalv1, 0, arrayOfalv2, arrayOfalv1.length, arrayOfalv1.length);
        this.b = (this.a.length - 1);
        this.a = arrayOfalv2;
      }
      j = this.b;
      this.b = (j - 1);
      this.a[j] = paramalv;
      this.c += 1;
      this.d += i;
    }
    
    private int b(int paramInt)
    {
      return this.b + 1 + paramInt;
    }
    
    private amy c(int paramInt)
    {
      if (d(paramInt)) {
        return alw.a[paramInt].g;
      }
      int i = b(paramInt - alw.a.length);
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
      return (paramInt >= 0) && (paramInt <= alw.a.length - 1);
    }
    
    private int e()
    {
      return this.f.f() & 0xFF;
    }
    
    private amy f()
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
        return amy.a(amd.a().a(this.f.f(j)));
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
              localObject = alw.a[i];
              this.e.add(localObject);
            }
            else
            {
              int j = b(i - alw.a.length);
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
            a(new alv(alw.a(f()), f()));
          }
          else if ((i & 0x40) == 64)
          {
            a(new alv(c(a(i, 63) - 1), f()));
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
            amy localamy;
            if ((i != 16) && (i != 0))
            {
              localObject = c(a(i, 15) - 1);
              localamy = f();
              this.e.add(new alv((amy)localObject, localamy));
            }
            else
            {
              localObject = alw.a(f());
              localamy = f();
              this.e.add(new alv((amy)localObject, localamy));
            }
          }
        }
        else
        {
          throw new IOException("index == 0");
        }
      }
    }
    
    public final List<alv> b()
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
    alv[] c = new alv[8];
    int d = this.c.length - 1;
    int e = 0;
    int f = 0;
    private final amv g;
    private final boolean h = true;
    private int i = 2147483647;
    private boolean j;
    
    b(amv paramamv)
    {
      this(paramamv, (byte)0);
    }
    
    private b(amv paramamv, byte paramByte)
    {
      this.g = paramamv;
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
    
    private void a(alv paramalv)
    {
      int k = paramalv.i;
      int m = this.b;
      if (k > m)
      {
        a();
        return;
      }
      b(this.f + k - m);
      m = this.e;
      alv[] arrayOfalv1 = this.c;
      if (m + 1 > arrayOfalv1.length)
      {
        alv[] arrayOfalv2 = new alv[arrayOfalv1.length * 2];
        System.arraycopy(arrayOfalv1, 0, arrayOfalv2, arrayOfalv1.length, arrayOfalv1.length);
        this.d = (this.c.length - 1);
        this.c = arrayOfalv2;
      }
      m = this.d;
      this.d = (m - 1);
      this.c[m] = paramalv;
      this.e += 1;
      this.f += k;
    }
    
    private void a(amy paramamy)
    {
      if (this.h)
      {
        amd.a();
        if (amd.a(paramamy) < paramamy.g())
        {
          amv localamv = new amv();
          amd.a();
          amd.a(paramamy, localamv);
          paramamy = localamv.l();
          a(paramamy.g(), 127, 128);
          this.g.a(paramamy);
          return;
        }
      }
      a(paramamy.g(), 127, 0);
      this.g.a(paramamy);
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
        alv[] arrayOfalv = this.c;
        k = this.d;
        System.arraycopy(arrayOfalv, k + 1, arrayOfalv, k + 1 + paramInt, this.e);
        arrayOfalv = this.c;
        k = this.d;
        Arrays.fill(arrayOfalv, k + 1, k + 1 + paramInt, null);
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
    
    final void a(List<alv> paramList)
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
        alv localalv = (alv)paramList.get(n);
        amy localamy1 = localalv.g.f();
        amy localamy2 = localalv.h;
        Object localObject = (Integer)alw.b.get(localamy1);
        int m;
        if (localObject != null)
        {
          m = ((Integer)localObject).intValue() + 1;
          if ((m > 1) && (m < 8))
          {
            if (akt.a(alw.a[(m - 1)].h, localamy2))
            {
              k = m;
              break label198;
            }
            if (akt.a(alw.a[m].h, localamy2))
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
            if (akt.a(this.c[i1].g, localamy1))
            {
              if (akt.a(this.c[i1].h, localamy2))
              {
                m = this.d;
                i2 = alw.a.length + (i1 - m);
                i3 = k;
                break;
              }
              i2 = k;
              if (k == -1) {
                i2 = i1 - this.d + alw.a.length;
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
          a(localamy1);
          a(localamy2);
          a(localalv);
        }
        else
        {
          localObject = alv.a;
          if ((localamy1.a(0, (amy)localObject, 0, ((amy)localObject).g())) && (!alv.f.equals(localamy1)))
          {
            a(i3, 15, 0);
            a(localamy2);
          }
          else
          {
            a(i3, 63, 64);
            a(localamy2);
            a(localalv);
          }
        }
        n += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alw
 * JD-Core Version:    0.7.0.1
 */