package com.tencent.token;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class aky
  implements akz, ala, Cloneable, ByteChannel
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  @Nullable
  alk a;
  public long b;
  
  private String a(long paramLong, Charset paramCharset)
  {
    alq.a(this.b, 0L, paramLong);
    if (paramCharset != null)
    {
      if (paramLong <= 2147483647L)
      {
        if (paramLong == 0L) {
          return "";
        }
        alk localalk = this.a;
        if (localalk.b + paramLong > localalk.c) {
          return new String(f(paramLong), paramCharset);
        }
        paramCharset = new String(localalk.a, localalk.b, (int)paramLong, paramCharset);
        localalk.b = ((int)(localalk.b + paramLong));
        this.b -= paramLong;
        if (localalk.b == localalk.c)
        {
          this.a = localalk.b();
          all.a(localalk);
        }
        return paramCharset;
      }
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(paramLong)));
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  private String l(long paramLong)
  {
    return a(paramLong, alq.a);
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    alq.a(paramArrayOfByte.length, paramInt1, paramInt2);
    alk localalk = this.a;
    if (localalk == null) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, localalk.c - localalk.b);
    System.arraycopy(localalk.a, localalk.b, paramArrayOfByte, paramInt1, paramInt2);
    localalk.b += paramInt2;
    this.b -= paramInt2;
    if (localalk.b == localalk.c)
    {
      this.a = localalk.b();
      all.a(localalk);
    }
    return paramInt2;
  }
  
  public final long a(byte paramByte, long paramLong1, long paramLong2)
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
      alk localalk = this.a;
      if (localalk == null) {
        return -1L;
      }
      paramLong2 = this.b;
      if (paramLong2 - paramLong1 < paramLong1)
      {
        while (paramLong2 > paramLong1)
        {
          localalk = localalk.g;
          paramLong2 -= localalk.c - localalk.b;
        }
      }
      else
      {
        long l2;
        for (paramLong2 = 0L;; paramLong2 = l2)
        {
          l2 = localalk.c - localalk.b + paramLong2;
          if (l2 >= paramLong1) {
            break;
          }
          localalk = localalk.f;
        }
      }
      while (paramLong2 < l1)
      {
        byte[] arrayOfByte = localalk.a;
        int j = (int)Math.min(localalk.c, localalk.b + l1 - paramLong2);
        int i = (int)(localalk.b + paramLong1 - paramLong2);
        while (i < j)
        {
          if (arrayOfByte[i] == paramByte) {
            return i - localalk.b + paramLong2;
          }
          i += 1;
        }
        paramLong1 = localalk.c - localalk.b + paramLong2;
        localalk = localalk.f;
        paramLong2 = paramLong1;
      }
      return -1L;
    }
    throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.b), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public final long a(aky paramaky, long paramLong)
  {
    if (paramaky != null)
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
        paramaky.a_(this, l1);
        return l1;
      }
      throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public final long a(alo paramalo)
  {
    if (paramalo != null)
    {
      long l2;
      for (long l1 = 0L;; l1 += l2)
      {
        l2 = paramalo.a(this, 8192L);
        if (l2 == -1L) {
          break;
        }
      }
      return l1;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public final aky a(int paramInt)
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
    StringBuilder localStringBuilder = new StringBuilder("Unexpected code point: ");
    localStringBuilder.append(Integer.toHexString(paramInt));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final aky a(aky paramaky, long paramLong1, long paramLong2)
  {
    if (paramaky != null)
    {
      alq.a(this.b, paramLong1, paramLong2);
      if (paramLong2 == 0L) {
        return this;
      }
      paramaky.b += paramLong2;
      alk localalk2;
      long l1;
      long l2;
      for (alk localalk1 = this.a;; localalk1 = localalk1.f)
      {
        localalk2 = localalk1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < localalk1.c - localalk1.b) {
          break;
        }
        paramLong1 -= localalk1.c - localalk1.b;
      }
      while (l2 > 0L)
      {
        localalk1 = localalk2.a();
        localalk1.b = ((int)(localalk1.b + l1));
        localalk1.c = Math.min(localalk1.b + (int)l2, localalk1.c);
        alk localalk3 = paramaky.a;
        if (localalk3 == null)
        {
          localalk1.g = localalk1;
          localalk1.f = localalk1;
          paramaky.a = localalk1;
        }
        else
        {
          localalk3.g.a(localalk1);
        }
        l2 -= localalk1.c - localalk1.b;
        localalk2 = localalk2.f;
        l1 = 0L;
      }
      return this;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public final aky a(alb paramalb)
  {
    if (paramalb != null)
    {
      paramalb.a(this);
      return this;
    }
    throw new IllegalArgumentException("byteString == null");
  }
  
  public final aky a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public final aky a(String paramString, int paramInt1, int paramInt2)
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
              int i;
              int j;
              if (k < 128)
              {
                localObject = e(1);
                byte[] arrayOfByte = ((alk)localObject).a;
                i = ((alk)localObject).c - paramInt1;
                j = Math.min(paramInt2, 8192 - i);
                arrayOfByte[(paramInt1 + i)] = ((byte)k);
                paramInt1 += 1;
                while (paramInt1 < j)
                {
                  k = paramString.charAt(paramInt1);
                  if (k >= 128) {
                    break;
                  }
                  arrayOfByte[(paramInt1 + i)] = ((byte)k);
                  paramInt1 += 1;
                }
                i = i + paramInt1 - ((alk)localObject).c;
                ((alk)localObject).c += i;
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
          Object localObject = new StringBuilder("endIndex > string.length: ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" > ");
          ((StringBuilder)localObject).append(paramString.length());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
        paramString = new StringBuilder("endIndex < beginIndex: ");
        paramString.append(paramInt2);
        paramString.append(" < ");
        paramString.append(paramInt1);
        throw new IllegalArgumentException(paramString.toString());
      }
      throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(paramInt1)));
    }
    throw new IllegalArgumentException("string == null");
  }
  
  public final alp a()
  {
    return alp.c;
  }
  
  public final void a(long paramLong)
  {
    if (this.b >= paramLong) {
      return;
    }
    throw new EOFException();
  }
  
  public final void a(byte[] paramArrayOfByte)
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
  
  public final void a_(aky paramaky, long paramLong)
  {
    if (paramaky != null)
    {
      if (paramaky != this)
      {
        alq.a(paramaky.b, 0L, paramLong);
        while (paramLong > 0L)
        {
          long l = paramaky.a.c - paramaky.a.b;
          int j = 0;
          int i;
          if (paramLong < l)
          {
            localalk1 = this.a;
            if (localalk1 != null) {
              localalk1 = localalk1.g;
            } else {
              localalk1 = null;
            }
            if ((localalk1 != null) && (localalk1.e))
            {
              l = localalk1.c;
              if (localalk1.d) {
                i = 0;
              } else {
                i = localalk1.b;
              }
              if (l + paramLong - i <= 8192L)
              {
                paramaky.a.a(localalk1, (int)paramLong);
                paramaky.b -= paramLong;
                this.b += paramLong;
                return;
              }
            }
            localalk2 = paramaky.a;
            i = (int)paramLong;
            if ((i > 0) && (i <= localalk2.c - localalk2.b))
            {
              if (i >= 1024)
              {
                localalk1 = localalk2.a();
              }
              else
              {
                localalk1 = all.a();
                System.arraycopy(localalk2.a, localalk2.b, localalk1.a, 0, i);
              }
              localalk1.c = (localalk1.b + i);
              localalk2.b += i;
              localalk2.g.a(localalk1);
              paramaky.a = localalk1;
            }
            else
            {
              throw new IllegalArgumentException();
            }
          }
          alk localalk1 = paramaky.a;
          l = localalk1.c - localalk1.b;
          paramaky.a = localalk1.b();
          alk localalk2 = this.a;
          if (localalk2 == null)
          {
            this.a = localalk1;
            localalk1 = this.a;
            localalk1.g = localalk1;
            localalk1.f = localalk1;
          }
          else
          {
            localalk1 = localalk2.g.a(localalk1);
            if (localalk1.g == localalk1) {
              break label514;
            }
            if (localalk1.g.e)
            {
              int k = localalk1.c - localalk1.b;
              int m = localalk1.g.c;
              if (localalk1.g.d) {
                i = j;
              } else {
                i = localalk1.g.b;
              }
              if (k <= 8192 - m + i)
              {
                localalk1.a(localalk1.g, k);
                localalk1.b();
                all.a(localalk1);
              }
            }
          }
          paramaky.b -= l;
          this.b += l;
          paramLong -= l;
          continue;
          label514:
          throw new IllegalStateException();
        }
        return;
      }
      throw new IllegalArgumentException("source == this");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public final byte b(long paramLong)
  {
    alq.a(this.b, paramLong, 1L);
    long l = this.b;
    if (l - paramLong > paramLong) {
      for (localObject = this.a;; localObject = ((alk)localObject).f)
      {
        l = ((alk)localObject).c - ((alk)localObject).b;
        if (paramLong < l) {
          return localObject.a[(localObject.b + (int)paramLong)];
        }
        paramLong -= l;
      }
    }
    paramLong -= l;
    Object localObject = this.a;
    alk localalk;
    do
    {
      localalk = ((alk)localObject).g;
      l = paramLong + (localalk.c - localalk.b);
      localObject = localalk;
      paramLong = l;
    } while (l < 0L);
    return localalk.a[(localalk.b + (int)l)];
  }
  
  public final aky b()
  {
    return this;
  }
  
  public final aky b(int paramInt)
  {
    alk localalk = e(1);
    byte[] arrayOfByte = localalk.a;
    int i = localalk.c;
    localalk.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b += 1L;
    return this;
  }
  
  public final aky b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return b(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public final aky b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      long l1 = paramArrayOfByte.length;
      long l2 = paramInt1;
      long l3 = paramInt2;
      alq.a(l1, l2, l3);
      paramInt2 += paramInt1;
      while (paramInt1 < paramInt2)
      {
        alk localalk = e(1);
        int i = Math.min(paramInt2 - paramInt1, 8192 - localalk.c);
        System.arraycopy(paramArrayOfByte, paramInt1, localalk.a, localalk.c, i);
        paramInt1 += i;
        localalk.c += i;
      }
      this.b += l3;
      return this;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public final aky c(int paramInt)
  {
    alk localalk = e(2);
    byte[] arrayOfByte = localalk.a;
    int i = localalk.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localalk.c = (j + 1);
    this.b += 2L;
    return this;
  }
  
  public final alb c(long paramLong)
  {
    return new alb(f(paramLong));
  }
  
  public final boolean c()
  {
    return this.b == 0L;
  }
  
  public final void close() {}
  
  public final aky d(int paramInt)
  {
    alk localalk = e(4);
    byte[] arrayOfByte = localalk.a;
    int j = localalk.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localalk.c = (i + 1);
    this.b += 4L;
    return this;
  }
  
  public final InputStream d()
  {
    new InputStream()
    {
      public final int available()
      {
        return (int)Math.min(aky.this.b, 2147483647L);
      }
      
      public final void close() {}
      
      public final int read()
      {
        if (aky.this.b > 0L) {
          return aky.this.f() & 0xFF;
        }
        return -1;
      }
      
      public final int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return aky.this.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(aky.this);
        localStringBuilder.append(".inputStream()");
        return localStringBuilder.toString();
      }
    };
  }
  
  public final String d(long paramLong)
  {
    if (paramLong >= 0L)
    {
      long l1 = 9223372036854775807L;
      if (paramLong != 9223372036854775807L) {
        l1 = paramLong + 1L;
      }
      long l2 = a((byte)10, 0L, l1);
      if (l2 != -1L) {
        return e(l2);
      }
      if ((l1 < this.b) && (b(l1 - 1L) == 13) && (b(l1) == 10)) {
        return e(l1);
      }
      aky localaky = new aky();
      a(localaky, 0L, Math.min(32L, this.b));
      StringBuilder localStringBuilder = new StringBuilder("\\n not found: limit=");
      localStringBuilder.append(Math.min(this.b, paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(localaky.l().e());
      localStringBuilder.append('…');
      throw new EOFException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(paramLong)));
  }
  
  public final long e()
  {
    long l2 = this.b;
    if (l2 == 0L) {
      return 0L;
    }
    alk localalk = this.a.g;
    long l1 = l2;
    if (localalk.c < 8192)
    {
      l1 = l2;
      if (localalk.e) {
        l1 = l2 - (localalk.c - localalk.b);
      }
    }
    return l1;
  }
  
  final alk e(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 8192))
    {
      Object localObject = this.a;
      if (localObject == null)
      {
        this.a = all.a();
        localObject = this.a;
        ((alk)localObject).g = ((alk)localObject);
        ((alk)localObject).f = ((alk)localObject);
        return localObject;
      }
      alk localalk = ((alk)localObject).g;
      if (localalk.c + paramInt <= 8192)
      {
        localObject = localalk;
        if (localalk.e) {}
      }
      else
      {
        localObject = localalk.a(all.a());
      }
      return localObject;
    }
    throw new IllegalArgumentException();
  }
  
  final String e(long paramLong)
  {
    if (paramLong > 0L)
    {
      long l = paramLong - 1L;
      if (b(l) == 13)
      {
        str = l(l);
        g(2L);
        return str;
      }
    }
    String str = l(paramLong);
    g(1L);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof aky)) {
      return false;
    }
    paramObject = (aky)paramObject;
    long l2 = this.b;
    if (l2 != paramObject.b) {
      return false;
    }
    long l1 = 0L;
    if (l2 == 0L) {
      return true;
    }
    alk localalk = this.a;
    paramObject = paramObject.a;
    int j = localalk.b;
    int i = paramObject.b;
    while (l1 < this.b)
    {
      l2 = Math.min(localalk.c - j, paramObject.c - i);
      int k = 0;
      while (k < l2)
      {
        if (localalk.a[j] != paramObject.a[i]) {
          return false;
        }
        k += 1;
        j += 1;
        i += 1;
      }
      if (j == localalk.c)
      {
        localalk = localalk.f;
        j = localalk.b;
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
  
  public final byte f()
  {
    if (this.b != 0L)
    {
      alk localalk = this.a;
      int i = localalk.b;
      int j = localalk.c;
      byte[] arrayOfByte = localalk.a;
      int k = i + 1;
      byte b1 = arrayOfByte[i];
      this.b -= 1L;
      if (k == j)
      {
        this.a = localalk.b();
        all.a(localalk);
        return b1;
      }
      localalk.b = k;
      return b1;
    }
    throw new IllegalStateException("size == 0");
  }
  
  public final byte[] f(long paramLong)
  {
    alq.a(this.b, 0L, paramLong);
    if (paramLong <= 2147483647L)
    {
      byte[] arrayOfByte = new byte[(int)paramLong];
      a(arrayOfByte);
      return arrayOfByte;
    }
    throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(paramLong)));
  }
  
  public final void flush() {}
  
  public final short g()
  {
    if (this.b >= 2L)
    {
      localObject = this.a;
      int k = ((alk)localObject).b;
      int i = ((alk)localObject).c;
      if (i - k < 2) {
        return (short)((f() & 0xFF) << 8 | f() & 0xFF);
      }
      byte[] arrayOfByte = ((alk)localObject).a;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      this.b -= 2L;
      if (m == i)
      {
        this.a = ((alk)localObject).b();
        all.a((alk)localObject);
      }
      else
      {
        ((alk)localObject).b = m;
      }
      return (short)((k & 0xFF) << 8 | j & 0xFF);
    }
    Object localObject = new StringBuilder("size < 2: ");
    ((StringBuilder)localObject).append(this.b);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final void g(long paramLong)
  {
    while (paramLong > 0L)
    {
      alk localalk = this.a;
      if (localalk != null)
      {
        int i = (int)Math.min(paramLong, localalk.c - this.a.b);
        long l1 = this.b;
        long l2 = i;
        this.b = (l1 - l2);
        l1 = paramLong - l2;
        localalk = this.a;
        localalk.b += i;
        paramLong = l1;
        if (this.a.b == this.a.c)
        {
          localalk = this.a;
          this.a = localalk.b();
          all.a(localalk);
          paramLong = l1;
        }
      }
      else
      {
        throw new EOFException();
      }
    }
  }
  
  public final int h()
  {
    if (this.b >= 4L)
    {
      localObject = this.a;
      int j = ((alk)localObject).b;
      int i = ((alk)localObject).c;
      if (i - j < 4) {
        return (f() & 0xFF) << 24 | (f() & 0xFF) << 16 | (f() & 0xFF) << 8 | f() & 0xFF;
      }
      byte[] arrayOfByte = ((alk)localObject).a;
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
        this.a = ((alk)localObject).b();
        all.a((alk)localObject);
        return j;
      }
      ((alk)localObject).b = n;
      return j;
    }
    Object localObject = new StringBuilder("size < 4: ");
    ((StringBuilder)localObject).append(this.b);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final aky h(long paramLong)
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
    alk localalk = e(k);
    byte[] arrayOfByte = localalk.a;
    i = localalk.c + k;
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
    localalk.c += k;
    this.b += k;
    return this;
  }
  
  public final int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    int i = 1;
    int j;
    alk localalk;
    do
    {
      int k = ((alk)localObject).b;
      int m = ((alk)localObject).c;
      j = i;
      while (k < m)
      {
        j = j * 31 + localObject.a[k];
        k += 1;
      }
      localalk = ((alk)localObject).f;
      localObject = localalk;
      i = j;
    } while (localalk != this.a);
    return j;
  }
  
  public final aky i(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    alk localalk = e(j);
    byte[] arrayOfByte = localalk.a;
    int i = localalk.c + j - 1;
    int k = localalk.c;
    while (i >= k)
    {
      arrayOfByte[i] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localalk.c += j;
    this.b += j;
    return this;
  }
  
  public final short i()
  {
    return alq.a(g());
  }
  
  public final boolean isOpen()
  {
    return true;
  }
  
  public final int j()
  {
    return alq.a(h());
  }
  
  public final long k()
  {
    if (this.b != 0L)
    {
      long l1 = 0L;
      int i = 0;
      int j = 0;
      int k;
      long l2;
      label226:
      do
      {
        Object localObject1 = this.a;
        Object localObject2 = ((alk)localObject1).a;
        int m = ((alk)localObject1).b;
        int i1 = ((alk)localObject1).c;
        k = i;
        l2 = l1;
        int n;
        for (;;)
        {
          n = j;
          if (m >= i1) {
            break label272;
          }
          n = localObject2[m];
          if ((n >= 48) && (n <= 57))
          {
            i = n - 48;
          }
          else if ((n >= 97) && (n <= 102))
          {
            i = n - 97 + 10;
          }
          else
          {
            if ((n < 65) || (n > 70)) {
              break label226;
            }
            i = n - 65 + 10;
          }
          if ((0x0 & l2) != 0L) {
            break;
          }
          l2 = l2 << 4 | i;
          m += 1;
          k += 1;
        }
        localObject1 = new aky().i(l2).b(n);
        localObject2 = new StringBuilder("Number too large: ");
        ((StringBuilder)localObject2).append(((aky)localObject1).m());
        throw new NumberFormatException(((StringBuilder)localObject2).toString());
        if (k != 0)
        {
          n = 1;
        }
        else
        {
          localObject1 = new StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
          ((StringBuilder)localObject1).append(Integer.toHexString(n));
          throw new NumberFormatException(((StringBuilder)localObject1).toString());
        }
        if (m == i1)
        {
          this.a = ((alk)localObject1).b();
          all.a((alk)localObject1);
        }
        else
        {
          ((alk)localObject1).b = m;
        }
        if (n != 0) {
          break;
        }
        l1 = l2;
        i = k;
        j = n;
      } while (this.a != null);
      label272:
      this.b -= k;
      return l2;
    }
    throw new IllegalStateException("size == 0");
  }
  
  public final alb l()
  {
    return new alb(o());
  }
  
  public final String m()
  {
    try
    {
      String str = a(this.b, alq.a);
      return str;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public final String n()
  {
    return d(9223372036854775807L);
  }
  
  public final byte[] o()
  {
    try
    {
      byte[] arrayOfByte = f(this.b);
      return arrayOfByte;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public final void p()
  {
    try
    {
      g(this.b);
      return;
    }
    catch (EOFException localEOFException)
    {
      throw new AssertionError(localEOFException);
    }
  }
  
  public final long q()
  {
    return a((byte)0, 0L, 9223372036854775807L);
  }
  
  public final int read(ByteBuffer paramByteBuffer)
  {
    alk localalk = this.a;
    if (localalk == null) {
      return -1;
    }
    int i = Math.min(paramByteBuffer.remaining(), localalk.c - localalk.b);
    paramByteBuffer.put(localalk.a, localalk.b, i);
    localalk.b += i;
    this.b -= i;
    if (localalk.b == localalk.c)
    {
      this.a = localalk.b();
      all.a(localalk);
    }
    return i;
  }
  
  public final String toString()
  {
    long l = this.b;
    if (l <= 2147483647L)
    {
      int i = (int)l;
      if (i == 0) {
        localObject = alb.b;
      } else {
        localObject = new alm(this, i);
      }
      return ((alb)localObject).toString();
    }
    Object localObject = new StringBuilder("size > Integer.MAX_VALUE: ");
    ((StringBuilder)localObject).append(this.b);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public final int write(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer != null)
    {
      int j = paramByteBuffer.remaining();
      int i = j;
      while (i > 0)
      {
        alk localalk = e(1);
        int k = Math.min(i, 8192 - localalk.c);
        paramByteBuffer.get(localalk.a, localalk.c, k);
        i -= k;
        localalk.c += k;
      }
      this.b += j;
      return j;
    }
    throw new IllegalArgumentException("source == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aky
 * JD-Core Version:    0.7.0.1
 */