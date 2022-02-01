package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class c
  implements Cloneable, ByteChannel, d, e
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  @Nullable
  n a;
  long b;
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    s.a(paramArrayOfByte.length, paramInt1, paramInt2);
    n localn = this.a;
    if (localn == null) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, localn.c - localn.b);
      System.arraycopy(localn.a, localn.b, paramArrayOfByte, paramInt1, paramInt2);
      localn.b += paramInt2;
      this.b -= paramInt2;
      paramInt1 = paramInt2;
    } while (localn.b != localn.c);
    this.a = localn.b();
    o.a(localn);
    return paramInt2;
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L, 9223372036854775807L);
  }
  
  public long a(byte paramByte, long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < paramLong1)) {
      throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.b), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    long l2 = paramLong2;
    if (paramLong2 > this.b) {
      l2 = this.b;
    }
    if (paramLong1 == l2) {
      return -1L;
    }
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return -1L;
    }
    if (this.b - paramLong1 < paramLong1)
    {
      l1 = this.b;
      localObject2 = localObject1;
      for (;;)
      {
        paramLong2 = l1;
        localObject1 = localObject2;
        if (l1 <= paramLong1) {
          break;
        }
        localObject2 = ((n)localObject2).g;
        l1 -= ((n)localObject2).c - ((n)localObject2).b;
      }
    }
    paramLong2 = 0L;
    Object localObject2 = localObject1;
    for (;;)
    {
      l1 = ((n)localObject2).c - ((n)localObject2).b + paramLong2;
      localObject1 = localObject2;
      if (l1 >= paramLong1) {
        break;
      }
      localObject2 = ((n)localObject2).f;
      paramLong2 = l1;
    }
    paramLong2 = ((n)localObject1).c - ((n)localObject1).b + paramLong2;
    localObject1 = ((n)localObject1).f;
    paramLong1 = paramLong2;
    long l1 = paramLong2;
    paramLong2 = paramLong1;
    for (;;)
    {
      if (paramLong2 < l2)
      {
        localObject2 = ((n)localObject1).a;
        int j = (int)Math.min(((n)localObject1).c, ((n)localObject1).b + l2 - paramLong2);
        int i = (int)(((n)localObject1).b + l1 - paramLong2);
        while (i < j)
        {
          if (localObject2[i] == paramByte) {
            return i - ((n)localObject1).b + paramLong2;
          }
          i += 1;
        }
        break;
      }
      return -1L;
      l1 = paramLong1;
    }
  }
  
  public long a(c paramc, long paramLong)
  {
    if (paramc == null) {
      throw new IllegalArgumentException("sink == null");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.b == 0L) {
      return -1L;
    }
    long l = paramLong;
    if (paramLong > this.b) {
      l = this.b;
    }
    paramc.a_(this, l);
    return l;
  }
  
  public long a(q paramq)
  {
    if (paramq == null) {
      throw new IllegalArgumentException("source == null");
    }
    long l2;
    for (long l1 = 0L;; l1 += l2)
    {
      l2 = paramq.a(this, 8192L);
      if (l2 == -1L) {
        break;
      }
    }
    return l1;
  }
  
  public String a(long paramLong, Charset paramCharset)
  {
    s.a(this.b, 0L, paramLong);
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    if (paramLong == 0L) {
      paramCharset = "";
    }
    n localn;
    String str;
    do
    {
      return paramCharset;
      localn = this.a;
      if (localn.b + paramLong > localn.c) {
        return new String(g(paramLong), paramCharset);
      }
      str = new String(localn.a, localn.b, (int)paramLong, paramCharset);
      localn.b = ((int)(localn.b + paramLong));
      this.b -= paramLong;
      paramCharset = str;
    } while (localn.b != localn.c);
    this.a = localn.b();
    o.a(localn);
    return str;
  }
  
  public c a(int paramInt)
  {
    if (paramInt < 128)
    {
      b(paramInt);
      return this;
    }
    if (paramInt < 2048)
    {
      b(paramInt >> 6 | 0xC0);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt < 65536)
    {
      if ((paramInt >= 55296) && (paramInt <= 57343))
      {
        b(63);
        return this;
      }
      b(paramInt >> 12 | 0xE0);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    if (paramInt <= 1114111)
    {
      b(paramInt >> 18 | 0xF0);
      b(paramInt >> 12 & 0x3F | 0x80);
      b(paramInt >> 6 & 0x3F | 0x80);
      b(paramInt & 0x3F | 0x80);
      return this;
    }
    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(paramInt));
  }
  
  public c a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public c a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    int i;
    label136:
    int j;
    label168:
    byte[] arrayOfByte;
    int k;
    if (paramInt2 > paramString.length())
    {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
      i = 0;
      if ((j > 56319) || (i < 56320) || (i > 57343))
      {
        b(63);
        paramInt1 += 1;
      }
    }
    else
    {
      if (paramInt1 >= paramInt2) {
        return this;
      }
      j = paramString.charAt(paramInt1);
      if (j < 128)
      {
        n localn = e(1);
        arrayOfByte = localn.a;
        k = localn.c - paramInt1;
        int m = Math.min(paramInt2, 8192 - k);
        i = paramInt1 + 1;
        arrayOfByte[(k + paramInt1)] = ((byte)j);
        paramInt1 = i;
        label241:
        if (paramInt1 < m)
        {
          i = paramString.charAt(paramInt1);
          if (i < 128) {}
        }
        else
        {
          i = paramInt1 + k - localn.c;
          localn.c += i;
          this.b += i;
        }
      }
    }
    for (;;)
    {
      break label168;
      arrayOfByte[(paramInt1 + k)] = ((byte)i);
      paramInt1 += 1;
      break label241;
      if (j < 2048)
      {
        b(j >> 6 | 0xC0);
        b(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else if ((j < 55296) || (j > 57343))
      {
        b(j >> 12 | 0xE0);
        b(j >> 6 & 0x3F | 0x80);
        b(j & 0x3F | 0x80);
        paramInt1 += 1;
      }
      else
      {
        if (paramInt1 + 1 >= paramInt2) {
          break;
        }
        i = paramString.charAt(paramInt1 + 1);
        break label136;
        i = (i & 0xFFFF23FF | (j & 0xFFFF27FF) << 10) + 65536;
        b(i >> 18 | 0xF0);
        b(i >> 12 & 0x3F | 0x80);
        b(i >> 6 & 0x3F | 0x80);
        b(i & 0x3F | 0x80);
        paramInt1 += 2;
      }
    }
    return this;
  }
  
  public c a(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string == null");
    }
    if (paramInt1 < 0) {
      throw new IllegalAccessError("beginIndex < 0: " + paramInt1);
    }
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex < beginIndex: " + paramInt2 + " < " + paramInt1);
    }
    if (paramInt2 > paramString.length()) {
      throw new IllegalArgumentException("endIndex > string.length: " + paramInt2 + " > " + paramString.length());
    }
    if (paramCharset == null) {
      throw new IllegalArgumentException("charset == null");
    }
    if (paramCharset.equals(s.a)) {
      return a(paramString, paramInt1, paramInt2);
    }
    paramString = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
    return b(paramString, 0, paramString.length);
  }
  
  public c a(ByteString paramByteString)
  {
    if (paramByteString == null) {
      throw new IllegalArgumentException("byteString == null");
    }
    paramByteString.a(this);
    return this;
  }
  
  public c a(c paramc, long paramLong1, long paramLong2)
  {
    if (paramc == null) {
      throw new IllegalArgumentException("out == null");
    }
    s.a(this.b, paramLong1, paramLong2);
    if (paramLong2 == 0L) {
      return this;
    }
    paramc.b += paramLong2;
    n localn2;
    long l1;
    long l2;
    for (n localn1 = this.a;; localn1 = localn1.f)
    {
      localn2 = localn1;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < localn1.c - localn1.b) {
        break;
      }
      paramLong1 -= localn1.c - localn1.b;
    }
    label103:
    if (l2 > 0L)
    {
      localn1 = localn2.a();
      localn1.b = ((int)(localn1.b + l1));
      localn1.c = Math.min(localn1.b + (int)l2, localn1.c);
      if (paramc.a != null) {
        break label211;
      }
      localn1.g = localn1;
      localn1.f = localn1;
      paramc.a = localn1;
    }
    for (;;)
    {
      l2 -= localn1.c - localn1.b;
      localn2 = localn2.f;
      l1 = 0L;
      break label103;
      break;
      label211:
      paramc.a.g.a(localn1);
    }
  }
  
  public r a()
  {
    return r.c;
  }
  
  public void a(long paramLong)
  {
    if (this.b < paramLong) {
      throw new EOFException();
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = a(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j == -1) {
        throw new EOFException();
      }
      i += j;
    }
  }
  
  public void a_(c paramc, long paramLong)
  {
    if (paramc == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramc == this) {
      throw new IllegalArgumentException("source == this");
    }
    s.a(paramc.b, 0L, paramLong);
    if (paramLong > 0L)
    {
      if (paramLong >= paramc.a.c - paramc.a.b) {
        break label190;
      }
      if (this.a == null) {
        break label161;
      }
      localn1 = this.a.g;
      if ((localn1 == null) || (!localn1.e)) {
        break label177;
      }
      l = localn1.c;
      if (!localn1.d) {
        break label167;
      }
    }
    label161:
    label167:
    for (int i = 0;; i = localn1.b)
    {
      if (l + paramLong - i > 8192L) {
        break label177;
      }
      paramc.a.a(localn1, (int)paramLong);
      paramc.b -= paramLong;
      this.b += paramLong;
      return;
      localn1 = null;
      break;
    }
    label177:
    paramc.a = paramc.a.a((int)paramLong);
    label190:
    n localn1 = paramc.a;
    long l = localn1.c - localn1.b;
    paramc.a = localn1.b();
    if (this.a == null)
    {
      this.a = localn1;
      localn1 = this.a;
      n localn2 = this.a;
      n localn3 = this.a;
      localn2.g = localn3;
      localn1.f = localn3;
    }
    for (;;)
    {
      paramc.b -= l;
      this.b += l;
      paramLong -= l;
      break;
      this.a.g.a(localn1).c();
    }
  }
  
  public byte b(long paramLong)
  {
    s.a(this.b, paramLong, 1L);
    if (this.b - paramLong > paramLong) {
      for (localn = this.a;; localn = localn.f)
      {
        int i = localn.c - localn.b;
        if (paramLong < i) {
          return localn.a[(localn.b + (int)paramLong)];
        }
        paramLong -= i;
      }
    }
    paramLong -= this.b;
    for (n localn = this.a.g;; localn = localn.g)
    {
      paramLong += localn.c - localn.b;
      if (paramLong >= 0L) {
        return localn.a[(localn.b + (int)paramLong)];
      }
    }
  }
  
  public long b()
  {
    return this.b;
  }
  
  public c b(int paramInt)
  {
    n localn = e(1);
    byte[] arrayOfByte = localn.a;
    int i = localn.c;
    localn.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b += 1L;
    return this;
  }
  
  public c b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    return b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public c b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("source == null");
    }
    s.a(paramArrayOfByte.length, paramInt1, paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      n localn = e(1);
      int j = Math.min(i - paramInt1, 8192 - localn.c);
      System.arraycopy(paramArrayOfByte, paramInt1, localn.a, localn.c, j);
      paramInt1 += j;
      localn.c = (j + localn.c);
    }
    this.b += paramInt2;
    return this;
  }
  
  public ByteString c(long paramLong)
  {
    return new ByteString(g(paramLong));
  }
  
  public c c()
  {
    return this;
  }
  
  public c c(int paramInt)
  {
    n localn = e(2);
    byte[] arrayOfByte = localn.a;
    int i = localn.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localn.c = (j + 1);
    this.b += 2L;
    return this;
  }
  
  public void close() {}
  
  public String d(long paramLong)
  {
    return a(paramLong, s.a);
  }
  
  public c d()
  {
    return this;
  }
  
  public c d(int paramInt)
  {
    n localn = e(4);
    byte[] arrayOfByte = localn.a;
    int j = localn.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localn.c = (i + 1);
    this.b += 4L;
    return this;
  }
  
  public String e(long paramLong)
  {
    long l1 = 9223372036854775807L;
    if (paramLong < 0L) {
      throw new IllegalArgumentException("limit < 0: " + paramLong);
    }
    if (paramLong == 9223372036854775807L) {}
    for (;;)
    {
      long l2 = a((byte)10, 0L, l1);
      if (l2 == -1L) {
        break;
      }
      return f(l2);
      l1 = paramLong + 1L;
    }
    if ((l1 < b()) && (b(l1 - 1L) == 13) && (b(l1) == 10)) {
      return f(l1);
    }
    c localc = new c();
    a(localc, 0L, Math.min(32L, b()));
    throw new EOFException("\\n not found: limit=" + Math.min(b(), paramLong) + " content=" + localc.n().e() + '…');
  }
  
  n e(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 8192)) {
      throw new IllegalArgumentException();
    }
    n localn2;
    n localn1;
    if (this.a == null)
    {
      this.a = o.a();
      localn2 = this.a;
      n localn3 = this.a;
      localn1 = this.a;
      localn3.g = localn1;
      localn2.f = localn1;
    }
    do
    {
      return localn1;
      localn2 = this.a.g;
      if (localn2.c + paramInt > 8192) {
        break;
      }
      localn1 = localn2;
    } while (localn2.e);
    return localn2.a(o.a());
  }
  
  public boolean e()
  {
    return this.b == 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    long l1 = 0L;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    if (this.b != paramObject.b) {
      return false;
    }
    if (this.b == 0L) {
      return true;
    }
    Object localObject2 = this.a;
    paramObject = paramObject.a;
    int j = ((n)localObject2).b;
    int i = paramObject.b;
    while (l1 < this.b)
    {
      long l2 = Math.min(((n)localObject2).c - j, paramObject.c - i);
      int k = 0;
      while (k < l2)
      {
        if (localObject2.a[j] != paramObject.a[i]) {
          return false;
        }
        k += 1;
        i += 1;
        j += 1;
      }
      k = j;
      Object localObject1 = localObject2;
      if (j == ((n)localObject2).c)
      {
        localObject1 = ((n)localObject2).f;
        k = ((n)localObject1).b;
      }
      j = i;
      localObject2 = paramObject;
      if (i == paramObject.c)
      {
        localObject2 = paramObject.f;
        j = ((n)localObject2).b;
      }
      l1 += l2;
      i = j;
      j = k;
      paramObject = localObject2;
      localObject2 = localObject1;
    }
    return true;
  }
  
  public InputStream f()
  {
    new InputStream()
    {
      public int available()
      {
        return (int)Math.min(c.this.b, 2147483647L);
      }
      
      public void close() {}
      
      public int read()
      {
        if (c.this.b > 0L) {
          return c.this.h() & 0xFF;
        }
        return -1;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return c.this.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public String toString()
      {
        return c.this + ".inputStream()";
      }
    };
  }
  
  String f(long paramLong)
  {
    if ((paramLong > 0L) && (b(paramLong - 1L) == 13))
    {
      str = d(paramLong - 1L);
      h(2L);
      return str;
    }
    String str = d(paramLong);
    h(1L);
    return str;
  }
  
  public ByteString f(int paramInt)
  {
    if (paramInt == 0) {
      return ByteString.EMPTY;
    }
    return new SegmentedByteString(this, paramInt);
  }
  
  public void flush() {}
  
  public long g()
  {
    long l2 = this.b;
    long l1;
    if (l2 == 0L) {
      l1 = 0L;
    }
    n localn;
    do
    {
      do
      {
        return l1;
        localn = this.a.g;
        l1 = l2;
      } while (localn.c >= 8192);
      l1 = l2;
    } while (!localn.e);
    return l2 - (localn.c - localn.b);
  }
  
  public byte[] g(long paramLong)
  {
    s.a(this.b, 0L, paramLong);
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + paramLong);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    a(arrayOfByte);
    return arrayOfByte;
  }
  
  public byte h()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    n localn = this.a;
    int i = localn.b;
    int j = localn.c;
    byte[] arrayOfByte = localn.a;
    int k = i + 1;
    byte b1 = arrayOfByte[i];
    this.b -= 1L;
    if (k == j)
    {
      this.a = localn.b();
      o.a(localn);
      return b1;
    }
    localn.b = k;
    return b1;
  }
  
  public void h(long paramLong)
  {
    while (paramLong > 0L)
    {
      if (this.a == null) {
        throw new EOFException();
      }
      int i = (int)Math.min(paramLong, this.a.c - this.a.b);
      this.b -= i;
      long l = paramLong - i;
      n localn = this.a;
      localn.b = (i + localn.b);
      paramLong = l;
      if (this.a.b == this.a.c)
      {
        localn = this.a;
        this.a = localn.b();
        o.a(localn);
        paramLong = l;
      }
    }
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int j = 1;
    int i;
    n localn;
    do
    {
      int k = ((n)localObject).b;
      int m = ((n)localObject).c;
      for (i = j; k < m; i = j + i * 31)
      {
        j = localObject.a[k];
        k += 1;
      }
      localn = ((n)localObject).f;
      j = i;
      localObject = localn;
    } while (localn != this.a);
    return i;
  }
  
  public c i(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      if (paramLong < 0L) {
        return a("-9223372036854775808");
      }
    }
    for (int j = 1;; j = 0)
    {
      int i;
      if (paramLong < 100000000L) {
        if (paramLong < 10000L) {
          if (paramLong < 100L) {
            if (paramLong < 10L) {
              i = 1;
            }
          }
        }
      }
      int k;
      n localn;
      byte[] arrayOfByte;
      for (;;)
      {
        k = i;
        if (j != 0) {
          k = i + 1;
        }
        localn = e(k);
        arrayOfByte = localn.a;
        i = localn.c + k;
        while (paramLong != 0L)
        {
          int m = (int)(paramLong % 10L);
          i -= 1;
          arrayOfByte[i] = c[m];
          paramLong /= 10L;
        }
        i = 2;
        continue;
        if (paramLong < 1000L)
        {
          i = 3;
        }
        else
        {
          i = 4;
          continue;
          if (paramLong < 1000000L)
          {
            if (paramLong < 100000L) {
              i = 5;
            } else {
              i = 6;
            }
          }
          else if (paramLong < 10000000L)
          {
            i = 7;
          }
          else
          {
            i = 8;
            continue;
            if (paramLong < 1000000000000L)
            {
              if (paramLong < 10000000000L)
              {
                if (paramLong < 1000000000L) {
                  i = 9;
                } else {
                  i = 10;
                }
              }
              else if (paramLong < 100000000000L) {
                i = 11;
              } else {
                i = 12;
              }
            }
            else if (paramLong < 1000000000000000L)
            {
              if (paramLong < 10000000000000L) {
                i = 13;
              } else if (paramLong < 100000000000000L) {
                i = 14;
              } else {
                i = 15;
              }
            }
            else if (paramLong < 100000000000000000L)
            {
              if (paramLong < 10000000000000000L) {
                i = 16;
              } else {
                i = 17;
              }
            }
            else if (paramLong < 1000000000000000000L) {
              i = 18;
            } else {
              i = 19;
            }
          }
        }
      }
      if (j != 0) {
        arrayOfByte[(i - 1)] = 45;
      }
      localn.c += k;
      paramLong = this.b;
      this.b = (k + paramLong);
      return this;
    }
  }
  
  public short i()
  {
    if (this.b < 2L) {
      throw new IllegalStateException("size < 2: " + this.b);
    }
    n localn = this.a;
    int k = localn.b;
    int i = localn.c;
    if (i - k < 2) {
      return (short)((h() & 0xFF) << 8 | h() & 0xFF);
    }
    byte[] arrayOfByte = localn.a;
    int j = k + 1;
    k = arrayOfByte[k];
    int m = j + 1;
    j = arrayOfByte[j];
    this.b -= 2L;
    if (m == i)
    {
      this.a = localn.b();
      o.a(localn);
    }
    for (;;)
    {
      return (short)((k & 0xFF) << 8 | j & 0xFF);
      localn.b = m;
    }
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public int j()
  {
    if (this.b < 4L) {
      throw new IllegalStateException("size < 4: " + this.b);
    }
    n localn = this.a;
    int j = localn.b;
    int i = localn.c;
    if (i - j < 4) {
      return (h() & 0xFF) << 24 | (h() & 0xFF) << 16 | (h() & 0xFF) << 8 | h() & 0xFF;
    }
    byte[] arrayOfByte = localn.a;
    int k = j + 1;
    j = arrayOfByte[j];
    int n = k + 1;
    k = arrayOfByte[k];
    int m = n + 1;
    int i1 = arrayOfByte[n];
    n = m + 1;
    j = (j & 0xFF) << 24 | (k & 0xFF) << 16 | (i1 & 0xFF) << 8 | arrayOfByte[m] & 0xFF;
    this.b -= 4L;
    if (n == i)
    {
      this.a = localn.b();
      o.a(localn);
      return j;
    }
    localn.b = n;
    return j;
  }
  
  public c j(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    n localn = e(j);
    byte[] arrayOfByte = localn.a;
    int i = localn.c + j - 1;
    int k = localn.c;
    while (i >= k)
    {
      arrayOfByte[i] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localn.c += j;
    paramLong = this.b;
    this.b = (j + paramLong);
    return this;
  }
  
  public short k()
  {
    return s.a(i());
  }
  
  public int l()
  {
    return s.a(j());
  }
  
  public long m()
  {
    if (this.b == 0L) {
      throw new IllegalStateException("size == 0");
    }
    long l2 = 0L;
    int i = 0;
    int j = 0;
    Object localObject = this.a;
    byte[] arrayOfByte = ((n)localObject).a;
    int m = ((n)localObject).b;
    int n = ((n)localObject).c;
    long l1 = l2;
    int k = i;
    label60:
    i = j;
    if (m < n)
    {
      int i1 = arrayOfByte[m];
      if ((i1 >= 48) && (i1 <= 57)) {
        i = i1 - 48;
      }
      for (;;)
      {
        if ((0x0 & l1) == 0L) {
          break label302;
        }
        localObject = new c().j(l1).b(i1);
        throw new NumberFormatException("Number too large: " + ((c)localObject).o());
        if ((i1 >= 97) && (i1 <= 102))
        {
          i = i1 - 97 + 10;
        }
        else
        {
          if ((i1 < 65) || (i1 > 70)) {
            break;
          }
          i = i1 - 65 + 10;
        }
      }
      if (k == 0) {
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i1));
      }
      i = 1;
    }
    if (m == n)
    {
      this.a = ((n)localObject).b();
      o.a((n)localObject);
    }
    for (;;)
    {
      if (i == 0)
      {
        j = i;
        i = k;
        l2 = l1;
        if (this.a != null) {
          break;
        }
      }
      this.b -= k;
      return l1;
      label302:
      l2 = i;
      k += 1;
      m += 1;
      l1 = l2 | l1 << 4;
      break label60;
      ((n)localObject).b = m;
    }
  }
  
  public ByteString n()
  {
    return new ByteString(q());
  }
  
  public String o()
  {
    try
    {
      String str = a(this.b, s.a);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public String p()
  {
    return e(9223372036854775807L);
  }
  
  public byte[] q()
  {
    try
    {
      byte[] arrayOfByte = g(this.b);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public void r()
  {
    try
    {
      h(this.b);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public int read(ByteBuffer paramByteBuffer)
  {
    n localn = this.a;
    int i;
    if (localn == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = Math.min(paramByteBuffer.remaining(), localn.c - localn.b);
      paramByteBuffer.put(localn.a, localn.b, j);
      localn.b += j;
      this.b -= j;
      i = j;
    } while (localn.b != localn.c);
    this.a = localn.b();
    o.a(localn);
    return j;
  }
  
  public c s()
  {
    c localc = new c();
    if (this.b == 0L) {
      return localc;
    }
    localc.a = this.a.a();
    n localn1 = localc.a;
    n localn2 = localc.a;
    n localn3 = localc.a;
    localn2.g = localn3;
    localn1.f = localn3;
    for (localn1 = this.a.f; localn1 != this.a; localn1 = localn1.f) {
      localc.a.g.a(localn1.a());
    }
    localc.b = this.b;
    return localc;
  }
  
  public ByteString t()
  {
    if (this.b > 2147483647L) {
      throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }
    return f((int)this.b);
  }
  
  public String toString()
  {
    return t().toString();
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      throw new IllegalArgumentException("source == null");
    }
    int j = paramByteBuffer.remaining();
    int i = j;
    while (i > 0)
    {
      n localn = e(1);
      int k = Math.min(i, 8192 - localn.c);
      paramByteBuffer.get(localn.a, localn.c, k);
      i -= k;
      localn.c = (k + localn.c);
    }
    this.b += j;
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.c
 * JD-Core Version:    0.7.0.1
 */