package okio;

import java.util.Arrays;

final class SegmentedByteString
  extends ByteString
{
  final transient int[] directory;
  final transient byte[][] segments;
  
  SegmentedByteString(f paramf, int paramInt)
  {
    super(null);
    ab.a(paramf.b, 0L, paramInt);
    v localv = paramf.a;
    int i = 0;
    int j = 0;
    while (j < paramInt)
    {
      if (localv.c == localv.b) {
        throw new AssertionError("s.limit == s.pos");
      }
      j += localv.c - localv.b;
      i += 1;
      localv = localv.f;
    }
    this.segments = new byte[i][];
    this.directory = new int[i * 2];
    paramf = paramf.a;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.segments[j] = paramf.a;
      k = paramf.c - paramf.b + i;
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      this.directory[j] = i;
      this.directory[(this.segments.length + j)] = paramf.b;
      paramf.d = true;
      j += 1;
      paramf = paramf.f;
    }
  }
  
  private int b(int paramInt)
  {
    paramInt = Arrays.binarySearch(this.directory, 0, this.segments.length, paramInt + 1);
    if (paramInt >= 0) {
      return paramInt;
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  private ByteString i()
  {
    return new ByteString(h());
  }
  
  public byte a(int paramInt)
  {
    ab.a(this.directory[(this.segments.length - 1)], paramInt, 1L);
    int j = b(paramInt);
    if (j == 0) {}
    for (int i = 0;; i = this.directory[(j - 1)])
    {
      int k = this.directory[(this.segments.length + j)];
      return this.segments[j][(paramInt - i + k)];
    }
  }
  
  public String a()
  {
    return i().a();
  }
  
  public ByteString a(int paramInt1, int paramInt2)
  {
    return i().a(paramInt1, paramInt2);
  }
  
  void a(f paramf)
  {
    int m = this.segments.length;
    int j = 0;
    int i = 0;
    if (j < m)
    {
      int n = this.directory[(m + j)];
      int k = this.directory[j];
      v localv = new v(this.segments[j], n, n + k - i, true, false);
      if (paramf.a == null)
      {
        localv.g = localv;
        localv.f = localv;
        paramf.a = localv;
      }
      for (;;)
      {
        j += 1;
        i = k;
        break;
        paramf.a.g.a(localv);
      }
    }
    paramf.b += i;
  }
  
  public boolean a(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > g() - paramInt3)) {
      return false;
    }
    int j = b(paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    label30:
    if (paramInt3 > 0)
    {
      if (paramInt1 == 0) {}
      for (j = 0;; j = this.directory[(paramInt1 - 1)])
      {
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int m = this.directory[(this.segments.length + paramInt1)];
        if (!paramByteString.a(paramInt2, this.segments[paramInt1], i - j + m, k)) {
          break;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
        break label30;
      }
    }
    return true;
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt1 > g() - paramInt3) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt3)) {
      return false;
    }
    int j = b(paramInt1);
    int i = paramInt1;
    paramInt1 = j;
    label43:
    if (paramInt3 > 0)
    {
      if (paramInt1 == 0) {}
      for (j = 0;; j = this.directory[(paramInt1 - 1)])
      {
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int m = this.directory[(this.segments.length + paramInt1)];
        if (!ab.a(this.segments[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
          break;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
        break label43;
      }
    }
    return true;
  }
  
  public String b()
  {
    return i().b();
  }
  
  public ByteString c()
  {
    return i().c();
  }
  
  public ByteString d()
  {
    return i().d();
  }
  
  public String e()
  {
    return i().e();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (((paramObject instanceof ByteString)) && (((ByteString)paramObject).g() == g()) && (a(0, (ByteString)paramObject, 0, g()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public ByteString f()
  {
    return i().f();
  }
  
  public int g()
  {
    return this.directory[(this.segments.length - 1)];
  }
  
  public byte[] h()
  {
    int i = 0;
    byte[] arrayOfByte = new byte[this.directory[(this.segments.length - 1)]];
    int m = this.segments.length;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = this.directory[(m + i)];
      k = this.directory[i];
      System.arraycopy(this.segments[i], n, arrayOfByte, j, k - j);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    i = 1;
    int i2 = this.segments.length;
    int j = 0;
    int n;
    for (int k = 0; j < i2; k = n)
    {
      byte[] arrayOfByte = this.segments[j];
      int i1 = this.directory[(i2 + j)];
      n = this.directory[j];
      int m = i1;
      while (m < n - k + i1)
      {
        i = i * 31 + arrayOfByte[m];
        m += 1;
      }
      j += 1;
    }
    this.hashCode = i;
    return i;
  }
  
  public String toString()
  {
    return i().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.SegmentedByteString
 * JD-Core Version:    0.7.0.1
 */