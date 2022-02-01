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
      return -1;
    }
    paramInt2 = Math.min(paramInt2, localn.c - localn.b);
    System.arraycopy(localn.a, localn.b, paramArrayOfByte, paramInt1, paramInt2);
    localn.b += paramInt2;
    this.b -= paramInt2;
    if (localn.b == localn.c)
    {
      this.a = localn.b();
      o.a(localn);
    }
    return paramInt2;
  }
  
  public long a(byte paramByte)
  {
    return a(paramByte, 0L, 9223372036854775807L);
  }
  
  public long a(byte paramByte, long paramLong1, long paramLong2)
  {
    if ((paramLong1 >= 0L) && (paramLong2 >= paramLong1))
    {
      long l1 = this.b;
      if (paramLong2 <= l1) {
        l1 = paramLong2;
      }
      if (paramLong1 == l1) {
        return -1L;
      }
      n localn = this.a;
      if (localn == null) {
        return -1L;
      }
      paramLong2 = this.b;
      if (paramLong2 - paramLong1 < paramLong1)
      {
        while (paramLong2 > paramLong1)
        {
          localn = localn.g;
          paramLong2 -= localn.c - localn.b;
        }
      }
      else
      {
        long l2;
        for (paramLong2 = 0L;; paramLong2 = l2)
        {
          l2 = localn.c - localn.b + paramLong2;
          if (l2 >= paramLong1) {
            break;
          }
          localn = localn.f;
        }
      }
      while (paramLong2 < l1)
      {
        byte[] arrayOfByte = localn.a;
        int j = (int)Math.min(localn.c, localn.b + l1 - paramLong2);
        int i = (int)(localn.b + paramLong1 - paramLong2);
        while (i < j)
        {
          if (arrayOfByte[i] == paramByte) {
            return i - localn.b + paramLong2;
          }
          i += 1;
        }
        paramLong1 = localn.c - localn.b + paramLong2;
        localn = localn.f;
        paramLong2 = paramLong1;
      }
      return -1L;
    }
    throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.b), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public long a(c paramc, long paramLong)
  {
    if (paramc != null)
    {
      if (paramLong >= 0L)
      {
        long l2 = this.b;
        if (l2 == 0L) {
          return -1L;
        }
        long l1 = paramLong;
        if (paramLong > l2) {
          l1 = l2;
        }
        paramc.a_(this, l1);
        return l1;
      }
      paramc = new StringBuilder();
      paramc.append("byteCount < 0: ");
      paramc.append(paramLong);
      throw new IllegalArgumentException(paramc.toString());
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public long a(q paramq)
  {
    if (paramq != null)
    {
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
    throw new IllegalArgumentException("source == null");
  }
  
  public String a(long paramLong, Charset paramCharset)
  {
    s.a(this.b, 0L, paramLong);
    if (paramCharset != null)
    {
      if (paramLong <= 2147483647L)
      {
        if (paramLong == 0L) {
          return "";
        }
        n localn = this.a;
        if (localn.b + paramLong > localn.c) {
          return new String(g(paramLong), paramCharset);
        }
        paramCharset = new String(localn.a, localn.b, (int)paramLong, paramCharset);
        localn.b = ((int)(localn.b + paramLong));
        this.b -= paramLong;
        if (localn.b == localn.c)
        {
          this.a = localn.b();
          o.a(localn);
        }
        return paramCharset;
      }
      paramCharset = new StringBuilder();
      paramCharset.append("byteCount > Integer.MAX_VALUE: ");
      paramCharset.append(paramLong);
      throw new IllegalArgumentException(paramCharset.toString());
    }
    throw new IllegalArgumentException("charset == null");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected code point: ");
    localStringBuilder.append(Integer.toHexString(paramInt));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public c a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public c a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            while (paramInt1 < paramInt2)
            {
              int k = paramString.charAt(paramInt1);
              int j;
              int i;
              if (k < 128)
              {
                localObject = e(1);
                byte[] arrayOfByte = ((n)localObject).a;
                j = ((n)localObject).c - paramInt1;
                int m = Math.min(paramInt2, 8192 - j);
                i = paramInt1 + 1;
                arrayOfByte[(paramInt1 + j)] = ((byte)k);
                paramInt1 = i;
                while (paramInt1 < m)
                {
                  i = paramString.charAt(paramInt1);
                  if (i >= 128) {
                    break;
                  }
                  arrayOfByte[(paramInt1 + j)] = ((byte)i);
                  paramInt1 += 1;
                }
                i = j + paramInt1 - ((n)localObject).c;
                ((n)localObject).c += i;
                this.b += i;
              }
              else if (k < 2048)
              {
                b(k >> 6 | 0xC0);
                b(k & 0x3F | 0x80);
                paramInt1 += 1;
              }
              else if ((k >= 55296) && (k <= 57343))
              {
                j = paramInt1 + 1;
                if (j < paramInt2) {
                  i = paramString.charAt(j);
                } else {
                  i = 0;
                }
                if ((k <= 56319) && (i >= 56320) && (i <= 57343))
                {
                  i = ((k & 0xFFFF27FF) << 10 | 0xFFFF23FF & i) + 65536;
                  b(i >> 18 | 0xF0);
                  b(i >> 12 & 0x3F | 0x80);
                  b(i >> 6 & 0x3F | 0x80);
                  b(i & 0x3F | 0x80);
                  paramInt1 += 2;
                }
                else
                {
                  b(63);
                  paramInt1 = j;
                }
              }
              else
              {
                b(k >> 12 | 0xE0);
                b(k >> 6 & 0x3F | 0x80);
                b(k & 0x3F | 0x80);
                paramInt1 += 1;
              }
            }
            return this;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("endIndex > string.length: ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" > ");
          ((StringBuilder)localObject).append(paramString.length());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalArgumentException(paramString.toString());
    }
    throw new IllegalArgumentException("string == null");
  }
  
  public c a(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    if (paramString != null)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= paramInt1)
        {
          if (paramInt2 <= paramString.length())
          {
            if (paramCharset != null)
            {
              if (paramCharset.equals(s.a)) {
                return a(paramString, paramInt1, paramInt2);
              }
              paramString = paramString.substring(paramInt1, paramInt2).getBytes(paramCharset);
              return b(paramString, 0, paramString.length);
            }
            throw new IllegalArgumentException("charset == null");
          }
          paramCharset = new StringBuilder();
          paramCharset.append("endIndex > string.length: ");
          paramCharset.append(paramInt2);
          paramCharset.append(" > ");
          paramCharset.append(paramString.length());
          throw new IllegalArgumentException(paramCharset.toString());
        }
        paramString = new StringBuilder();
        paramString.append("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      paramString = new StringBuilder();
      paramString.append("beginIndex < 0: ");
      paramString.append(paramInt1);
      throw new IllegalAccessError(paramString.toString());
    }
    throw new IllegalArgumentException("string == null");
  }
  
  public c a(ByteString paramByteString)
  {
    if (paramByteString != null)
    {
      paramByteString.a(this);
      return this;
    }
    throw new IllegalArgumentException("byteString == null");
  }
  
  public c a(c paramc, long paramLong1, long paramLong2)
  {
    if (paramc != null)
    {
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
      while (l2 > 0L)
      {
        localn1 = localn2.a();
        localn1.b = ((int)(localn1.b + l1));
        localn1.c = Math.min(localn1.b + (int)l2, localn1.c);
        n localn3 = paramc.a;
        if (localn3 == null)
        {
          localn1.g = localn1;
          localn1.f = localn1;
          paramc.a = localn1;
        }
        else
        {
          localn3.g.a(localn1);
        }
        l2 -= localn1.c - localn1.b;
        localn2 = localn2.f;
        l1 = 0L;
      }
      return this;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public r a()
  {
    return r.c;
  }
  
  public void a(long paramLong)
  {
    if (this.b >= paramLong) {
      return;
    }
    throw new EOFException();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = a(paramArrayOfByte, i, paramArrayOfByte.length - i);
      if (j != -1) {
        i += j;
      } else {
        throw new EOFException();
      }
    }
  }
  
  public void a_(c paramc, long paramLong)
  {
    if (paramc != null)
    {
      if (paramc != this)
      {
        s.a(paramc.b, 0L, paramLong);
        while (paramLong > 0L)
        {
          if (paramLong < paramc.a.c - paramc.a.b)
          {
            localn1 = this.a;
            if (localn1 != null) {
              localn1 = localn1.g;
            } else {
              localn1 = null;
            }
            if ((localn1 != null) && (localn1.e))
            {
              l = localn1.c;
              int i;
              if (localn1.d) {
                i = 0;
              } else {
                i = localn1.b;
              }
              if (l + paramLong - i <= 8192L)
              {
                paramc.a.a(localn1, (int)paramLong);
                paramc.b -= paramLong;
                this.b += paramLong;
                return;
              }
            }
            paramc.a = paramc.a.a((int)paramLong);
          }
          n localn1 = paramc.a;
          long l = localn1.c - localn1.b;
          paramc.a = localn1.b();
          n localn2 = this.a;
          if (localn2 == null)
          {
            this.a = localn1;
            localn1 = this.a;
            localn1.g = localn1;
            localn1.f = localn1;
          }
          else
          {
            localn2.g.a(localn1).c();
          }
          paramc.b -= l;
          this.b += l;
          paramLong -= l;
        }
        return;
      }
      throw new IllegalArgumentException("source == this");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public byte b(long paramLong)
  {
    s.a(this.b, paramLong, 1L);
    long l = this.b;
    if (l - paramLong > paramLong) {
      for (localObject = this.a;; localObject = ((n)localObject).f)
      {
        l = ((n)localObject).c - ((n)localObject).b;
        if (paramLong < l) {
          return localObject.a[(localObject.b + (int)paramLong)];
        }
        paramLong -= l;
      }
    }
    paramLong -= l;
    Object localObject = this.a;
    n localn;
    do
    {
      localn = ((n)localObject).g;
      l = paramLong + (localn.c - localn.b);
      localObject = localn;
      paramLong = l;
    } while (l < 0L);
    return localn.a[(localn.b + (int)l)];
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
    if (paramArrayOfByte != null) {
      return b(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public c b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      long l1 = paramArrayOfByte.length;
      long l2 = paramInt1;
      long l3 = paramInt2;
      s.a(l1, l2, l3);
      paramInt2 += paramInt1;
      while (paramInt1 < paramInt2)
      {
        n localn = e(1);
        int i = Math.min(paramInt2 - paramInt1, 8192 - localn.c);
        System.arraycopy(paramArrayOfByte, paramInt1, localn.a, localn.c, i);
        paramInt1 += i;
        localn.c += i;
      }
      this.b += l3;
      return this;
    }
    throw new IllegalArgumentException("source == null");
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
    if (paramLong >= 0L)
    {
      long l1 = 9223372036854775807L;
      if (paramLong != 9223372036854775807L) {
        l1 = paramLong + 1L;
      }
      long l2 = a((byte)10, 0L, l1);
      if (l2 != -1L) {
        return f(l2);
      }
      if ((l1 < b()) && (b(l1 - 1L) == 13) && (b(l1) == 10)) {
        return f(l1);
      }
      localObject = new c();
      a((c)localObject, 0L, Math.min(32L, b()));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\\n not found: limit=");
      localStringBuilder.append(Math.min(b(), paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(((c)localObject).n().e());
      localStringBuilder.append('…');
      throw new EOFException(localStringBuilder.toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("limit < 0: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  n e(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 8192))
    {
      Object localObject = this.a;
      if (localObject == null)
      {
        this.a = o.a();
        localObject = this.a;
        ((n)localObject).g = ((n)localObject);
        ((n)localObject).f = ((n)localObject);
        return localObject;
      }
      n localn = ((n)localObject).g;
      if (localn.c + paramInt <= 8192)
      {
        localObject = localn;
        if (localn.e) {}
      }
      else
      {
        localObject = localn.a(o.a());
      }
      return localObject;
    }
    throw new IllegalArgumentException();
  }
  
  public boolean e()
  {
    return this.b == 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    long l2 = this.b;
    if (l2 != paramObject.b) {
      return false;
    }
    long l1 = 0L;
    if (l2 == 0L) {
      return true;
    }
    n localn = this.a;
    paramObject = paramObject.a;
    int j = localn.b;
    int i = paramObject.b;
    while (l1 < this.b)
    {
      l2 = Math.min(localn.c - j, paramObject.c - i);
      int k = 0;
      while (k < l2)
      {
        if (localn.a[j] != paramObject.a[i]) {
          return false;
        }
        k += 1;
        j += 1;
        i += 1;
      }
      if (j == localn.c)
      {
        localn = localn.f;
        j = localn.b;
      }
      if (i == paramObject.c)
      {
        paramObject = paramObject.f;
        i = paramObject.b;
      }
      l1 += l2;
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(c.this);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
  }
  
  String f(long paramLong)
  {
    if (paramLong > 0L)
    {
      long l = paramLong - 1L;
      if (b(l) == 13)
      {
        str = d(l);
        h(2L);
        return str;
      }
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
    if (l2 == 0L) {
      return 0L;
    }
    n localn = this.a.g;
    long l1 = l2;
    if (localn.c < 8192)
    {
      l1 = l2;
      if (localn.e) {
        l1 = l2 - (localn.c - localn.b);
      }
    }
    return l1;
  }
  
  public byte[] g(long paramLong)
  {
    s.a(this.b, 0L, paramLong);
    if (paramLong <= 2147483647L)
    {
      localObject = new byte[(int)paramLong];
      a((byte[])localObject);
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("byteCount > Integer.MAX_VALUE: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public byte h()
  {
    if (this.b != 0L)
    {
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
    throw new IllegalStateException("size == 0");
  }
  
  public void h(long paramLong)
  {
    while (paramLong > 0L)
    {
      n localn = this.a;
      if (localn != null)
      {
        int i = (int)Math.min(paramLong, localn.c - this.a.b);
        long l1 = this.b;
        long l2 = i;
        this.b = (l1 - l2);
        l1 = paramLong - l2;
        localn = this.a;
        localn.b += i;
        paramLong = l1;
        if (this.a.b == this.a.c)
        {
          localn = this.a;
          this.a = localn.b();
          o.a(localn);
          paramLong = l1;
        }
      }
      else
      {
        throw new EOFException();
      }
    }
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int i = 1;
    int j;
    n localn;
    do
    {
      int k = ((n)localObject).b;
      int m = ((n)localObject).c;
      j = i;
      while (k < m)
      {
        j = j * 31 + localObject.a[k];
        k += 1;
      }
      localn = ((n)localObject).f;
      localObject = localn;
      i = j;
    } while (localn != this.a);
    return j;
  }
  
  public c i(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = 0;
    int i = 1;
    long l = paramLong;
    if (paramLong < 0L)
    {
      l = -paramLong;
      if (l < 0L) {
        return a("-9223372036854775808");
      }
      j = 1;
    }
    if (l < 100000000L)
    {
      if (l < 10000L)
      {
        if (l < 100L)
        {
          if (l >= 10L) {
            i = 2;
          }
        }
        else if (l < 1000L) {
          i = 3;
        } else {
          i = 4;
        }
      }
      else if (l < 1000000L)
      {
        if (l < 100000L) {
          i = 5;
        } else {
          i = 6;
        }
      }
      else if (l < 10000000L) {
        i = 7;
      } else {
        i = 8;
      }
    }
    else if (l < 1000000000000L)
    {
      if (l < 10000000000L)
      {
        if (l < 1000000000L) {
          i = 9;
        } else {
          i = 10;
        }
      }
      else if (l < 100000000000L) {
        i = 11;
      } else {
        i = 12;
      }
    }
    else if (l < 1000000000000000L)
    {
      if (l < 10000000000000L) {
        i = 13;
      } else if (l < 100000000000000L) {
        i = 14;
      } else {
        i = 15;
      }
    }
    else if (l < 100000000000000000L)
    {
      if (l < 10000000000000000L) {
        i = 16;
      } else {
        i = 17;
      }
    }
    else if (l < 1000000000000000000L) {
      i = 18;
    } else {
      i = 19;
    }
    int k = i;
    if (j != 0) {
      k = i + 1;
    }
    n localn = e(k);
    byte[] arrayOfByte = localn.a;
    i = localn.c + k;
    while (l != 0L)
    {
      int m = (int)(l % 10L);
      i -= 1;
      arrayOfByte[i] = c[m];
      l /= 10L;
    }
    if (j != 0) {
      arrayOfByte[(i - 1)] = 45;
    }
    localn.c += k;
    this.b += k;
    return this;
  }
  
  public short i()
  {
    if (this.b >= 2L)
    {
      localObject = this.a;
      int k = ((n)localObject).b;
      int i = ((n)localObject).c;
      if (i - k < 2) {
        return (short)((h() & 0xFF) << 8 | h() & 0xFF);
      }
      byte[] arrayOfByte = ((n)localObject).a;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      this.b -= 2L;
      if (m == i)
      {
        this.a = ((n)localObject).b();
        o.a((n)localObject);
      }
      else
      {
        ((n)localObject).b = m;
      }
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 2: ");
    ((StringBuilder)localObject).append(this.b);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public boolean isOpen()
  {
    return true;
  }
  
  public int j()
  {
    if (this.b >= 4L)
    {
      localObject = this.a;
      int j = ((n)localObject).b;
      int i = ((n)localObject).c;
      if (i - j < 4) {
        return (h() & 0xFF) << 24 | (h() & 0xFF) << 16 | (h() & 0xFF) << 8 | h() & 0xFF;
      }
      byte[] arrayOfByte = ((n)localObject).a;
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
        this.a = ((n)localObject).b();
        o.a((n)localObject);
        return j;
      }
      ((n)localObject).b = n;
      return j;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("size < 4: ");
    ((StringBuilder)localObject).append(this.b);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
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
    this.b += j;
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
    if (this.b != 0L)
    {
      int j = 0;
      long l1 = 0L;
      int i = 0;
      long l2;
      int k;
      label231:
      do
      {
        Object localObject1 = this.a;
        Object localObject2 = ((n)localObject1).a;
        int m = ((n)localObject1).b;
        int n = ((n)localObject1).c;
        l2 = l1;
        k = i;
        int i1;
        for (;;)
        {
          i = j;
          if (m >= n) {
            break label282;
          }
          i1 = localObject2[m];
          if ((i1 >= 48) && (i1 <= 57))
          {
            i = i1 - 48;
          }
          else if ((i1 >= 97) && (i1 <= 102))
          {
            i = i1 - 97 + 10;
          }
          else
          {
            if ((i1 < 65) || (i1 > 70)) {
              break label231;
            }
            i = i1 - 65 + 10;
          }
          if ((0x0 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | i;
          m += 1;
          k += 1;
        }
        localObject1 = new c().j(l2).b(i1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Number too large: ");
        ((StringBuilder)localObject2).append(((c)localObject1).o());
        throw new NumberFormatException(((StringBuilder)localObject2).toString());
        if (k != 0)
        {
          i = 1;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Expected leading [0-9a-fA-F] character but was 0x");
          ((StringBuilder)localObject1).append(Integer.toHexString(i1));
          throw new NumberFormatException(((StringBuilder)localObject1).toString());
        }
        if (m == n)
        {
          this.a = ((n)localObject1).b();
          o.a((n)localObject1);
        }
        else
        {
          ((n)localObject1).b = m;
        }
        if (i != 0) {
          break;
        }
        j = i;
        i = k;
        l1 = l2;
      } while (this.a != null);
      label282:
      this.b -= k;
      return l2;
    }
    throw new IllegalStateException("size == 0");
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
    if (localn == null) {
      return -1;
    }
    int i = Math.min(paramByteBuffer.remaining(), localn.c - localn.b);
    paramByteBuffer.put(localn.a, localn.b, i);
    localn.b += i;
    this.b -= i;
    if (localn.b == localn.c)
    {
      this.a = localn.b();
      o.a(localn);
    }
    return i;
  }
  
  public c s()
  {
    c localc = new c();
    if (this.b == 0L) {
      return localc;
    }
    localc.a = this.a.a();
    n localn = localc.a;
    localn.g = localn;
    localn.f = localn;
    localn = this.a;
    for (;;)
    {
      localn = localn.f;
      if (localn == this.a) {
        break;
      }
      localc.a.g.a(localn.a());
    }
    localc.b = this.b;
    return localc;
  }
  
  public ByteString t()
  {
    long l = this.b;
    if (l <= 2147483647L) {
      return f((int)l);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("size > Integer.MAX_VALUE: ");
    localStringBuilder.append(this.b);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String toString()
  {
    return t().toString();
  }
  
  public int write(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      int j = paramByteBuffer.remaining();
      int i = j;
      while (i > 0)
      {
        n localn = e(1);
        int k = Math.min(i, 8192 - localn.c);
        paramByteBuffer.get(localn.a, localn.c, k);
        i -= k;
        localn.c += k;
      }
      this.b += j;
      return j;
    }
    throw new IllegalArgumentException("source == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.c
 * JD-Core Version:    0.7.0.1
 */