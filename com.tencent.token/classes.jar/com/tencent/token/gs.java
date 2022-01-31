package com.tencent.token;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.f;
import okio.h;
import okio.i;
import okio.y;
import okio.z;

class gs
  implements y
{
  boolean a;
  
  gs(gr paramgr, i parami, gt paramgt, h paramh) {}
  
  public long a(f paramf, long paramLong)
  {
    try
    {
      paramLong = this.b.a(paramf, paramLong);
      if (paramLong == -1L)
      {
        if (!this.a)
        {
          this.a = true;
          this.d.close();
        }
        return -1L;
      }
    }
    catch (IOException paramf)
    {
      if (!this.a)
      {
        this.a = true;
        this.c.b();
      }
      throw paramf;
    }
    paramf.a(this.d.c(), paramf.b() - paramLong, paramLong);
    this.d.u();
    return paramLong;
  }
  
  public z a()
  {
    return this.b.a();
  }
  
  public void close()
  {
    if ((!this.a) && (!gn.a(this, 100, TimeUnit.MILLISECONDS)))
    {
      this.a = true;
      this.c.b();
    }
    this.b.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gs
 * JD-Core Version:    0.7.0.1
 */