package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class i
  implements q
{
  private int a = 0;
  private final e b;
  private final Inflater c;
  private final j d;
  private final CRC32 e = new CRC32();
  
  public i(q paramq)
  {
    if (paramq != null)
    {
      this.c = new Inflater(true);
      this.b = k.a(paramq);
      this.d = new j(this.b, this.c);
      return;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return;
    }
    throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
  }
  
  private void a(c paramc, long paramLong1, long paramLong2)
  {
    for (paramc = paramc.a; paramLong1 >= paramc.c - paramc.b; paramc = paramc.f) {
      paramLong1 -= paramc.c - paramc.b;
    }
    while (paramLong2 > 0L)
    {
      int i = (int)(paramc.b + paramLong1);
      int j = (int)Math.min(paramc.c - i, paramLong2);
      this.e.update(paramc.a, i, j);
      paramLong2 -= j;
      paramc = paramc.f;
      paramLong1 = 0L;
    }
  }
  
  private void b()
  {
    this.b.a(10L);
    int j = this.b.c().b(3L);
    int i;
    if ((j >> 1 & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      a(this.b.c(), 0L, 10L);
    }
    a("ID1ID2", 8075, this.b.i());
    this.b.h(8L);
    long l;
    if ((j >> 2 & 0x1) == 1)
    {
      this.b.a(2L);
      if (i != 0) {
        a(this.b.c(), 0L, 2L);
      }
      int k = this.b.c().k();
      e locale = this.b;
      l = k;
      locale.a(l);
      if (i != 0) {
        a(this.b.c(), 0L, l);
      }
      this.b.h(l);
    }
    if ((j >> 3 & 0x1) == 1)
    {
      l = this.b.a((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          a(this.b.c(), 0L, l + 1L);
        }
        this.b.h(l + 1L);
      }
      else
      {
        throw new EOFException();
      }
    }
    if ((j >> 4 & 0x1) == 1)
    {
      l = this.b.a((byte)0);
      if (l != -1L)
      {
        if (i != 0) {
          a(this.b.c(), 0L, l + 1L);
        }
        this.b.h(l + 1L);
      }
      else
      {
        throw new EOFException();
      }
    }
    if (i != 0)
    {
      a("FHCRC", this.b.k(), (short)(int)this.e.getValue());
      this.e.reset();
    }
  }
  
  private void c()
  {
    a("CRC", this.b.l(), (int)this.e.getValue());
    a("ISIZE", this.b.l(), (int)this.c.getBytesWritten());
  }
  
  public long a(c paramc, long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 0L) {
        return 0L;
      }
      if (this.a == 0)
      {
        b();
        this.a = 1;
      }
      if (this.a == 1)
      {
        long l = paramc.b;
        paramLong = this.d.a(paramc, paramLong);
        if (paramLong != -1L)
        {
          a(paramc, l, paramLong);
          return paramLong;
        }
        this.a = 2;
      }
      if (this.a == 2)
      {
        c();
        this.a = 3;
        if (this.b.e()) {
          return -1L;
        }
        throw new IOException("gzip finished without exhausting source");
      }
      return -1L;
    }
    paramc = new StringBuilder();
    paramc.append("byteCount < 0: ");
    paramc.append(paramLong);
    throw new IllegalArgumentException(paramc.toString());
  }
  
  public r a()
  {
    return this.b.a();
  }
  
  public void close()
  {
    this.d.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.i
 * JD-Core Version:    0.7.0.1
 */