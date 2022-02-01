package com.tencent.token;

class ds
  extends dr
{
  int d = 1;
  
  ds() {}
  
  ds(int paramInt)
  {
    super(paramInt);
  }
  
  void a(ds paramds)
  {
    if (this.d == paramds.d)
    {
      c(paramds);
      return;
    }
    this.d *= d(paramds);
  }
  
  void b(ds paramds)
  {
    if (this.d == paramds.d)
    {
      this.d *= d(paramds);
      return;
    }
    c(paramds);
  }
  
  void f(dr paramdr)
  {
    if (this.d == 1)
    {
      c(paramdr);
      return;
    }
    this.d *= d(paramdr);
  }
  
  public String toString()
  {
    return new dq(this, this.d).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ds
 * JD-Core Version:    0.7.0.1
 */