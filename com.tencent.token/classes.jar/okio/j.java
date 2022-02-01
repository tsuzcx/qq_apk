package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class j
  implements q
{
  private final e a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  j(e parame, Inflater paramInflater)
  {
    if (parame != null)
    {
      if (paramInflater != null)
      {
        this.a = parame;
        this.b = paramInflater;
        return;
      }
      throw new IllegalArgumentException("inflater == null");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  private void c()
  {
    int i = this.c;
    if (i == 0) {
      return;
    }
    i -= this.b.getRemaining();
    this.c -= i;
    this.a.h(i);
  }
  
  public long a(c paramc, long paramLong)
  {
    if (paramLong >= 0L) {
      if (!this.d) {
        if (paramLong == 0L) {
          return 0L;
        }
      }
    }
    for (;;)
    {
      boolean bool = b();
      label144:
      do
      {
        try
        {
          n localn = paramc.e(1);
          int i = (int)Math.min(paramLong, 8192 - localn.c);
          i = this.b.inflate(localn.a, localn.c, i);
          if (i > 0)
          {
            localn.c += i;
            paramLong = paramc.b;
            long l = i;
            paramc.b = (paramLong + l);
            return l;
          }
          if (!this.b.finished())
          {
            if (!this.b.needsDictionary()) {
              continue;
            }
            break label144;
            throw new EOFException("source exhausted prematurely");
          }
          c();
          if (localn.b == localn.c)
          {
            paramc.a = localn.b();
            o.a(localn);
          }
          return -1L;
        }
        catch (DataFormatException paramc)
        {
          throw new IOException(paramc);
        }
        throw new IllegalStateException("closed");
        paramc = new StringBuilder();
        paramc.append("byteCount < 0: ");
        paramc.append(paramLong);
        throw new IllegalArgumentException(paramc.toString());
      } while (bool);
    }
  }
  
  public r a()
  {
    return this.a.a();
  }
  
  public boolean b()
  {
    if (!this.b.needsInput()) {
      return false;
    }
    c();
    if (this.b.getRemaining() == 0)
    {
      if (this.a.e()) {
        return true;
      }
      n localn = this.a.c().a;
      this.c = (localn.c - localn.b);
      this.b.setInput(localn.a, localn.b, this.c);
      return false;
    }
    throw new IllegalStateException("?");
  }
  
  public void close()
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
 * Qualified Name:     okio.j
 * JD-Core Version:    0.7.0.1
 */