package com.tencent.token;

import java.net.ProtocolException;
import okio.f;
import okio.h;
import okio.l;
import okio.x;
import okio.z;

final class ht
  implements x
{
  private final l b = new l(this.a.d.a());
  private boolean c;
  private long d;
  
  ht(ho paramho, long paramLong)
  {
    this.d = paramLong;
  }
  
  public z a()
  {
    return this.b;
  }
  
  public void a_(f paramf, long paramLong)
  {
    if (this.c) {
      throw new IllegalStateException("closed");
    }
    gn.a(paramf.b(), 0L, paramLong);
    if (paramLong > this.d) {
      throw new ProtocolException("expected " + this.d + " bytes but received " + paramLong);
    }
    this.a.d.a_(paramf, paramLong);
    this.d -= paramLong;
  }
  
  public void close()
  {
    if (this.c) {
      return;
    }
    this.c = true;
    if (this.d > 0L) {
      throw new ProtocolException("unexpected end of stream");
    }
    this.a.a(this.b);
    this.a.e = 3;
  }
  
  public void flush()
  {
    if (this.c) {
      return;
    }
    this.a.d.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ht
 * JD-Core Version:    0.7.0.1
 */