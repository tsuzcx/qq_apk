package com.tencent.token;

public abstract class fa
  implements Runnable
{
  protected final String b;
  
  public fa(String paramString, Object... paramVarArgs)
  {
    this.b = fb.a(paramString, paramVarArgs);
  }
  
  protected abstract void c();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.b);
    try
    {
      c();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fa
 * JD-Core Version:    0.7.0.1
 */