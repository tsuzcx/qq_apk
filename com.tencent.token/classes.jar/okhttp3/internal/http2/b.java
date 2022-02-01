package okhttp3.internal.http2;

import com.tencent.token.fc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.c;
import okio.e;
import okio.k;
import okio.q;

final class b
{
  static final a[] a = { new a(a.f, ""), new a(a.c, "GET"), new a(a.c, "POST"), new a(a.d, "/"), new a(a.d, "/index.html"), new a(a.e, "http"), new a(a.e, "https"), new a(a.b, "200"), new a(a.b, "204"), new a(a.b, "206"), new a(a.b, "304"), new a(a.b, "400"), new a(a.b, "404"), new a(a.b, "500"), new a("accept-charset", ""), new a("accept-encoding", "gzip, deflate"), new a("accept-language", ""), new a("accept-ranges", ""), new a("accept", ""), new a("access-control-allow-origin", ""), new a("age", ""), new a("allow", ""), new a("authorization", ""), new a("cache-control", ""), new a("content-disposition", ""), new a("content-encoding", ""), new a("content-language", ""), new a("content-length", ""), new a("content-location", ""), new a("content-range", ""), new a("content-type", ""), new a("cookie", ""), new a("date", ""), new a("etag", ""), new a("expect", ""), new a("expires", ""), new a("from", ""), new a("host", ""), new a("if-match", ""), new a("if-modified-since", ""), new a("if-none-match", ""), new a("if-range", ""), new a("if-unmodified-since", ""), new a("last-modified", ""), new a("link", ""), new a("location", ""), new a("max-forwards", ""), new a("proxy-authenticate", ""), new a("proxy-authorization", ""), new a("range", ""), new a("referer", ""), new a("refresh", ""), new a("retry-after", ""), new a("server", ""), new a("set-cookie", ""), new a("strict-transport-security", ""), new a("transfer-encoding", ""), new a("user-agent", ""), new a("vary", ""), new a("via", ""), new a("www-authenticate", "") };
  static final Map<ByteString, Integer> b = a();
  
  private static Map<ByteString, Integer> a()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(a.length);
    int i = 0;
    while (i < a.length)
    {
      if (!localLinkedHashMap.containsKey(a[i].g)) {
        localLinkedHashMap.put(a[i].g, Integer.valueOf(i));
      }
      i += 1;
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  static ByteString a(ByteString paramByteString)
  {
    int i = 0;
    int j = paramByteString.g();
    while (i < j)
    {
      int k = paramByteString.a(i);
      if ((k >= 65) && (k <= 90)) {
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramByteString.a());
      }
      i += 1;
    }
    return paramByteString;
  }
  
  static final class a
  {
    a[] a = new a[8];
    int b = this.a.length - 1;
    int c = 0;
    int d = 0;
    private final List<a> e = new ArrayList();
    private final e f;
    private final int g;
    private int h;
    
    a(int paramInt1, int paramInt2, q paramq)
    {
      this.g = paramInt1;
      this.h = paramInt2;
      this.f = k.a(paramq);
    }
    
    a(int paramInt, q paramq)
    {
      this(paramInt, paramInt, paramq);
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
        System.arraycopy(this.a, this.b + 1, this.a, this.b + 1 + paramInt, this.c);
        this.b += paramInt;
        i = paramInt;
      }
      return i;
    }
    
    private void a(int paramInt, a parama)
    {
      this.e.add(parama);
      int j = parama.i;
      int i = j;
      if (paramInt != -1) {
        i = j - this.a[c(paramInt)].i;
      }
      if (i > this.h)
      {
        e();
        return;
      }
      j = a(this.d + i - this.h);
      if (paramInt == -1)
      {
        if (this.c + 1 > this.a.length)
        {
          a[] arrayOfa = new a[this.a.length * 2];
          System.arraycopy(this.a, 0, arrayOfa, this.a.length, this.a.length);
          this.b = (this.a.length - 1);
          this.a = arrayOfa;
        }
        paramInt = this.b;
        this.b = (paramInt - 1);
        this.a[paramInt] = parama;
        this.c += 1;
      }
      for (;;)
      {
        this.d = (i + this.d);
        return;
        int k = c(paramInt);
        this.a[(j + k + paramInt)] = parama;
      }
    }
    
    private void b(int paramInt)
    {
      if (g(paramInt))
      {
        a locala = b.a[paramInt];
        this.e.add(locala);
        return;
      }
      int i = c(paramInt - b.a.length);
      if ((i < 0) || (i >= this.a.length)) {
        throw new IOException("Header index too large " + (paramInt + 1));
      }
      this.e.add(this.a[i]);
    }
    
    private int c(int paramInt)
    {
      return this.b + 1 + paramInt;
    }
    
    private void d()
    {
      if (this.h < this.d)
      {
        if (this.h == 0) {
          e();
        }
      }
      else {
        return;
      }
      a(this.d - this.h);
    }
    
    private void d(int paramInt)
    {
      ByteString localByteString1 = f(paramInt);
      ByteString localByteString2 = c();
      this.e.add(new a(localByteString1, localByteString2));
    }
    
    private void e()
    {
      Arrays.fill(this.a, null);
      this.b = (this.a.length - 1);
      this.c = 0;
      this.d = 0;
    }
    
    private void e(int paramInt)
    {
      a(-1, new a(f(paramInt), c()));
    }
    
    private ByteString f(int paramInt)
    {
      if (g(paramInt)) {
        return b.a[paramInt].g;
      }
      int i = c(paramInt - b.a.length);
      if ((i < 0) || (i >= this.a.length)) {
        throw new IOException("Header index too large " + (paramInt + 1));
      }
      return this.a[i].g;
    }
    
    private void f()
    {
      ByteString localByteString1 = b.a(c());
      ByteString localByteString2 = c();
      this.e.add(new a(localByteString1, localByteString2));
    }
    
    private void g()
    {
      a(-1, new a(b.a(c()), c()));
    }
    
    private boolean g(int paramInt)
    {
      return (paramInt >= 0) && (paramInt <= b.a.length - 1);
    }
    
    private int h()
    {
      return this.f.h() & 0xFF;
    }
    
    int a(int paramInt1, int paramInt2)
    {
      paramInt1 &= paramInt2;
      if (paramInt1 < paramInt2) {
        return paramInt1;
      }
      paramInt1 = 0;
      int i;
      for (;;)
      {
        i = h();
        if ((i & 0x80) == 0) {
          break;
        }
        paramInt2 += ((i & 0x7F) << paramInt1);
        paramInt1 += 7;
      }
      return (i << paramInt1) + paramInt2;
    }
    
    void a()
    {
      while (!this.f.e())
      {
        int i = this.f.h() & 0xFF;
        if (i == 128) {
          throw new IOException("index == 0");
        }
        if ((i & 0x80) == 128)
        {
          b(a(i, 127) - 1);
        }
        else if (i == 64)
        {
          g();
        }
        else if ((i & 0x40) == 64)
        {
          e(a(i, 63) - 1);
        }
        else if ((i & 0x20) == 32)
        {
          this.h = a(i, 31);
          if ((this.h < 0) || (this.h > this.g)) {
            throw new IOException("Invalid dynamic table size update " + this.h);
          }
          d();
        }
        else if ((i == 16) || (i == 0))
        {
          f();
        }
        else
        {
          d(a(i, 15) - 1);
        }
      }
    }
    
    public List<a> b()
    {
      ArrayList localArrayList = new ArrayList(this.e);
      this.e.clear();
      return localArrayList;
    }
    
    ByteString c()
    {
      int j = h();
      if ((j & 0x80) == 128) {}
      for (int i = 1;; i = 0)
      {
        j = a(j, 127);
        if (i == 0) {
          break;
        }
        return ByteString.a(i.a().a(this.f.g(j)));
      }
      return this.f.c(j);
    }
  }
  
  static final class b
  {
    int a;
    int b;
    a[] c = new a[8];
    int d = this.c.length - 1;
    int e = 0;
    int f = 0;
    private final c g;
    private final boolean h;
    private int i = 2147483647;
    private boolean j;
    
    b(int paramInt, boolean paramBoolean, c paramc)
    {
      this.a = paramInt;
      this.b = paramInt;
      this.h = paramBoolean;
      this.g = paramc;
    }
    
    b(c paramc)
    {
      this(4096, true, paramc);
    }
    
    private void a()
    {
      Arrays.fill(this.c, null);
      this.d = (this.c.length - 1);
      this.e = 0;
      this.f = 0;
    }
    
    private void a(a parama)
    {
      int k = parama.i;
      if (k > this.b)
      {
        a();
        return;
      }
      b(this.f + k - this.b);
      if (this.e + 1 > this.c.length)
      {
        a[] arrayOfa = new a[this.c.length * 2];
        System.arraycopy(this.c, 0, arrayOfa, this.c.length, this.c.length);
        this.d = (this.c.length - 1);
        this.c = arrayOfa;
      }
      int m = this.d;
      this.d = (m - 1);
      this.c[m] = parama;
      this.e += 1;
      this.f = (k + this.f);
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
        System.arraycopy(this.c, this.d + 1, this.c, this.d + 1 + paramInt, this.e);
        Arrays.fill(this.c, this.d + 1, this.d + 1 + paramInt, null);
        this.d += paramInt;
        k = paramInt;
      }
      return k;
    }
    
    private void b()
    {
      if (this.b < this.f)
      {
        if (this.b == 0) {
          a();
        }
      }
      else {
        return;
      }
      b(this.f - this.b);
    }
    
    void a(int paramInt)
    {
      this.a = paramInt;
      paramInt = Math.min(paramInt, 16384);
      if (this.b == paramInt) {
        return;
      }
      if (paramInt < this.b) {
        this.i = Math.min(this.i, paramInt);
      }
      this.j = true;
      this.b = paramInt;
      b();
    }
    
    void a(int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 < paramInt2)
      {
        this.g.b(paramInt3 | paramInt1);
        return;
      }
      this.g.b(paramInt3 | paramInt2);
      paramInt1 -= paramInt2;
      while (paramInt1 >= 128)
      {
        this.g.b(paramInt1 & 0x7F | 0x80);
        paramInt1 >>>= 7;
      }
      this.g.b(paramInt1);
    }
    
    void a(List<a> paramList)
    {
      if (this.j)
      {
        if (this.i < this.b) {
          a(this.i, 31, 32);
        }
        this.j = false;
        this.i = 2147483647;
        a(this.b, 31, 32);
      }
      int i4 = paramList.size();
      int n = 0;
      a locala;
      ByteString localByteString1;
      ByteString localByteString2;
      int m;
      int k;
      if (n < i4)
      {
        locala = (a)paramList.get(n);
        localByteString1 = locala.g.f();
        localByteString2 = locala.h;
        Integer localInteger = (Integer)b.b.get(localByteString1);
        if (localInteger == null) {
          break label446;
        }
        m = localInteger.intValue() + 1;
        if ((m <= 1) || (m >= 8)) {
          break label441;
        }
        if (fc.a(b.a[(m - 1)].h, localByteString2)) {
          k = m;
        }
      }
      for (;;)
      {
        label160:
        int i2 = m;
        int i3 = k;
        int i1;
        if (k == -1)
        {
          i1 = this.d + 1;
          int i5 = this.c.length;
          label186:
          i2 = m;
          i3 = k;
          if (i1 < i5)
          {
            i2 = m;
            if (!fc.a(this.c[i1].g, localByteString1)) {
              break label326;
            }
            if (!fc.a(this.c[i1].h, localByteString2)) {
              break label304;
            }
            i3 = i1 - this.d + b.a.length;
            i2 = m;
          }
        }
        if (i3 != -1) {
          a(i3, 127, 128);
        }
        for (;;)
        {
          n += 1;
          break;
          if (!fc.a(b.a[m].h, localByteString2)) {
            break label441;
          }
          k = m + 1;
          break label160;
          label304:
          i2 = m;
          if (m == -1) {
            i2 = i1 - this.d + b.a.length;
          }
          label326:
          i1 += 1;
          m = i2;
          break label186;
          if (i2 == -1)
          {
            this.g.b(64);
            a(localByteString1);
            a(localByteString2);
            a(locala);
          }
          else if ((localByteString1.a(a.a)) && (!a.f.equals(localByteString1)))
          {
            a(i2, 15, 0);
            a(localByteString2);
          }
          else
          {
            a(i2, 63, 64);
            a(localByteString2);
            a(locala);
          }
        }
        return;
        label441:
        k = -1;
        continue;
        label446:
        m = -1;
        k = -1;
      }
    }
    
    void a(ByteString paramByteString)
    {
      if ((this.h) && (i.a().a(paramByteString) < paramByteString.g()))
      {
        c localc = new c();
        i.a().a(paramByteString, localc);
        paramByteString = localc.n();
        a(paramByteString.g(), 127, 128);
        this.g.a(paramByteString);
        return;
      }
      a(paramByteString.g(), 127, 0);
      this.g.a(paramByteString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.b
 * JD-Core Version:    0.7.0.1
 */