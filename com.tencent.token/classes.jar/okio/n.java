package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class n
  implements y
{
  private final i a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  n(i parami, Inflater paramInflater)
  {
    if (parami == null) {
      throw new IllegalArgumentException("source == null");
    }
    if (paramInflater == null) {
      throw new IllegalArgumentException("inflater == null");
    }
    this.a = parami;
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
  
  public long a(f paramf, long paramLong)
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
        v localv = paramf.e(1);
        int i = (int)Math.min(paramLong, 8192 - localv.c);
        i = this.b.inflate(localv.a, localv.c, i);
        if (i > 0)
        {
          localv.c += i;
          paramf.b += i;
          return i;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          c();
          if (localv.b == localv.c)
          {
            paramf.a = localv.b();
            w.a(localv);
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
      catch (DataFormatException paramf)
      {
        throw new IOException(paramf);
      }
    }
    return -1L;
  }
  
  public z a()
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
    v localv = this.a.c().a;
    this.c = (localv.c - localv.b);
    this.b.setInput(localv.a, localv.b, this.c);
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
 * Qualified Name:     okio.n
 * JD-Core Version:    0.7.0.1
 */