package com.tencent.token;

public abstract class gm
  implements Runnable
{
  protected final String b;
  
  public gm(String paramString, Object... paramVarArgs)
  {
    this.b = gn.a(paramString, paramVarArgs);
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
 * Qualified Name:     com.tencent.token.gm
 * JD-Core Version:    0.7.0.1
 */