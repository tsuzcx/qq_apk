package com.tencent.token.global.taiji;

class i
  implements Comparable, Runnable
{
  private t b = new t();
  
  public i(d paramd, int paramInt, Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    if (paramString != null)
    {
      paramd = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      paramd = paramRunnable.getClass().getName();
    }
    this.b.a = 1;
    this.b.d = paramInt;
    this.b.c = paramd;
    this.b.b = paramLong;
    this.b.i = paramRunnable;
    this.b.h = paramBoolean;
    this.b.j = paramObject;
    this.b.e = System.currentTimeMillis();
  }
  
  public int a(i parami)
  {
    int k = (int)(Math.abs(System.currentTimeMillis() - this.b.e) / 200L);
    int j = this.b.d;
    int i = j;
    if (k > 0) {
      i = j + k;
    }
    return parami.b.d - i;
  }
  
  public t a()
  {
    return this.b;
  }
  
  public void run()
  {
    if ((this.b != null) && (this.b.i != null)) {
      this.b.i.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.i
 * JD-Core Version:    0.7.0.1
 */