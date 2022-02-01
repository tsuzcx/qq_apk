package com.tencent.token;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class ant
  implements anu, anv, Cloneable, ByteChannel
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  @Nullable
  aof a;
  public long b;
  
  private String a(long paramLong, Charset paramCharset)
  {
    aol.a(this.b, 0L, paramLong);
    if (paramCharset != null)
    {
      if (paramLong <= 2147483647L)
      {
        if (paramLong == 0L) {
          return "";
        }
        aof localaof = this.a;
        if (localaof.b + paramLong > localaof.c) {
          return new String(f(paramLong), paramCharset);
        }
        paramCharset = new String(localaof.a, localaof.b, (int)paramLong, paramCharset);
        localaof.b = ((int)(localaof.b + paramLong));
        this.b -= paramLong;
        if (localaof.b == localaof.c)
        {
          this.a = localaof.b();
          aog.a(localaof);
        }
        return paramCharset;
      }
      throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(paramLong)));
    }
    throw new IllegalArgumentException("charset == null");
  }
  
  private String l(long paramLong)
  {
    return a(paramLong, aol.a);
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    aol.a(paramArrayOfByte.length, paramInt1, paramInt2);
    aof localaof = this.a;
    if (localaof == null) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, localaof.c - localaof.b);
    System.arraycopy(localaof.a, localaof.b, paramArrayOfByte, paramInt1, paramInt2);
    localaof.b += paramInt2;
    this.b -= paramInt2;
    if (localaof.b == localaof.c)
    {
      this.a = localaof.b();
      aog.a(localaof);
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
      aof localaof = this.a;
      if (localaof == null) {
        return -1L;
      }
      paramLong2 = this.b;
      if (paramLong2 - paramLong1 < paramLong1)
      {
        while (paramLong2 > paramLong1)
        {
          localaof = localaof.g;
          paramLong2 -= localaof.c - localaof.b;
        }
      }
      else
      {
        long l2;
        for (paramLong2 = 0L;; paramLong2 = l2)
        {
          l2 = localaof.c - localaof.b + paramLong2;
          if (l2 >= paramLong1) {
            break;
          }
          localaof = localaof.f;
        }
      }
      while (paramLong2 < l1)
      {
        byte[] arrayOfByte = localaof.a;
        int j = (int)Math.min(localaof.c, localaof.b + l1 - paramLong2);
        int i = (int)(localaof.b + paramLong1 - paramLong2);
        while (i < j)
        {
          if (arrayOfByte[i] == paramByte) {
            return i - localaof.b + paramLong2;
          }
          i += 1;
        }
        paramLong1 = localaof.c - localaof.b + paramLong2;
        localaof = localaof.f;
        paramLong2 = paramLong1;
      }
      return -1L;
    }
    throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[] { Long.valueOf(this.b), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public final long a(ant paramant, long paramLong)
  {
    if (paramant != null)
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
        paramant.a_(this, l1);
        return l1;
      }
      throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
    }
    throw new IllegalArgumentException("sink == null");
  }
  
  public final long a(aoj paramaoj)
  {
    if (paramaoj != null)
    {
      long l2;
      for (long l1 = 0L;; l1 += l2)
      {
        l2 = paramaoj.a(this, 8192L);
        if (l2 == -1L) {
          break;
        }
      }
      return l1;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public final ant a(int paramInt)
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
  
  public final ant a(ant paramant, long paramLong1, long paramLong2)
  {
    if (paramant != null)
    {
      aol.a(this.b, paramLong1, paramLong2);
      if (paramLong2 == 0L) {
        return this;
      }
      paramant.b += paramLong2;
      aof localaof2;
      long l1;
      long l2;
      for (aof localaof1 = this.a;; localaof1 = localaof1.f)
      {
        localaof2 = localaof1;
        l1 = paramLong1;
        l2 = paramLong2;
        if (paramLong1 < localaof1.c - localaof1.b) {
          break;
        }
        paramLong1 -= localaof1.c - localaof1.b;
      }
      while (l2 > 0L)
      {
        localaof1 = localaof2.a();
        localaof1.b = ((int)(localaof1.b + l1));
        localaof1.c = Math.min(localaof1.b + (int)l2, localaof1.c);
        aof localaof3 = paramant.a;
        if (localaof3 == null)
        {
          localaof1.g = localaof1;
          localaof1.f = localaof1;
          paramant.a = localaof1;
        }
        else
        {
          localaof3.g.a(localaof1);
        }
        l2 -= localaof1.c - localaof1.b;
        localaof2 = localaof2.f;
        l1 = 0L;
      }
      return this;
    }
    throw new IllegalArgumentException("out == null");
  }
  
  public final ant a(anw paramanw)
  {
    if (paramanw != null)
    {
      paramanw.a(this);
      return this;
    }
    throw new IllegalArgumentException("byteString == null");
  }
  
  public final ant a(String paramString)
  {
    return a(paramString, 0, paramString.length());
  }
  
  public final ant a(String paramString, int paramInt1, int paramInt2)
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
                byte[] arrayOfByte = ((aof)localObject).a;
                i = ((aof)localObject).c - paramInt1;
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
                i = i + paramInt1 - ((aof)localObject).c;
                ((aof)localObject).c += i;
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
  
  public final aok a()
  {
    return aok.c;
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
  
  public final void a_(ant paramant, long paramLong)
  {
    if (paramant != null)
    {
      if (paramant != this)
      {
        aol.a(paramant.b, 0L, paramLong);
        while (paramLong > 0L)
        {
          long l = paramant.a.c - paramant.a.b;
          int j = 0;
          int i;
          if (paramLong < l)
          {
            localaof1 = this.a;
            if (localaof1 != null) {
              localaof1 = localaof1.g;
            } else {
              localaof1 = null;
            }
            if ((localaof1 != null) && (localaof1.e))
            {
              l = localaof1.c;
              if (localaof1.d) {
                i = 0;
              } else {
                i = localaof1.b;
              }
              if (l + paramLong - i <= 8192L)
              {
                paramant.a.a(localaof1, (int)paramLong);
                paramant.b -= paramLong;
                this.b += paramLong;
                return;
              }
            }
            localaof2 = paramant.a;
            i = (int)paramLong;
            if ((i > 0) && (i <= localaof2.c - localaof2.b))
            {
              if (i >= 1024)
              {
                localaof1 = localaof2.a();
              }
              else
              {
                localaof1 = aog.a();
                System.arraycopy(localaof2.a, localaof2.b, localaof1.a, 0, i);
              }
              localaof1.c = (localaof1.b + i);
              localaof2.b += i;
              localaof2.g.a(localaof1);
              paramant.a = localaof1;
            }
            else
            {
              throw new IllegalArgumentException();
            }
          }
          aof localaof1 = paramant.a;
          l = localaof1.c - localaof1.b;
          paramant.a = localaof1.b();
          aof localaof2 = this.a;
          if (localaof2 == null)
          {
            this.a = localaof1;
            localaof1 = this.a;
            localaof1.g = localaof1;
            localaof1.f = localaof1;
          }
          else
          {
            localaof1 = localaof2.g.a(localaof1);
            if (localaof1.g == localaof1) {
              break label514;
            }
            if (localaof1.g.e)
            {
              int k = localaof1.c - localaof1.b;
              int m = localaof1.g.c;
              if (localaof1.g.d) {
                i = j;
              } else {
                i = localaof1.g.b;
              }
              if (k <= 8192 - m + i)
              {
                localaof1.a(localaof1.g, k);
                localaof1.b();
                aog.a(localaof1);
              }
            }
          }
          paramant.b -= l;
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
    aol.a(this.b, paramLong, 1L);
    long l = this.b;
    if (l - paramLong > paramLong) {
      for (localObject = this.a;; localObject = ((aof)localObject).f)
      {
        l = ((aof)localObject).c - ((aof)localObject).b;
        if (paramLong < l) {
          return localObject.a[(localObject.b + (int)paramLong)];
        }
        paramLong -= l;
      }
    }
    paramLong -= l;
    Object localObject = this.a;
    aof localaof;
    do
    {
      localaof = ((aof)localObject).g;
      l = paramLong + (localaof.c - localaof.b);
      localObject = localaof;
      paramLong = l;
    } while (l < 0L);
    return localaof.a[(localaof.b + (int)l)];
  }
  
  public final ant b()
  {
    return this;
  }
  
  public final ant b(int paramInt)
  {
    aof localaof = e(1);
    byte[] arrayOfByte = localaof.a;
    int i = localaof.c;
    localaof.c = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    this.b += 1L;
    return this;
  }
  
  public final ant b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return b(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public final ant b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      long l1 = paramArrayOfByte.length;
      long l2 = paramInt1;
      long l3 = paramInt2;
      aol.a(l1, l2, l3);
      paramInt2 += paramInt1;
      while (paramInt1 < paramInt2)
      {
        aof localaof = e(1);
        int i = Math.min(paramInt2 - paramInt1, 8192 - localaof.c);
        System.arraycopy(paramArrayOfByte, paramInt1, localaof.a, localaof.c, i);
        paramInt1 += i;
        localaof.c += i;
      }
      this.b += l3;
      return this;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public final ant c(int paramInt)
  {
    aof localaof = e(2);
    byte[] arrayOfByte = localaof.a;
    int i = localaof.c;
    int j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[j] = ((byte)(paramInt & 0xFF));
    localaof.c = (j + 1);
    this.b += 2L;
    return this;
  }
  
  public final anw c(long paramLong)
  {
    return new anw(f(paramLong));
  }
  
  public final boolean c()
  {
    return this.b == 0L;
  }
  
  public final void close() {}
  
  public final ant d(int paramInt)
  {
    aof localaof = e(4);
    byte[] arrayOfByte = localaof.a;
    int j = localaof.c;
    int i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 24 & 0xFF));
    j = i + 1;
    arrayOfByte[i] = ((byte)(paramInt >>> 16 & 0xFF));
    i = j + 1;
    arrayOfByte[j] = ((byte)(paramInt >>> 8 & 0xFF));
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
    localaof.c = (i + 1);
    this.b += 4L;
    return this;
  }
  
  public final InputStream d()
  {
    new InputStream()
    {
      public final int available()
      {
        return (int)Math.min(ant.this.b, 2147483647L);
      }
      
      public final void close() {}
      
      public final int read()
      {
        if (ant.this.b > 0L) {
          return ant.this.f() & 0xFF;
        }
        return -1;
      }
      
      public final int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return ant.this.a(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public final String toString()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ant.this);
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
      ant localant = new ant();
      a(localant, 0L, Math.min(32L, this.b));
      StringBuilder localStringBuilder = new StringBuilder("\\n not found: limit=");
      localStringBuilder.append(Math.min(this.b, paramLong));
      localStringBuilder.append(" content=");
      localStringBuilder.append(localant.l().e());
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
    aof localaof = this.a.g;
    long l1 = l2;
    if (localaof.c < 8192)
    {
      l1 = l2;
      if (localaof.e) {
        l1 = l2 - (localaof.c - localaof.b);
      }
    }
    return l1;
  }
  
  final aof e(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= 8192))
    {
      Object localObject = this.a;
      if (localObject == null)
      {
        this.a = aog.a();
        localObject = this.a;
        ((aof)localObject).g = ((aof)localObject);
        ((aof)localObject).f = ((aof)localObject);
        return localObject;
      }
      aof localaof = ((aof)localObject).g;
      if (localaof.c + paramInt <= 8192)
      {
        localObject = localaof;
        if (localaof.e) {}
      }
      else
      {
        localObject = localaof.a(aog.a());
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
    if (!(paramObject instanceof ant)) {
      return false;
    }
    paramObject = (ant)paramObject;
    long l2 = this.b;
    if (l2 != paramObject.b) {
      return false;
    }
    long l1 = 0L;
    if (l2 == 0L) {
      return true;
    }
    aof localaof = this.a;
    paramObject = paramObject.a;
    int j = localaof.b;
    int i = paramObject.b;
    while (l1 < this.b)
    {
      l2 = Math.min(localaof.c - j, paramObject.c - i);
      int k = 0;
      while (k < l2)
      {
        if (localaof.a[j] != paramObject.a[i]) {
          return false;
        }
        k += 1;
        j += 1;
        i += 1;
      }
      if (j == localaof.c)
      {
        localaof = localaof.f;
        j = localaof.b;
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
      aof localaof = this.a;
      int i = localaof.b;
      int j = localaof.c;
      byte[] arrayOfByte = localaof.a;
      int k = i + 1;
      byte b1 = arrayOfByte[i];
      this.b -= 1L;
      if (k == j)
      {
        this.a = localaof.b();
        aog.a(localaof);
        return b1;
      }
      localaof.b = k;
      return b1;
    }
    throw new IllegalStateException("size == 0");
  }
  
  public final byte[] f(long paramLong)
  {
    aol.a(this.b, 0L, paramLong);
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
      int k = ((aof)localObject).b;
      int i = ((aof)localObject).c;
      if (i - k < 2) {
        return (short)((f() & 0xFF) << 8 | f() & 0xFF);
      }
      byte[] arrayOfByte = ((aof)localObject).a;
      int j = k + 1;
      k = arrayOfByte[k];
      int m = j + 1;
      j = arrayOfByte[j];
      this.b -= 2L;
      if (m == i)
      {
        this.a = ((aof)localObject).b();
        aog.a((aof)localObject);
      }
      else
      {
        ((aof)localObject).b = m;
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
      aof localaof = this.a;
      if (localaof != null)
      {
        int i = (int)Math.min(paramLong, localaof.c - this.a.b);
        long l1 = this.b;
        long l2 = i;
        this.b = (l1 - l2);
        l1 = paramLong - l2;
        localaof = this.a;
        localaof.b += i;
        paramLong = l1;
        if (this.a.b == this.a.c)
        {
          localaof = this.a;
          this.a = localaof.b();
          aog.a(localaof);
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
      int j = ((aof)localObject).b;
      int i = ((aof)localObject).c;
      if (i - j < 4) {
        return (f() & 0xFF) << 24 | (f() & 0xFF) << 16 | (f() & 0xFF) << 8 | f() & 0xFF;
      }
      byte[] arrayOfByte = ((aof)localObject).a;
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
        this.a = ((aof)localObject).b();
        aog.a((aof)localObject);
        return j;
      }
      ((aof)localObject).b = n;
      return j;
    }
    Object localObject = new StringBuilder("size < 4: ");
    ((StringBuilder)localObject).append(this.b);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public final ant h(long paramLong)
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
    aof localaof = e(k);
    byte[] arrayOfByte = localaof.a;
    i = localaof.c + k;
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
    localaof.c += k;
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
    aof localaof;
    do
    {
      int k = ((aof)localObject).b;
      int m = ((aof)localObject).c;
      j = i;
      while (k < m)
      {
        j = j * 31 + localObject.a[k];
        k += 1;
      }
      localaof = ((aof)localObject).f;
      localObject = localaof;
      i = j;
    } while (localaof != this.a);
    return j;
  }
  
  public final ant i(long paramLong)
  {
    if (paramLong == 0L) {
      return b(48);
    }
    int j = Long.numberOfTrailingZeros(Long.highestOneBit(paramLong)) / 4 + 1;
    aof localaof = e(j);
    byte[] arrayOfByte = localaof.a;
    int i = localaof.c + j - 1;
    int k = localaof.c;
    while (i >= k)
    {
      arrayOfByte[i] = c[((int)(0xF & paramLong))];
      paramLong >>>= 4;
      i -= 1;
    }
    localaof.c += j;
    this.b += j;
    return this;
  }
  
  public final short i()
  {
    return aol.a(g());
  }
  
  public final boolean isOpen()
  {
    return true;
  }
  
  public final int j()
  {
    return aol.a(h());
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
        Object localObject2 = ((aof)localObject1).a;
        int m = ((aof)localObject1).b;
        int i1 = ((aof)localObject1).c;
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
        localObject1 = new ant().i(l2).b(n);
        localObject2 = new StringBuilder("Number too large: ");
        ((StringBuilder)localObject2).append(((ant)localObject1).m());
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
          this.a = ((aof)localObject1).b();
          aog.a((aof)localObject1);
        }
        else
        {
          ((aof)localObject1).b = m;
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
  
  public final anw l()
  {
    return new anw(o());
  }
  
  public final String m()
  {
    try
    {
      String str = a(this.b, aol.a);
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
    aof localaof = this.a;
    if (localaof == null) {
      return -1;
    }
    int i = Math.min(paramByteBuffer.remaining(), localaof.c - localaof.b);
    paramByteBuffer.put(localaof.a, localaof.b, i);
    localaof.b += i;
    this.b -= i;
    if (localaof.b == localaof.c)
    {
      this.a = localaof.b();
      aog.a(localaof);
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
        localObject = anw.b;
      } else {
        localObject = new aoh(this, i);
      }
      return ((anw)localObject).toString();
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
        aof localaof = e(1);
        int k = Math.min(i, 8192 - localaof.c);
        paramByteBuffer.get(localaof.a, localaof.c, k);
        i -= k;
        localaof.c += k;
      }
      this.b += j;
      return j;
    }
    throw new IllegalArgumentException("source == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ant
 * JD-Core Version:    0.7.0.1
 */