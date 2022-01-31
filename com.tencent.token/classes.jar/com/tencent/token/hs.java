package com.tencent.token;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.af;
import okhttp3.ak;
import okio.f;
import okio.i;

class hs
  extends hq
{
  private final af f;
  private long g = -1L;
  private boolean h = true;
  
  hs(ho paramho, af paramaf)
  {
    super(paramho, null);
    this.f = paramaf;
  }
  
  private void b()
  {
    if (this.g != -1L) {
      this.e.c.p();
    }
    try
    {
      this.g = this.e.c.m();
      String str = this.e.c.p().trim();
      if ((this.g < 0L) || ((!str.isEmpty()) && (!str.startsWith(";")))) {
        throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + str + "\"");
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ProtocolException(localNumberFormatException.getMessage());
    }
    if (this.g == 0L)
    {
      this.h = false;
      hg.a(this.e.a.g(), this.f, this.e.c());
      a(true, null);
    }
  }
  
  public long a(f paramf, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.b) {
      throw new IllegalStateException("closed");
    }
    if (!this.h) {}
    do
    {
      return -1L;
      if ((this.g != 0L) && (this.g != -1L)) {
        break;
      }
      b();
    } while (!this.h);
    paramLong = super.a(paramf, Math.min(paramLong, this.g));
    if (paramLong == -1L)
    {
      paramf = new ProtocolException("unexpected end of stream");
      a(false, paramf);
      throw paramf;
    }
    this.g -= paramLong;
    return paramLong;
  }
  
  public void close()
  {
    if (this.b) {
      return;
    }
    if ((this.h) && (!gn.a(this, 100, TimeUnit.MILLISECONDS))) {
      a(false, null);
    }
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hs
 * JD-Core Version:    0.7.0.1
 */