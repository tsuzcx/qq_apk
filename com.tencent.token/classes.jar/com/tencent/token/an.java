package com.tencent.token;

import java.util.concurrent.Executor;

public class an
  extends ap
{
  private static volatile an b;
  private static final Executor d = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      an.a().b(paramAnonymousRunnable);
    }
  };
  private static final Executor e = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      an.a().a(paramAnonymousRunnable);
    }
  };
  public ap a = this.c;
  private ap c = new ao();
  
  public static an a()
  {
    if (b != null) {
      return b;
    }
    try
    {
      if (b == null) {
        b = new an();
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
 * Qualified Name:     com.tencent.token.an
 * JD-Core Version:    0.7.0.1
 */