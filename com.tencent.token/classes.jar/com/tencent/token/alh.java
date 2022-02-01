package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class alh
  implements alp
{
  private final alb a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  alh(alb paramalb, Inflater paramInflater)
  {
    if (paramalb != null)
    {
      if (paramInflater != null)
      {
        this.a = paramalb;
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
  
  public final long a(akz paramakz, long paramLong)
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
      all localall;
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
          localall = this.a.b().a;
          this.c = (localall.c - localall.b);
          this.b.setInput(localall.a, localall.b, this.c);
        }
      }
      label240:
      do
      {
        try
        {
          localall = paramakz.e(1);
          int j = (int)Math.min(paramLong, 8192 - localall.c);
          j = this.b.inflate(localall.a, localall.c, j);
          if (j > 0)
          {
            localall.c += j;
            paramLong = paramakz.b;
            long l = j;
            paramakz.b = (paramLong + l);
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
          if (localall.b == localall.c)
          {
            paramakz.a = localall.b();
            alm.a(localall);
          }
          return -1L;
        }
        catch (DataFormatException paramakz)
        {
          throw new IOException(paramakz);
        }
        throw new IllegalStateException("?");
        throw new IllegalStateException("closed");
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
      } while (i != 0);
    }
  }
  
  public final alq a()
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
 * Qualified Name:     com.tencent.token.alh
 * JD-Core Version:    0.7.0.1
 */