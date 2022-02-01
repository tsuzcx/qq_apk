package com.tencent.token;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class alg
  implements alo
{
  private final ala a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  alg(ala paramala, Inflater paramInflater)
  {
    if (paramala != null)
    {
      if (paramInflater != null)
      {
        this.a = paramala;
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
  
  public final long a(aky paramaky, long paramLong)
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
      alk localalk;
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
          localalk = this.a.b().a;
          this.c = (localalk.c - localalk.b);
          this.b.setInput(localalk.a, localalk.b, this.c);
        }
      }
      label240:
      do
      {
        try
        {
          localalk = paramaky.e(1);
          int j = (int)Math.min(paramLong, 8192 - localalk.c);
          j = this.b.inflate(localalk.a, localalk.c, j);
          if (j > 0)
          {
            localalk.c += j;
            paramLong = paramaky.b;
            long l = j;
            paramaky.b = (paramLong + l);
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
          if (localalk.b == localalk.c)
          {
            paramaky.a = localalk.b();
            all.a(localalk);
          }
          return -1L;
        }
        catch (DataFormatException paramaky)
        {
          throw new IOException(paramaky);
        }
        throw new IllegalStateException("?");
        throw new IllegalStateException("closed");
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(paramLong)));
      } while (i != 0);
    }
  }
  
  public final alp a()
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
 * Qualified Name:     com.tencent.token.alg
 * JD-Core Version:    0.7.0.1
 */