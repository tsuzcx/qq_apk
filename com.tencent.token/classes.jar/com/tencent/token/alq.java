package com.tencent.token;

public abstract class alq
  implements Runnable
{
  protected final String b;
  
  public alq(String paramString, Object... paramVarArgs)
  {
    this.b = alr.a(paramString, paramVarArgs);
  }
  
  protected abstract void b();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.b);
    try
    {
      b();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.alq
 * JD-Core Version:    0.7.0.1
 */