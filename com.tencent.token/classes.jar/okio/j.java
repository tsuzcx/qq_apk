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
    if (parame == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramInflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = parame;
    this.b = paramInflater;
  }
  
  private void c()
  {
    if (this.c == 0) {
      return;
    }
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.h(i);
  }
  
  public long a(c paramc, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    }
    if (this.d) {
      throw new IllegalStateException("closed");
    }
    if (paramLong == 0L) {
      return 0L;
    }
    for (;;)
    {
      boolean bool = b();
      try
      {
        n localn = paramc.e(1);
        int i = (int)Math.min(paramLong, 8192 - localn.c);
        i = this.b.inflate(localn.a, localn.c, i);
        if (i > 0)
        {
          localn.c += i;
          paramc.b += i;
          return i;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          c();
          if (localn.b == localn.c)
          {
            paramc.a = localn.b();
            o.a(localn);
          }
        }
        else
        {
          if (!bool) {
            continue;
          }
          throw new EOFException("source exhausted prematurely");
        }
      }
      catch (DataFormatException paramc)
      {
        throw new IOException(paramc);
      }
    }
    return -1L;
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
    if (this.b.getRemaining() != 0) {
      throw new IllegalStateException("?");
    }
    if (this.a.e()) {
      return true;
    }
    n localn = this.a.c().a;
    this.c = (localn.c - localn.b);
    this.b.setInput(localn.a, localn.b, this.c);
    return false;
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