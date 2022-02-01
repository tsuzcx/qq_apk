package com.tencent.map.sdk.a;

public final class jq
  implements he
{
  public lw a = null;
  public jp b = null;
  public qe c = null;
  
  public jq(lw paramlw, qe paramqe)
  {
    this.a = paramlw;
    this.c = paramqe;
  }
  
  public final void a()
  {
    if (this.b != null) {
      synchronized (this.b)
      {
        this.b.notify();
        return;
      }
    }
  }
  
  public final void b()
  {
    jp localjp;
    if (this.b != null)
    {
      localjp = this.b;
      localjp.a = false;
    }
    try
    {
      localjp.notifyAll();
      a();
      return;
    }
    finally {}
  }
  
  public final void c()
  {
    if (this.a == null) {}
    do
    {
      return;
      this.a.c.b(this);
    } while (this.b == null);
    jp localjp = this.b;
    localjp.b = true;
    try
    {
      localjp.notifyAll();
      localjp.interrupt();
      this.b = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jq
 * JD-Core Version:    0.7.0.1
 */