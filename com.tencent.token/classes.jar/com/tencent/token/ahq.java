package com.tencent.token;

import java.io.Closeable;

public abstract class ahq
  implements Closeable
{
  private int a = 1;
  
  protected abstract void c();
  
  public void close()
  {
    e();
  }
  
  public final void d()
  {
    try
    {
      if (this.a > 0)
      {
        this.a += 1;
        return;
      }
      throw new IllegalStateException("attempt to re-open an already-closed object: ".concat(String.valueOf(this)));
    }
    finally {}
  }
  
  public final void e()
  {
    for (;;)
    {
      try
      {
        int j = this.a;
        i = 1;
        j -= 1;
        this.a = j;
        if (j == 0)
        {
          if (i != 0) {
            c();
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahq
 * JD-Core Version:    0.7.0.1
 */