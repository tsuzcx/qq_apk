package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class alf
  implements alo
{
  private int a = 0;
  private final ala b;
  private final Inflater c;
  private final alg d;
  private final CRC32 e = new CRC32();
  
  public alf(alo paramalo)
  {
    if (paramalo != null)
    {
      this.c = new Inflater(true);
      this.b = alh.a(paramalo);
      this.d = new alg(this.b, this.c);
      return;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  private void a(aky paramaky, long paramLong1, long paramLong2)
  {
    for (paramaky = paramaky.a; paramLong1 >= paramaky.c - paramaky.b; paramaky = paramaky.f) {
      paramLong1 -= paramaky.c - paramaky.b;
    }
    while (paramLong2 > 0L)
    {
      int i = (int)(paramaky.b + paramLong1);
      int j = (int)Math.min(paramaky.c - i, paramLong2);
      this.e.update(paramaky.a, i, j);
      paramLong2 -= j;
      paramaky = paramaky.f;
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
  
  public final long a(aky paramaky, long paramLong)
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
          ala localala = this.b;
          l = k;
          localala.a(l);
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
        l = paramaky.b;
        paramLong = this.d.a(paramaky, paramLong);
        if (paramLong != -1L)
        {
          a(paramaky, l, paramLong);
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
  
  public final alp a()
  {
    return this.b.a();
  }
  
  public final void close()
  {
    this.d.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alf
 * JD-Core Version:    0.7.0.1
 */