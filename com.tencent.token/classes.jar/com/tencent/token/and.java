package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class and
  implements anl
{
  private final amx a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  and(amx paramamx, Inflater paramInflater)
  {
    if (paramamx != null)
    {
      if (paramInflater != null)
      {
        this.a = paramamx;
        this.b = paramInflater;
        return;
      }
      throw new IllegalArgumentException("inflater == null");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  private void b()
  {
    int i = this.c;
    if (i == 0) {
      return;
    }
    i -= this.b.getRemaining();
    this.c -= i;
    this.a.g(i);
  }
  
  public final long a(amv paramamv, long paramLong)
  {
    if (paramLong >= 0L) {
      if (!this.d) {
        if (paramLong == 0L) {
          return 0L;
        }
      }
    }
    label285:
    for (;;)
    {
      boolean bool = this.b.needsInput();
      int i = 0;
      anh localanh;
      if (bool)
      {
        b();
        if (this.b.getRemaining() != 0) {
          break label285;
        }
        if (this.a.c())
        {
          i = 1;
        }
        else
        {
          localanh = this.a.b().a;
          this.c = (localanh.c - localanh.b);
          this.b.setInput(localanh.a, localanh.b, this.c);
        }
      }
      label240:
      do
      {
        try
        {
          localanh = paramamv.e(1);
          int j = (int)Math.min(paramLong, 8192 - localanh.c);
          j = this.b.inflate(localanh.a, localanh.c, j);
          if (j > 0)
          {
            localanh.c += j;
            paramLong = paramamv.b;
            long l = j;
            paramamv.b = (paramLong + l);
            return l;
          }
          if (!this.b.finished())
          {
            if (!this.b.needsDictionary()) {
              continue;
            }
            break label240;
            throw new EOFException("source exhausted prematurely");
          }
          b();
          if (localanh.b == localanh.c)
          {
            paramamv.a = localanh.b();
            ani.a(localanh);
          }
          return -1L;
        }
        catch (DataFormatException paramamv)
        {
          throw new IOException(paramamv);
        }
        throw new IllegalStateException("?");
        throw new IllegalStateException("closed");
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
      } while (i != 0);
    }
  }
  
  public final anm a()
  {
    return this.a.a();
  }
  
  public final void close()
  {
    if (this.d) {
      return;
    }
    this.b.end();
    this.d = true;
    this.a.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.and
 * JD-Core Version:    0.7.0.1
 */