package com.tencent.token;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.f;

class hu
  extends hq
{
  private long f;
  
  hu(ho paramho, long paramLong)
  {
    super(paramho, null);
    this.f = paramLong;
    if (this.f == 0L) {
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
    if (this.f == 0L) {
      return -1L;
    }
    paramLong = super.a(paramf, Math.min(this.f, paramLong));
    if (paramLong == -1L)
    {
      paramf = new ProtocolException("unexpected end of stream");
      a(false, paramf);
      throw paramf;
    }
    this.f -= paramLong;
    if (this.f == 0L) {
      a(true, null);
    }
    return paramLong;
  }
  
  public void close()
  {
    if (this.b) {
      return;
    }
    if ((this.f != 0L) && (!gn.a(this, 100, TimeUnit.MILLISECONDS))) {
      a(false, null);
    }
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hu
 * JD-Core Version:    0.7.0.1
 */