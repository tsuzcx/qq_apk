package com.tencent.turingfd.sdk.base;

public final class j
{
  public static j a;
  public static int b;
  public static Object c = new Object();
  public j d;
  public boolean e;
  public int f;
  public int g;
  public int h;
  public float i;
  public float j;
  public float k;
  public float l;
  public String m = "";
  
  public static j a()
  {
    synchronized (c)
    {
      if (b > 0)
      {
        localj = a;
        a = a.d;
        localj.d = null;
        localj.e = false;
        b -= 1;
        return localj;
      }
      j localj = new j();
      return localj;
    }
  }
  
  public void b()
  {
    if (!this.e) {
      synchronized (c)
      {
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0.0F;
        this.j = 0.0F;
        this.k = 0.0F;
        this.l = 0.0F;
        this.m = "";
        if (b < 20)
        {
          this.d = a;
          this.e = true;
          a = this;
          b += 1;
        }
        return;
      }
    }
    throw new IllegalStateException("Already recycled.");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action : ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",deviceId : ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",toolType : ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",rawX : ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",rawY : ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",pressure : ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(",size : ");
    localStringBuilder.append(this.l);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.j
 * JD-Core Version:    0.7.0.1
 */