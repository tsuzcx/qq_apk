package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class aob
  implements aoj
{
  private final anv a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  aob(anv paramanv, Inflater paramInflater)
  {
    if (paramanv != null)
    {
      if (paramInflater != null)
      {
        this.a = paramanv;
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
  
  public final long a(ant paramant, long paramLong)
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
      aof localaof;
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
          localaof = this.a.b().a;
          this.c = (localaof.c - localaof.b);
          this.b.setInput(localaof.a, localaof.b, this.c);
        }
      }
      label240:
      do
      {
        try
        {
          localaof = paramant.e(1);
          int j = (int)Math.min(paramLong, 8192 - localaof.c);
          j = this.b.inflate(localaof.a, localaof.c, j);
          if (j > 0)
          {
            localaof.c += j;
            paramLong = paramant.b;
            long l = j;
            paramant.b = (paramLong + l);
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
          if (localaof.b == localaof.c)
          {
            paramant.a = localaof.b();
            aog.a(localaof);
          }
          return -1L;
        }
        catch (DataFormatException paramant)
        {
          throw new IOException(paramant);
        }
        throw new IllegalStateException("?");
        throw new IllegalStateException("closed");
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
      } while (i != 0);
    }
  }
  
  public final aok a()
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
 * Qualified Name:     com.tencent.token.aob
 * JD-Core Version:    0.7.0.1
 */