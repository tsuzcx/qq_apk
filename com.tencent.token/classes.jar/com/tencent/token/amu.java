package com.tencent.token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class amu
{
  static final amt[] a;
  static final Map<anw, Integer> b;
  
  static
  {
    Object localObject = new amt(amt.f, "");
    int i = 0;
    a = new amt[] { localObject, new amt(amt.c, "GET"), new amt(amt.c, "POST"), new amt(amt.d, "/"), new amt(amt.d, "/index.html"), new amt(amt.e, "http"), new amt(amt.e, "https"), new amt(amt.b, "200"), new amt(amt.b, "204"), new amt(amt.b, "206"), new amt(amt.b, "304"), new amt(amt.b, "400"), new amt(amt.b, "404"), new amt(amt.b, "500"), new amt("accept-charset", ""), new amt("accept-encoding", "gzip, deflate"), new amt("accept-language", ""), new amt("accept-ranges", ""), new amt("accept", ""), new amt("access-control-allow-origin", ""), new amt("age", ""), new amt("allow", ""), new amt("authorization", ""), new amt("cache-control", ""), new amt("content-disposition", ""), new amt("content-encoding", ""), new amt("content-language", ""), new amt("content-length", ""), new amt("content-location", ""), new amt("content-range", ""), new amt("content-type", ""), new amt("cookie", ""), new amt("date", ""), new amt("etag", ""), new amt("expect", ""), new amt("expires", ""), new amt("from", ""), new amt("host", ""), new amt("if-match", ""), new amt("if-modified-since", ""), new amt("if-none-match", ""), new amt("if-range", ""), new amt("if-unmodified-since", ""), new amt("last-modified", ""), new amt("link", ""), new amt("location", ""), new amt("max-forwards", ""), new amt("proxy-authenticate", ""), new amt("proxy-authorization", ""), new amt("range", ""), new amt("referer", ""), new amt("refresh", ""), new amt("retry-after", ""), new amt("server", ""), new amt("set-cookie", ""), new amt("strict-transport-security", ""), new amt("transfer-encoding", ""), new amt("user-agent", ""), new amt("vary", ""), new amt("via", ""), new amt("www-authenticate", "") };
    localObject = new LinkedHashMap(a.length);
    for (;;)
    {
      amt[] arrayOfamt = a;
      if (i >= arrayOfamt.length) {
        break;
      }
      if (!((Map)localObject).containsKey(arrayOfamt[i].g)) {
        ((Map)localObject).put(a[i].g, Integer.valueOf(i));
      }
      i += 1;
    }
    b = Collections.unmodifiableMap((Map)localObject);
  }
  
  static anw a(anw paramanw)
  {
    int j = paramanw.g();
    int i = 0;
    while (i < j)
    {
      int k = paramanw.a(i);
      if ((k >= 65) && (k <= 90))
      {
        StringBuilder localStringBuilder = new StringBuilder("PROTOCOL_ERROR response malformed: mixed case name: ");
        localStringBuilder.append(paramanw.a());
        throw new IOException(localStringBuilder.toString());
      }
      i += 1;
    }
    return paramanw;
  }
  
  static final class a
  {
    amt[] a = new amt[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<amt> e = new ArrayList();
    private final anv f;
    private final int g = 4096;
    private int h = 4096;
    
    a(aoj paramaoj)
    {
      this(paramaoj, (byte)0);
    }
    
    private a(aoj paramaoj, byte paramByte)
    {
      this.f = aoc.a(paramaoj);
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
        amt[] arrayOfamt = this.a;
        i = this.b;
        System.arraycopy(arrayOfamt, i + 1, arrayOfamt, i + 1 + paramInt, this.c);
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
    
    private void a(amt paramamt)
    {
      this.e.add(paramamt);
      int i = paramamt.i;
      int j = this.h;
      if (i > j)
      {
        d();
        return;
      }
      a(this.d + i - j);
      j = this.c;
      amt[] arrayOfamt1 = this.a;
      if (j + 1 > arrayOfamt1.length)
      {
        amt[] arrayOfamt2 = new amt[arrayOfamt1.length * 2];
        System.arraycopy(arrayOfamt1, 0, arrayOfamt2, arrayOfamt1.length, arrayOfamt1.length);
        this.b = (this.a.length - 1);
        this.a = arrayOfamt2;
      }
      j = this.b;
      this.b = (j - 1);
      this.a[j] = paramamt;
      this.c += 1;
      this.d += i;
    }
    
    private int b(int paramInt)
    {
      return this.b + 1 + paramInt;
    }
    
    private anw c(int paramInt)
    {
      if (d(paramInt)) {
        return amu.a[paramInt].g;
      }
      int i = b(paramInt - amu.a.length);
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
      return (paramInt >= 0) && (paramInt <= amu.a.length - 1);
    }
    
    private int e()
    {
      return this.f.f() & 0xFF;
    }
    
    private anw f()
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
        return anw.a(anb.a().a(this.f.f(j)));
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
              localObject = amu.a[i];
              this.e.add(localObject);
            }
            else
            {
              int j = b(i - amu.a.length);
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
            a(new amt(amu.a(f()), f()));
          }
          else if ((i & 0x40) == 64)
          {
            a(new amt(c(a(i, 63) - 1), f()));
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
            anw localanw;
            if ((i != 16) && (i != 0))
            {
              localObject = c(a(i, 15) - 1);
              localanw = f();
              this.e.add(new amt((anw)localObject, localanw));
            }
            else
            {
              localObject = amu.a(f());
              localanw = f();
              this.e.add(new amt((anw)localObject, localanw));
            }
          }
        }
        else
        {
          throw new IOException("index == 0");
        }
      }
    }
    
    public final List<amt> b()
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
    amt[] c = new amt[8];
    int d = this.c.length - 1;
    int e = 0;
    int f = 0;
    private final ant g;
    private final boolean h = true;
    private int i = 2147483647;
    private boolean j;
    
    b(ant paramant)
    {
      this(paramant, (byte)0);
    }
    
    private b(ant paramant, byte paramByte)
    {
      this.g = paramant;
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
    
    private void a(amt paramamt)
    {
      int k = paramamt.i;
      int m = this.b;
      if (k > m)
      {
        a();
        return;
      }
      b(this.f + k - m);
      m = this.e;
      amt[] arrayOfamt1 = this.c;
      if (m + 1 > arrayOfamt1.length)
      {
        amt[] arrayOfamt2 = new amt[arrayOfamt1.length * 2];
        System.arraycopy(arrayOfamt1, 0, arrayOfamt2, arrayOfamt1.length, arrayOfamt1.length);
        this.d = (this.c.length - 1);
        this.c = arrayOfamt2;
      }
      m = this.d;
      this.d = (m - 1);
      this.c[m] = paramamt;
      this.e += 1;
      this.f += k;
    }
    
    private void a(anw paramanw)
    {
      if (this.h)
      {
        anb.a();
        if (anb.a(paramanw) < paramanw.g())
        {
          ant localant = new ant();
          anb.a();
          anb.a(paramanw, localant);
          paramanw = localant.l();
          a(paramanw.g(), 127, 128);
          this.g.a(paramanw);
          return;
        }
      }
      a(paramanw.g(), 127, 0);
      this.g.a(paramanw);
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
        amt[] arrayOfamt = this.c;
        k = this.d;
        System.arraycopy(arrayOfamt, k + 1, arrayOfamt, k + 1 + paramInt, this.e);
        arrayOfamt = this.c;
        k = this.d;
        Arrays.fill(arrayOfamt, k + 1, k + 1 + paramInt, null);
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
    
    final void a(List<amt> paramList)
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
        amt localamt = (amt)paramList.get(n);
        anw localanw1 = localamt.g.f();
        anw localanw2 = localamt.h;
        Object localObject = (Integer)amu.b.get(localanw1);
        int m;
        if (localObject != null)
        {
          m = ((Integer)localObject).intValue() + 1;
          if ((m > 1) && (m < 8))
          {
            if (alr.a(amu.a[(m - 1)].h, localanw2))
            {
              k = m;
              break label198;
            }
            if (alr.a(amu.a[m].h, localanw2))
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
            if (alr.a(this.c[i1].g, localanw1))
            {
              if (alr.a(this.c[i1].h, localanw2))
              {
                m = this.d;
                i2 = amu.a.length + (i1 - m);
                i3 = k;
                break;
              }
              i2 = k;
              if (k == -1) {
                i2 = i1 - this.d + amu.a.length;
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
          a(localanw1);
          a(localanw2);
          a(localamt);
        }
        else
        {
          localObject = amt.a;
          if ((localanw1.a(0, (anw)localObject, 0, ((anw)localObject).g())) && (!amt.f.equals(localanw1)))
          {
            a(i3, 15, 0);
            a(localanw2);
          }
          else
          {
            a(i3, 63, 64);
            a(localanw2);
            a(localamt);
          }
        }
        n += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amu
 * JD-Core Version:    0.7.0.1
 */