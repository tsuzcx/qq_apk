package com.tencent.token;

public final class abv
{
  public static abv a;
  public static int b;
  public static Object c = new Object();
  public abv d;
  public boolean e;
  public int f;
  public int g;
  public int h;
  public float i;
  public float j;
  public float k;
  public float l;
  public String m = "";
  
  public static abv a()
  {
    synchronized (c)
    {
      if (b > 0)
      {
        localabv = a;
        a = a.d;
        localabv.d = null;
        localabv.e = false;
        b -= 1;
        return localabv;
      }
      abv localabv = new abv();
      return localabv;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("action : ");
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
 * Qualified Name:     com.tencent.token.abv
 * JD-Core Version:    0.7.0.1
 */