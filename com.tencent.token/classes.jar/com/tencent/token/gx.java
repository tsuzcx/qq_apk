package com.tencent.token;

import java.io.IOException;

public final class gx
{
  final gy a;
  final boolean[] b;
  private boolean d;
  
  void a()
  {
    int i;
    if (this.a.f == this) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.c.c) {}
      try
      {
        this.c.b.a(this.a.d[i]);
        label45:
        i += 1;
        continue;
        this.a.f = null;
        return;
      }
      catch (IOException localIOException)
      {
        break label45;
      }
    }
  }
  
  public void b()
  {
    synchronized (this.c)
    {
      if (this.d) {
        throw new IllegalStateException();
      }
    }
    if (this.a.f == this) {
      this.c.a(this, false);
    }
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gx
 * JD-Core Version:    0.7.0.1
 */