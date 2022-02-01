package com.tencent.token;

class dr
  extends dq
{
  int d = 1;
  
  dr() {}
  
  dr(int paramInt)
  {
    super(paramInt);
  }
  
  void a(dr paramdr)
  {
    if (this.d == paramdr.d)
    {
      c(paramdr);
      return;
    }
    this.d *= d(paramdr);
  }
  
  void b(dr paramdr)
  {
    if (this.d == paramdr.d)
    {
      this.d *= d(paramdr);
      return;
    }
    c(paramdr);
  }
  
  void f(dq paramdq)
  {
    if (this.d == 1)
    {
      c(paramdq);
      return;
    }
    this.d *= d(paramdq);
  }
  
  public String toString()
  {
    return new dp(this, this.d).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dr
 * JD-Core Version:    0.7.0.1
 */