package okhttp3.internal.http2;

import com.tencent.token.gn;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.f;

final class d
{
  int a;
  int b;
  a[] c = new a[8];
  int d = this.c.length - 1;
  int e = 0;
  int f = 0;
  private final f g;
  private final boolean h;
  private int i = 2147483647;
  private boolean j;
  
  d(int paramInt, boolean paramBoolean, f paramf)
  {
    this.a = paramInt;
    this.b = paramInt;
    this.h = paramBoolean;
    this.g = paramf;
  }
  
  d(f paramf)
  {
    this(4096, true, paramf);
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
  
  void a(List paramList)
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
      if (gn.a(b.a[(m - 1)].h, localByteString2)) {
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
          if (!gn.a(this.c[i1].g, localByteString1)) {
            break label326;
          }
          if (!gn.a(this.c[i1].h, localByteString2)) {
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
        if (!gn.a(b.a[m].h, localByteString2)) {
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
    if ((this.h) && (ae.a().a(paramByteString) < paramByteString.g()))
    {
      f localf = new f();
      ae.a().a(paramByteString, localf);
      paramByteString = localf.n();
      a(paramByteString.g(), 127, 128);
      this.g.a(paramByteString);
      return;
    }
    a(paramByteString.g(), 127, 0);
    this.g.a(paramByteString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.internal.http2.d
 * JD-Core Version:    0.7.0.1
 */