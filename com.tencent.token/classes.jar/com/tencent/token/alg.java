package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class alg
  implements alp
{
  private int a = 0;
  private final alb b;
  private final Inflater c;
  private final alh d;
  private final CRC32 e = new CRC32();
  
  public alg(alp paramalp)
  {
    if (paramalp != null)
    {
      this.c = new Inflater(true);
      this.b = ali.a(paramalp);
      this.d = new alh(this.b, this.c);
      return;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  private void a(akz paramakz, long paramLong1, long paramLong2)
  {
    for (paramakz = paramakz.a; paramLong1 >= paramakz.c - paramakz.b; paramakz = paramakz.f) {
      paramLong1 -= paramakz.c - paramakz.b;
    }
    while (paramLong2 > 0L)
    {
      int i = (int)(paramakz.b + paramLong1);
      int j = (int)Math.min(paramakz.c - i, paramLong2);
      this.e.update(paramakz.a, i, j);
      paramLong2 -= j;
      paramakz = paramakz.f;
      paramLong1 = 0L;
    }
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return;
    }
    throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
  }
  
  public final long a(akz paramakz, long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 0L) {
        return 0L;
      }
      long l;
      if (this.a == 0)
      {
        this.b.a(10L);
        int j = this.b.b().b(3L);
        int i;
        if ((j >> 1 & 0x1) == 1) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          a(this.b.b(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.g());
        this.b.g(8L);
        if ((j >> 2 & 0x1) == 1)
        {
          this.b.a(2L);
          if (i != 0) {
            a(this.b.b(), 0L, 2L);
          }
          int k = this.b.b().i();
          alb localalb = this.b;
          l = k;
          localalb.a(l);
          if (i != 0) {
            a(this.b.b(), 0L, l);
          }
          this.b.g(l);
        }
        if ((j >> 3 & 0x1) == 1)
        {
          l = this.b.q();
          if (l != -1L)
          {
            if (i != 0) {
              a(this.b.b(), 0L, l + 1L);
            }
            this.b.g(l + 1L);
          }
          else
          {
            throw new EOFException();
          }
        }
        if ((j >> 4 & 0x1) == 1)
        {
          l = this.b.q();
          if (l != -1L)
          {
            if (i != 0) {
              a(this.b.b(), 0L, l + 1L);
            }
            this.b.g(l + 1L);
          }
          else
          {
            throw new EOFException();
          }
        }
        if (i != 0)
        {
          a("FHCRC", this.b.i(), (short)(int)this.e.getValue());
          this.e.reset();
        }
        this.a = 1;
      }
      if (this.a == 1)
      {
        l = paramakz.b;
        paramLong = this.d.a(paramakz, paramLong);
        if (paramLong != -1L)
        {
          a(paramakz, l, paramLong);
          return paramLong;
        }
        this.a = 2;
      }
      if (this.a == 2)
      {
        a("CRC", this.b.j(), (int)this.e.getValue());
        a("ISIZE", this.b.j(), (int)this.c.getBytesWritten());
        this.a = 3;
        if (this.b.c()) {
          return -1L;
        }
        throw new IOException("gzip finished without exhausting source");
      }
      return -1L;
    }
    throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
  }
  
  public final alq a()
  {
    return this.b.a();
  }
  
  public final void close()
  {
    this.d.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alg
 * JD-Core Version:    0.7.0.1
 */