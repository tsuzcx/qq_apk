package com.tencent.token;

import java.io.IOException;
import okhttp3.internal.connection.g;
import okio.f;
import okio.i;
import okio.l;
import okio.y;
import okio.z;

abstract class hq
  implements y
{
  protected final l a = new l(this.d.c.a());
  protected boolean b;
  protected long c = 0L;
  
  private hq(ho paramho) {}
  
  public long a(f paramf, long paramLong)
  {
    try
    {
      paramLong = this.d.c.a(paramf, paramLong);
      if (paramLong > 0L) {
        this.c += paramLong;
      }
      return paramLong;
    }
    catch (IOException paramf)
    {
      a(false, paramf);
      throw paramf;
    }
  }
  
  public z a()
  {
    return this.a;
  }
  
  protected final void a(boolean paramBoolean, IOException paramIOException)
  {
    if (this.d.e == 6) {}
    do
    {
      return;
      if (this.d.e != 5) {
        throw new IllegalStateException("state: " + this.d.e);
      }
      this.d.a(this.a);
      this.d.e = 6;
    } while (this.d.b == null);
    g localg = this.d.b;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localg.a(paramBoolean, this.d, this.c, paramIOException);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hq
 * JD-Core Version:    0.7.0.1
 */