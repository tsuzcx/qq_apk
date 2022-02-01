package com.tencent.token;

import com.tencent.wcdb.support.OperationCanceledException;

public final class ags
{
  private boolean a;
  private a b;
  private boolean c;
  
  private boolean b()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally {}
  }
  
  private void c()
  {
    while (this.c) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        label14:
        break label14;
      }
    }
  }
  
  public final void a()
  {
    if (!b()) {
      return;
    }
    throw new OperationCanceledException();
  }
  
  public final void a(a parama)
  {
    try
    {
      c();
      if (this.b == parama) {
        return;
      }
      this.b = parama;
      if ((this.a) && (parama != null))
      {
        parama.c();
        return;
      }
      return;
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ags
 * JD-Core Version:    0.7.0.1
 */