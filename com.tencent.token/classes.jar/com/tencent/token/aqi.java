package com.tencent.token;

public final class aqi
  implements apx
{
  private Object a = new Object();
  private int b = 1;
  
  public final int a()
  {
    synchronized (this.a)
    {
      int i = this.b;
      this.b += 1;
      return i;
    }
  }
  
  public final int b()
  {
    synchronized (this.a)
    {
      int i = this.b;
      return i;
    }
  }
  
  public final void c()
  {
    synchronized (this.a)
    {
      this.b += 1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aqi
 * JD-Core Version:    0.7.0.1
 */