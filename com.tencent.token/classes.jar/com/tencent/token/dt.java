package com.tencent.token;

class dt
  extends ds
{
  int d = 1;
  
  dt() {}
  
  dt(int paramInt)
  {
    super(paramInt);
  }
  
  void a(dt paramdt)
  {
    int i = this.d;
    if (i == paramdt.d)
    {
      c(paramdt);
      return;
    }
    this.d = (i * d(paramdt));
  }
  
  void b(dt paramdt)
  {
    int i = this.d;
    if (i == paramdt.d)
    {
      this.d = (i * d(paramdt));
      return;
    }
    c(paramdt);
  }
  
  void f(ds paramds)
  {
    int i = this.d;
    if (i == 1)
    {
      c(paramds);
      return;
    }
    this.d = (i * d(paramds));
  }
  
  public String toString()
  {
    return new dr(this, this.d).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dt
 * JD-Core Version:    0.7.0.1
 */