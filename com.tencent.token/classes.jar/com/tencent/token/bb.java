package com.tencent.token;

import java.util.concurrent.Executor;

public class bb
  extends bd
{
  private static volatile bb b;
  private static final Executor d = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      bb.a().b(paramAnonymousRunnable);
    }
  };
  private static final Executor e = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      bb.a().a(paramAnonymousRunnable);
    }
  };
  public bd a = this.c;
  private bd c = new bc();
  
  public static bb a()
  {
    if (b != null) {
      return b;
    }
    try
    {
      if (b == null) {
        b = new bb();
      }
      return b;
    }
    finally {}
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.a.a(paramRunnable);
  }
  
  public final void b(Runnable paramRunnable)
  {
    this.a.b(paramRunnable);
  }
  
  public final boolean b()
  {
    return this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bb
 * JD-Core Version:    0.7.0.1
 */