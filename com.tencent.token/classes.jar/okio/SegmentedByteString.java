package okio;

import java.util.Arrays;

final class SegmentedByteString
  extends ByteString
{
  final transient int[] directory;
  final transient byte[][] segments;
  
  SegmentedByteString(c paramc, int paramInt)
  {
    super(null);
    s.a(paramc.b, 0L, paramInt);
    Object localObject = paramc.a;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt) {
      if (((n)localObject).c != ((n)localObject).b)
      {
        j += ((n)localObject).c - ((n)localObject).b;
        i += 1;
        localObject = ((n)localObject).f;
      }
      else
      {
        throw new AssertionError("s.limit == s.pos");
      }
    }
    this.segments = new byte[i][];
    this.directory = new int[i * 2];
    paramc = paramc.a;
    j = 0;
    i = k;
    while (i < paramInt)
    {
      this.segments[j] = paramc.a;
      k = i + (paramc.c - paramc.b);
      i = k;
      if (k > paramInt) {
        i = paramInt;
      }
      localObject = this.directory;
      localObject[j] = i;
      localObject[(this.segments.length + j)] = paramc.b;
      paramc.d = true;
      j += 1;
      paramc = paramc.f;
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
    s.a(this.directory[(this.segments.length - 1)], paramInt, 1L);
    int j = b(paramInt);
    int i;
    if (j == 0) {
      i = 0;
    } else {
      i = this.directory[(j - 1)];
    }
    int[] arrayOfInt = this.directory;
    byte[][] arrayOfByte = this.segments;
    int k = arrayOfInt[(arrayOfByte.length + j)];
    return arrayOfByte[j][(paramInt - i + k)];
  }
  
  public String a()
  {
    return i().a();
  }
  
  public ByteString a(int paramInt1, int paramInt2)
  {
    return i().a(paramInt1, paramInt2);
  }
  
  void a(c paramc)
  {
    int m = this.segments.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = this.directory;
      int n = localObject[(m + i)];
      k = localObject[i];
      localObject = new n(this.segments[i], n, n + k - j, true, false);
      if (paramc.a == null)
      {
        ((n)localObject).g = ((n)localObject);
        ((n)localObject).f = ((n)localObject);
        paramc.a = ((n)localObject);
      }
      else
      {
        paramc.a.g.a((n)localObject);
      }
      i += 1;
    }
    paramc.b += j;
  }
  
  public boolean a(int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt1 > g() - paramInt3) {
        return false;
      }
      int j = b(paramInt1);
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt3 > 0)
      {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.directory[(paramInt1 - 1)];
        }
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int[] arrayOfInt = this.directory;
        byte[][] arrayOfByte = this.segments;
        int m = arrayOfInt[(arrayOfByte.length + paramInt1)];
        if (!paramByteString.a(paramInt2, arrayOfByte[paramInt1], i - j + m, k)) {
          return false;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= g() - paramInt3) && (paramInt2 >= 0))
    {
      if (paramInt2 > paramArrayOfByte.length - paramInt3) {
        return false;
      }
      int j = b(paramInt1);
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt3 > 0)
      {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.directory[(paramInt1 - 1)];
        }
        int k = Math.min(paramInt3, this.directory[paramInt1] - j + j - i);
        int[] arrayOfInt = this.directory;
        byte[][] arrayOfByte = this.segments;
        int m = arrayOfInt[(arrayOfByte.length + paramInt1)];
        if (!s.a(arrayOfByte[paramInt1], i - j + m, paramArrayOfByte, paramInt2, k)) {
          return false;
        }
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
        paramInt1 += 1;
      }
      return true;
    }
    return false;
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
    if ((paramObject instanceof ByteString))
    {
      paramObject = (ByteString)paramObject;
      if ((paramObject.g() == g()) && (a(0, paramObject, 0, g()))) {
        return true;
      }
    }
    return false;
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
    Object localObject2 = this.directory;
    Object localObject1 = this.segments;
    localObject2 = new byte[localObject2[(localObject1.length - 1)]];
    int m = localObject1.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      localObject1 = this.directory;
      int n = localObject1[(m + i)];
      k = localObject1[i];
      System.arraycopy(this.segments[i], n, localObject2, j, k - j);
      i += 1;
    }
    return localObject2;
  }
  
  public int hashCode()
  {
    int i = this.hashCode;
    if (i != 0) {
      return i;
    }
    int i2 = this.segments.length;
    int k = 0;
    int m = 1;
    int n;
    for (int j = 0; k < i2; j = n)
    {
      byte[] arrayOfByte = this.segments[k];
      int[] arrayOfInt = this.directory;
      int i1 = arrayOfInt[(i2 + k)];
      n = arrayOfInt[k];
      i = i1;
      while (i < n - j + i1)
      {
        m = m * 31 + arrayOfByte[i];
        i += 1;
      }
      k += 1;
    }
    this.hashCode = m;
    return m;
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