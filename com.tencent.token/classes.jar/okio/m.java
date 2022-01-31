package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class m
  implements y
{
  private int a = 0;
  private final i b;
  private final Inflater c;
  private final n d;
  private final CRC32 e = new CRC32();
  
  public m(y paramy)
  {
    if (paramy == null) {
      throw new IllegalArgumentException("source == null");
    }
    this.c = new Inflater(true);
    this.b = o.a(paramy);
    this.d = new n(this.b, this.c);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 != paramInt1) {
      throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
  }
  
  private void a(f paramf, long paramLong1, long paramLong2)
  {
    Object localObject;
    long l1;
    long l2;
    for (paramf = paramf.a;; paramf = paramf.f)
    {
      localObject = paramf;
      l1 = paramLong1;
      l2 = paramLong2;
      if (paramLong1 < paramf.c - paramf.b) {
        break;
      }
      paramLong1 -= paramf.c - paramf.b;
    }
    while (l2 > 0L)
    {
      int i = (int)(((v)localObject).b + l1);
      int j = (int)Math.min(((v)localObject).c - i, l2);
      this.e.update(((v)localObject).a, i, j);
      l2 -= j;
      localObject = ((v)localObject).f;
      l1 = 0L;
    }
  }
  
  private void b()
  {
    this.b.a(10L);
    int j = this.b.c().b(3L);
    if ((j >> 1 & 0x1) == 1) {}
    long l;
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        a(this.b.c(), 0L, 10L);
      }
      a("ID1ID2", 8075, this.b.i());
      this.b.h(8L);
      if ((j >> 2 & 0x1) == 1)
      {
        this.b.a(2L);
        if (i != 0) {
          a(this.b.c(), 0L, 2L);
        }
        int k = this.b.c().k();
        this.b.a(k);
        if (i != 0) {
          a(this.b.c(), 0L, k);
        }
        this.b.h(k);
      }
      if ((j >> 3 & 0x1) != 1) {
        break label265;
      }
      l = this.b.a((byte)0);
      if (l != -1L) {
        break;
      }
      throw new EOFException();
    }
    if (i != 0) {
      a(this.b.c(), 0L, 1L + l);
    }
    this.b.h(1L + l);
    label265:
    if ((j >> 4 & 0x1) == 1)
    {
      l = this.b.a((byte)0);
      if (l == -1L) {
        throw new EOFException();
      }
      if (i != 0) {
        a(this.b.c(), 0L, 1L + l);
      }
      this.b.h(1L + l);
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
  
  public long a(f paramf, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
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
      long l = paramf.b;
      paramLong = this.d.a(paramf, paramLong);
      if (paramLong != -1L)
      {
        a(paramf, l, paramLong);
        return paramLong;
      }
      this.a = 2;
    }
    if (this.a == 2)
    {
      c();
      this.a = 3;
      if (!this.b.e()) {
        throw new IOException("gzip finished without exhausting source");
      }
    }
    return -1L;
  }
  
  public z a()
  {
    return this.b.a();
  }
  
  public void close()
  {
    this.d.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okio.m
 * JD-Core Version:    0.7.0.1
 */