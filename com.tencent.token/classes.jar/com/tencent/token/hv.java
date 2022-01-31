package com.tencent.token;

import okio.f;

class hv
  extends hq
{
  private boolean f;
  
  hv(ho paramho)
  {
    super(paramho, null);
  }
  
  public long a(f paramf, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.b) {
      throw new IllegalStateException("closed");
    }
    if (this.f) {
      return -1L;
    }
    paramLong = super.a(paramf, paramLong);
    if (paramLong == -1L)
    {
      this.f = true;
      a(true, null);
      return -1L;
    }
    return paramLong;
  }
  
  public void close()
  {
    if (this.b) {
      return;
    }
    if (!this.f) {
      a(false, null);
    }
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hv
 * JD-Core Version:    0.7.0.1
 */